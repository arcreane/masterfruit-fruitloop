package com.example.fruitloop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class StartGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        // Here we create the fruit array that the player needs to discover
        // Here we create a list that contains all the fruits
    }

    public ArrayList randomFruit () {
        ArrayList<Fruits> fruitArray = new ArrayList<>();
        fruitArray.add(Fruits.STRAWBERRY);
        fruitArray.add(Fruits.GRAPE);
        fruitArray.add(Fruits.ORANGE);
        fruitArray.add(Fruits.PRUNE);
        fruitArray.add(Fruits.KIWI);
        fruitArray.add(Fruits.BANANA);
        fruitArray.add(Fruits.LEMON);
        fruitArray.add(Fruits.RASPBERRY);

        ArrayList<Fruits> fruitGameArray = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int max = fruitArray.size();

            Random rand = new Random();
            int i_randomFruit = rand.nextInt(max);

            fruitGameArray.add(fruitArray.get(i_randomFruit));
            fruitArray.remove(i_randomFruit);

        }
        return fruitGameArray;
    }

    public boolean Indices (Boolean indice1, Boolean indice2, int test) {
        test = 10;

        if(indice1) {
            int result = test - 2;
            ArrayList i = randomFruit();
            return true;
        }

        return false;
    }

    @Override //displaying the burger menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override //popup to show that the index selection is taken into account
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.indice_1:
                Toast.makeText(this, "Indice 1 selected", Toast.LENGTH_SHORT).show();
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
}