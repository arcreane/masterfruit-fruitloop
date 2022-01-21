package com.example.fruitloop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainGame extends AppCompatActivity {

    //Map<Integer, ArrayList> associationLinearLayoutIdGame = new HashMap<>();
    Map<Integer, HintType> associationItemIdHintType = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        //associationLinearLayoutIdGame.put(R.id.startGame, new Game().randomFruit());
        associationItemIdHintType.put(R.id.indice_2, HintType.PEEL);
        associationItemIdHintType.put(R.id.indice_1, HintType.SEED);
    }

    @Override //displaying the burger menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override //popup to show that the index selection is taken into account
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        HintType hint = associationItemIdHintType.get(item.getItemId());
        Toast.makeText(this, "selected", Toast.LENGTH_SHORT).show();
        //for ()
        /**switch (item.getItemId()) {
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
        }*/
        return true;
    }
}