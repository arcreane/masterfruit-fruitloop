package com.example.fruitloop;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public enum Fruits {
    BANANA(R.drawable.banana,TRUE, FALSE, TRUE),
    GRAPE(R.drawable.grape, FALSE, TRUE, FALSE),
    KIWI(R.drawable.kiwi, TRUE, FALSE, TRUE),
    LEMON(R.drawable.lemon, FALSE, TRUE, TRUE),
    ORANGE(R.drawable.orange, FALSE, TRUE, TRUE),
    PRUNE(R.drawable.prune, FALSE, TRUE, FALSE),
    RASPBERRY(R.drawable.raspberry, TRUE, FALSE, FALSE),
    STRAWBERRY(R.drawable.strawberry, TRUE, FALSE, FALSE);
    final int fruitId;

    private final boolean withoutSeeds;
    private final boolean withSeeds;
    private final boolean peelable;

    Fruits(int fruitId, boolean withoutSeeds, boolean withSeeds, boolean peelable) {
        this.fruitId = fruitId;
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
