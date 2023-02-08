package com.technreturners;

import java.util.ArrayList;

public class BowlingGameScore {

    private final int totalFrame = 10;
    private final int strikeBonus =10;
    private final int spareBonus =10;
    private final int allPin =10;

    private int chkRollScore (String input) {
        //if input is "x", score is 10 for all Pin down
        //if input is a numeric, that is the score
        //if input is "/", score is treated as 10 to add for the frame
        if (input.equals("x")) {
            return allPin;
        }
        else
            if (input.equals("/")) {
                return spareBonus;
            }
            else
                {
                    try {
                    Integer num = Integer.parseInt(input);
                    return num;
                    }
                    catch(NumberFormatException e) {
                    System.out.println("invalid pin record");
                    return 0;
                    }
                }
    }
    public int calculate(ArrayList<String> pinRecord) {
        int totScore = 0;
        int numOfRolls = pinRecord.size();
        // read each roll to compute score for a frame (max 10 frames)

        int frameCount = 0; //the first roll starts a frame
        int rollCount =0;

        // get each roll pins for each frame, up to 10 frame
        while (frameCount <10) {
            totScore += chkRollScore(pinRecord.get(rollCount));
            // if first roll is strike, sum the pins of next 2 rolls and add 10 to be score for a frame
            if (pinRecord.get(rollCount).equals("x")) {
                frameCount += 1;
                totScore += chkRollScore(pinRecord.get(rollCount+1)) + chkRollScore(pinRecord.get(rollCount+2));
            }
            rollCount++;
        }

        return totScore;
    }

}
