package com.example.fruitloop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class StartGame extends AppCompatActivity {

    LinkedHashMap<Integer, Fruits> completeFruitList = new LinkedHashMap<>();
    LinkedHashMap<Integer, Fruits> playerGuessList = new LinkedHashMap<>();
    Integer randomKey;
    int playerTryCounter = 10;
    int playerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        // Score elements
        TextView txtScore = findViewById(R.id.txtVScore);
        TextView txtTriesLeft = findViewById(R.id.txtVTriesLeft);
        txtTriesLeft.setText(String.valueOf(playerTryCounter));

        // We start by creating a list that contains all the fruits
        completeFruitList.put(R.id.mi_strawberry, Fruits.STRAWBERRY);
        completeFruitList.put(R.id.mi_orange, Fruits.ORANGE);
        completeFruitList.put(R.id.mi_prune, Fruits.PRUNE);
        completeFruitList.put(R.id.mi_kiwi, Fruits.KIWI);
        completeFruitList.put(R.id.mi_lemon, Fruits.LEMON);
        completeFruitList.put(R.id.mi_banana, Fruits.BANANA);
        completeFruitList.put(R.id.mi_grape, Fruits.GRAPE);
        completeFruitList.put(R.id.mi_raspberry, Fruits.RASPBERRY);


        // Here we create the fruit array that the player needs to discover
        LinkedHashMap<Integer, Fruits> randomFruitSelection = new LinkedHashMap<>();
        Random rand = new Random();
        while (randomFruitSelection.size() < 4) {
            Object[] keys = completeFruitList.keySet().toArray();
            randomKey = (Integer) keys[rand.nextInt(keys.length)];
            if(!randomFruitSelection.containsKey(randomKey)){
                randomFruitSelection.put(randomKey, completeFruitList.get(randomKey));
            }
        }

        // Here we access to our imageViews
        ImageView imgVFruit1 = findViewById(R.id.imgVFruit1);
        ImageView imgVFruit2 = findViewById(R.id.imgVFruit2);
        ImageView imgVFruit3 = findViewById(R.id.imgVFruit3);
        ImageView imgVFruit4 = findViewById(R.id.imgVFruit4);
        registerForContextMenu(imgVFruit1);
        registerForContextMenu(imgVFruit2);
        registerForContextMenu(imgVFruit3);
        registerForContextMenu(imgVFruit4);

        // Here we place the logic to play the actual game
        Button btnValidation = findViewById(R.id.btnValidation);
        btnValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Here we check if the players answer is correct
                System.out.println(randomFruitSelection);
                System.out.println(playerGuessList);
                if(randomFruitSelection.equals(playerGuessList)) {
                    Toast.makeText(getApplicationContext(), "You win!", Toast.LENGTH_SHORT).show();
                    playerScore += playerTryCounter -1;
                    txtScore.setText(String.valueOf(playerScore));
                    endGamePopWindowWin();
                } else {
                    Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
                }
                playerGuessList = new LinkedHashMap<>();
                playerTryCounter -= 1;
                txtTriesLeft.setText(String.valueOf(playerTryCounter));
                if(playerTryCounter == 0) {
                    endGamePopWindowLoose();
                }

            }
        });
    }


    // Here we add our context menu to change the fruits in our row
    ImageView selectedImageView;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose a fruit");
        getMenuInflater().inflate(R.menu.fruit_selection_menu, menu);
        selectedImageView = (ImageView) v;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        selectedImageView.setImageDrawable(null);
        if(!item.getTitle().toString().contentEquals("Clear")) {
            selectedImageView.setImageBitmap(((BitmapDrawable) item.getIcon()).getBitmap());
            playerGuessList.put(item.getItemId(), getFruit(item.getTitle().toString().toUpperCase(Locale.ROOT)));
            return true;
        }
        return true;
    }

    @Override //displaying the burger menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);
        return true;
    }

    // Here we get a fruit object that matches the fruit name from the context menu
    public Fruits getFruit(String fruitName) {
        ArrayList<Fruits> fruitsArrayForMenu = new ArrayList<>();
        fruitsArrayForMenu.add(Fruits.BANANA);
        fruitsArrayForMenu.add(Fruits.GRAPE);
        fruitsArrayForMenu.add(Fruits.KIWI);
        fruitsArrayForMenu.add(Fruits.LEMON);
        fruitsArrayForMenu.add(Fruits.PRUNE);
        fruitsArrayForMenu.add(Fruits.RASPBERRY);
        fruitsArrayForMenu.add(Fruits.STRAWBERRY);
        fruitsArrayForMenu.add(Fruits.ORANGE);

        for(int i = 0; i < fruitsArrayForMenu.size(); i++) {
            if(fruitsArrayForMenu.get(i).toString().equals(fruitName)) {
                return fruitsArrayForMenu.get(i);
            }
        }
        return null;
    }

    @Override //popup to show that the index selection is taken into account
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.indice_1:
                Toast.makeText(this, "selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.indice_2:
                Toast.makeText(this, "Indice 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.quit:
                Toast.makeText(this, "Quited", Toast.LENGTH_SHORT).show();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void endGamePopWindowWin() {
        AlertDialog.Builder dialogBuilder;
        AlertDialog dialog;
        dialogBuilder = new AlertDialog.Builder(this);
        final View gameOverView = getLayoutInflater().inflate(R.layout.end_game_window_win, null);
        TextView gameOverTxt = findViewById(R.id.gameOvertxt);
        Button playAgainBtn = findViewById(R.id.btnPlayAgain);
        dialogBuilder.setView(gameOverView);
        dialog = dialogBuilder.create();
        dialog.show();
    }

    public void endGamePopWindowLoose() {
        AlertDialog.Builder dialogBuilder;
        AlertDialog dialog;
        dialogBuilder = new AlertDialog.Builder(this);
        final View gameOverView = getLayoutInflater().inflate(R.layout.end_game_window_loose, null);
        TextView gameOverTxt = findViewById(R.id.endGameLoosetxt);
        Button playAgainBtn = findViewById(R.id.endGameLoosebtn);
        dialogBuilder.setView(gameOverView);
        dialog = dialogBuilder.create();
        dialog.show();
    }
}