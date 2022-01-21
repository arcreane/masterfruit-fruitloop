package com.example.fruitloop;

public enum Fruits {
    BANANA(R.drawable.banana),
    GRAPE(R.drawable.grape),
    KIWI(R.drawable.kiwi),
    LEMON(R.drawable.lemon),
    ORANGE(R.drawable.orange),
    PRUNE(R.drawable.prune),
    RASPBERRY(R.drawable.raspberry),
    STRAWBERRY(R.drawable.strawberry);
    final int fruitId;

    Fruits(int fruitId) {
        this.fruitId = fruitId;
    }
}
