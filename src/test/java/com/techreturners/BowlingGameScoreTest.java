package com.techreturners;

import com.technreturners.BowlingGameScore;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameScoreTest {

    @Test
    public void calBowlingGameAllStrike() {
        BowlingGameScore bowlingGameScore = new BowlingGameScore();
        ArrayList<String> knockDown = new ArrayList<String>();
        for (int i=0; i <12; i++){
            knockDown.add("x");
        }
        assertEquals (300, bowlingGameScore.calculate(knockDown) );
    }
}
