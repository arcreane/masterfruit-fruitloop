package com.example.codingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessANumber extends AppCompatActivity {
    Difficulty m_eGameDifficulty = Difficulty.EASY;
    int m_iNumberToGuess;
    int m_iScore;
    ProgressBar m_ProgressBar;
    ListView m_GuessListView;
    ListAdapter m_GuessAdapter;
    List<Guess> m_GuessList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        m_iScore = 0;
        m_GuessList = new ArrayList<>();
        m_GuessAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, m_GuessList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = view.findViewById(android.R.id.text1);
                TextView text2 = view.findViewById(android.R.id.text2);
                text1.setText(m_GuessList.get(position).m_sHint);
                text2.setText("" + m_GuessList.get(position).m_iGuess);
                return view;
            }
        };


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_anumber);
        m_GuessListView = findViewById(R.id.hintListView);
        m_GuessListView.setAdapter(m_GuessAdapter);
        m_ProgressBar = findViewById(R.id.progressBar);

        RadioGroup rg = findViewById(R.id.difficultyRadioGroup);
        rg.setOnCheckedChangeListener((RadioGroup radioGroup, int i) -> {

            TextView tv = findViewById(R.id.difficultyTextView);
            switch (rg.getCheckedRadioButtonId()) {
                case R.id.easyRadioButton:
                    tv.setText(Difficulty.EASY.toString());
                    break;
                case R.id.mediumRadioButton:
                    tv.setText(Difficulty.MEDIUM.toString());
                    break;

                case R.id.hardRadioButton:
                    tv.setText(Difficulty.HARD.toString());
                    break;
            }
        });

        Button difficultyButton = findViewById(R.id.setDifficultyButton);
        difficultyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup rg = findViewById(R.id.difficultyRadioGroup);

                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.easyRadioButton:
                        m_eGameDifficulty = Difficulty.EASY;
                        break;
                    case R.id.mediumRadioButton:
                        m_eGameDifficulty = Difficulty.MEDIUM;
                        break;
                    case R.id.hardRadioButton:
                        m_eGameDifficulty = Difficulty.HARD;
                        break;
                    default:
                        m_eGameDifficulty = Difficulty.EASY;
                }

                toggleLayoutVisibility();

                startGame();
            }
        });
        startGame();
    }

    private void toggleLayoutVisibility() {
        LinearLayout difficultyLayout = findViewById(R.id.difficultyLayout);
        LinearLayout gameLayout = findViewById(R.id.gameLayout);
        int tmp = difficultyLayout.getVisibility();
        difficultyLayout.setVisibility(gameLayout.getVisibility());
        gameLayout.setVisibility(tmp);
    }

    private void startGame() {
        m_GuessList.clear();
        ((ArrayAdapter) m_GuessAdapter).notifyDataSetChanged();
        Random rand = new Random();
        m_iNumberToGuess = rand.nextInt(m_eGameDifficulty.m_iLimitMax);
        setProgressValues(0);
        TextView textViewInfo = findViewById(R.id.textViewInfo);
        textViewInfo.setText("");
    }

    public void makeAGuess(View view) {

        TextView editGuess = findViewById(R.id.editGuess);
        TextView textViewInfo = findViewById(R.id.textViewInfo);

        Guess guess = new Guess();
        CharSequence guessText = editGuess.getText();
        if (guessText != null) {

            try {
                guess.m_iGuess = Integer.parseInt(editGuess.getText().toString());
                setProgressValues(m_ProgressBar.getProgress() + 1);
                editGuess.setText("");
                if (m_iNumberToGuess < guess.m_iGuess)
                    guess.m_sHint = "Too high";
                else if (m_iNumberToGuess > guess.m_iGuess)
                    guess.m_sHint = "Too low";
                else {
                    endGame(true);
                    return;
                }
                textViewInfo.setText(guess.m_sHint);
                m_GuessList.add(0, guess);
                ((ArrayAdapter) m_GuessAdapter).notifyDataSetChanged();

                if (m_ProgressBar.getMax() == m_ProgressBar.getProgress())
                    endGame(false);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Don't forget to enter a number!!!", Toast.LENGTH_LONG).show();
            }

        }

    }

    private void setProgressValues(int p_iProgress) {
        m_ProgressBar.setProgress(p_iProgress, true);
        TextView progressTextView = findViewById(R.id.progressTextView);
        progressTextView.setText("" + m_ProgressBar.getProgress());
    }

    private void endGame(boolean p_bWon) {
        if (p_bWon) {
            m_iScore += m_ProgressBar.getMax() - m_ProgressBar.getProgress() + 1;
            Toast.makeText(this, "Congrats!!!!", Toast.LENGTH_LONG).show();
        } else {
            m_iScore = 0;
            Toast.makeText(this, "Sorry the number was " + m_iNumberToGuess, Toast.LENGTH_LONG).show();
        }
        TextView scoreValue = findViewById(R.id.scoreValue);
        scoreValue.setText("" + m_iScore);
        CheckBox difficultyCheckBox = findViewById(R.id.difficultyCheckBox);
        if (difficultyCheckBox.isChecked()) {
            toggleLayoutVisibility();
        } else
            startGame();
    }

    private class Guess {
        String m_sHint;
        int m_iGuess;
    }
}