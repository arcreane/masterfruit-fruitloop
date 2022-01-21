package com.example.fruitloop;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.ArrayList;

public enum Fruits {
    BANANA("@drawable/banana",TRUE, FALSE, TRUE),
    GRAPE("@drawable/grape", FALSE, TRUE, FALSE),
    KIWI("@drawable/kiwi", TRUE, FALSE, TRUE),
    LEMON("@drawable/lemon", FALSE, TRUE, TRUE),
    ORANGE("@drawable/orange", FALSE, TRUE, TRUE),
    PRUNE("@drawable/prune", FALSE, TRUE, FALSE),
    RASPBERRY("@drawable/raspberry", TRUE, FALSE, FALSE),
    STRAWBERRY("@drawable/strawberry", TRUE, FALSE, FALSE);

    private final String imgSrc;
    private final boolean withoutSeeds;
    private final boolean withSeeds;
    private final boolean peelable;

    Fruits(String imgSrc, boolean withoutSeeds, boolean withSeeds, boolean peelable) {
        this.imgSrc = imgSrc;
        this.withoutSeeds = withoutSeeds;
        this.withSeeds = withSeeds;
        this.peelable = peelable;
    }

    public boolean isWithSeeds() {
        return withSeeds;
    }

    public boolean isPeelable() {
        return peelable;
    }
}
