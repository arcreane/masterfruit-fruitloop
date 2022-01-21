package com.example.fruitloop;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    ArrayList<Fruits> fruitGameArray;

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

        fruitGameArray = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int max = fruitArray.size();

            Random rand = new Random();
            int i_randomFruit = rand.nextInt(max);

            fruitGameArray.add(fruitArray.get(i_randomFruit));
            fruitArray.remove(i_randomFruit);

        }
        return fruitGameArray;
    }

    public ArrayList<Fruits> getFruitGameArray() {
        return fruitGameArray;
    }

    public void setFruitGameArray(ArrayList<Fruits> fruitGameArray) {
        this.fruitGameArray = fruitGameArray;
    }

    public String indices(HintType hint) {

        int test = 10;
        int result1;
        int result2;

        if (hint == HintType.SEED) {
            result1 = test - 2;
            for(Fruits seeds : getFruitGameArray()) {
                if (seeds.isWithSeeds() == getFruitGameArray().equals(Fruits.class.equals(seeds.isWithSeeds()))) {
                    return "T";
                } else {
                    return "F";
                }
            }
        } else if (hint == HintType.PEEL) {
            result2 = test - 3;
            for (Fruits peels : getFruitGameArray()) {
                if (peels.isPeelable() == getFruitGameArray().equals(Fruits.class.equals(peels.isPeelable()))) {
                    return "T";
                } else {
                    return "F";
                }
            }
        } else {
            return null;
        }
        return null;
    }

}

