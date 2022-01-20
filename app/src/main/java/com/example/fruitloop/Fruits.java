package com.example.fruitloop;

public enum Fruits {
    BANANA("@drawable/banana", Boolean.TRUE, Boolean.FALSE, Boolean.TRUE),
    GRAPE("@drawable/grape", Boolean.FALSE, Boolean.TRUE, Boolean.FALSE),
    KIWI("@drawable/kiwi", Boolean.TRUE, Boolean.FALSE, Boolean.TRUE),
    LEMON("@drawable/lemon", Boolean.FALSE, Boolean.TRUE, Boolean.TRUE),
    ORANGE("@drawable/orange", Boolean.FALSE, Boolean.TRUE, Boolean.TRUE),
    PRUNE("@drawable/prune", Boolean.FALSE, Boolean.TRUE, Boolean.FALSE),
    RASPBERRY("@drawable/raspberry", Boolean.TRUE, Boolean.FALSE, Boolean.FALSE),
    STRAWBERRY("@drawable/strawberry", Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);

    Fruits(String imgSrc, Boolean withoutSeeds, Boolean withSeeds, Boolean peelable) {
    }

}
