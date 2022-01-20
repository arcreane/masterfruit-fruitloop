package com.example.fruitloop;

import java.util.ArrayList;

public enum HintType {
    PEEL,
    SEED;

    ArrayList<Fruits> fruitspeel;
    ArrayList<Fruits> fruitsseed;

    HintType() {
        fruitspeel = new ArrayList<>();
        fruitspeel.add(Fruits.ORANGE);
        fruitspeel.add(Fruits.PRUNE);
        fruitspeel.add(Fruits.GRAPE);
        fruitspeel.add(Fruits.LEMON);

        fruitsseed = new ArrayList<>();
        fruitsseed.add(Fruits.BANANA);
        fruitsseed.add(Fruits.KIWI);
        fruitsseed.add(Fruits.ORANGE);
        fruitsseed.add(Fruits.LEMON);
    }
}
