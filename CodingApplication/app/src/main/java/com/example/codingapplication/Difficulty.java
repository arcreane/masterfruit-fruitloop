package com.example.codingapplication;

public enum Difficulty {
    EASY(10),
    MEDIUM(50),
    HARD(100);

    public final int m_iLimitMax;

    Difficulty(int p_iValue) {
        m_iLimitMax = p_iValue;
    }
}
