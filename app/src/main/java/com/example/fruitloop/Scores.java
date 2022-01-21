package com.example.fruitloop;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.stream.*;
import java.util.Scanner;

public class Scores extends AppCompatActivity {


    //String[] top5Board = new String[];
    Map<String,String,String> top5Board = new HashMap<String,String, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        Button btnBackMenu = findViewById(R.id.back_to_menu);
        TextView score1=findViewById(R.id.score1);
        TextView score2=findViewById(R.id.score2);
        TextView score3=findViewById(R.id.score3);
        TextView score4=findViewById(R.id.score4);
        TextView score5=findViewById(R.id.score5);

        TextView pseudo1=findViewById(R.id.pseudo1);
        TextView pseudo2=findViewById(R.id.pseudo2);
        TextView pseudo3=findViewById(R.id.pseudo3);
        TextView pseudo4=findViewById(R.id.pseudo4);
        TextView pseudo5=findViewById(R.id.pseudo5);

        TextView nbRound1=findViewById(R.id.nbRound1);
        TextView nbRound2=findViewById(R.id.nbRound2);
        TextView nbRound3=findViewById(R.id.nbRound3);
        TextView nbRound4=findViewById(R.id.nbRound4);
        TextView nbRound5=findViewById(R.id.nbRound5);

        Map.put(score1,pseudo1,nbRound1);
        Map.put(score2,pseudo2,nbRound2);
        Map.put(score3,pseudo3,nbRound3);
        Map.put(score4,pseudo4,nbRound4);
        Map.put(score5,pseudo5,nbRound5);


        btnBackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backMenu = new Intent(Scores.this, MainMenu.class);
                startActivity(backMenu);
            }
        });

    }

    private void board(String[] top5Board){
        int min;

        boolean entrerScore;

        // insérer données dans tableau vide
        if (top5Board.length < 5) {
            top5Board.add(newScore);
            Arrays.stream(top5Board).sorted();

        }

        //cas tableau non vide
        //insérer le nouveau score si il est supérieur au min
        else {
            if (newScore > top5Board(4))

                for (int i = 0;i<6; i++ ){
                    if (top5Board(i)>min) {
                        min = i;
                    top5Board(i) = newScore;
                    Scanner enterSore = Scanner (System.in);
                    System.out.println( "Souhaitez-vous entrer un score YES/NO");
                    if (entrerScore=="YES" ) {
                        Scanner sc = Scanner (System.in);
                        System.out.println("Quel est votre pseudo : ");
                        String nextLine = sc.nextLine();
                        String pseudo = sc.nextLine();

                    Arrays.stream(top5Board).sorted();

                }}
            }
        }

    }

//        // result to be found by the player
//        public enum fruitsCombinationResult {
//            Banana,Plum, Strawberry, Kiwi
//        }
//
//        // player proposal
//        public enum fruitsCombinationPlayer {
//            Plum,Strawberry, Kiwi, banana
//        }

        // gestion données
//        boolean gagne = true;
//        int score = 3;
//        int trialslast = 2;
//
//
//
//
//        if (gagne){
//            score += trialslast;
//
//        }
//
//        else {
//            Intent PageScoreTotal = new intent (Scores.this, )
//
//        }



    }




}