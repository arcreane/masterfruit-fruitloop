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

    /*public boolean isWithSeeds() {
        return fruitGameArray == Fruits(equals(Boolean.getBoolean(withSeeds)));
    }*/
    public String indices(HintType hint) {

        int test = 10;
        int result1;
        int result2;

        if (hint == HintType.SEED) {
            result1 = test - 2;
            for(Fruits seed : fruitGameArray) {
                if (seed.getDeclaringClass().isInterface(HintType.SEED.fruitsseed) == fruitGameArray) {
                    return "T";
                }
            }
            return String.valueOf(result1) + (indice_1);
            //return String.valueOf(indice_1);
        } else if (hint == HintType.PEEL) {
            result2 = test - 3;
            return String.valueOf(result2) + (indice_2);
        } else {
            return null;
        }
    }

    /**public boolean Indices (Boolean indice_1, Boolean indice2, int test) {
       test = 10;
        Boolean withSeeds = true;
        Boolean peelable = true;

        if(indice_1) {
            int result = test - 2;
            randomFruit() == Fruits.valueOf(Fruits, withSeeds);
            return true;
        }

        return false;
    }*/

    /**public enum Boolean implements Comparable<Boolean>
    {
        FALSE(false), TRUE(true);
        private Boolean(boolean value) {
            this.value = value;
        }
        private final boolean value;
        public boolean booleanValue() {
            return value;
        }

        public String toString() {
            return value ? "true" : "false";
        }
    }*/

}

