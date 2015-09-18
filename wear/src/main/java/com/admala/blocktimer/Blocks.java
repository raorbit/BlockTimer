package com.admala.blocktimer;


import android.text.format.Time;

/**
 * Created by rahul on 9/16/2015.
 */
public class Blocks {
    boolean isWednesday;
    int min;
    int[] regularDay = {540, 630, 636, 726, 732, 852, 858, 948};
    int[] advisoryDay = {540, 620, 625, 650, 655, 735, 740, 860, 865, 948};
    String text;
    String[] blockText = {" Minutes Until School Starts", " Minutes Until Block Ends", " Minutes until Next Block Starts", " Minutes Until Block Ends", " Minutes until Next Block Starts", " Minutes Until Block Ends", " Minutes until Next Block Starts", " Minutes Until Block Ends", " Minutes Until School Ends"};
    String[] advisoryBlockText= {" Minutes Until School Starts", " Minutes Until Block Ends"," Minutes until Advisory Starts"," Minutes until Advisory Ends", " Minutes until Next Block Starts", " Minutes Until Block Ends", " Minutes until Next Block Starts", " Minutes Until Block Ends", " Minutes until Next Block Starts", " Minutes Until Block Ends", " Minutes Until School Ends"};
    public Blocks(boolean isWednesday, int minutes) {
        this.isWednesday = isWednesday;
        min = minutes;
        if (isWednesday)
            text = getAdvisory();
        else
            text = getNormalDay();
    }
    public String getText(){
        return text;
    }
    public String getNormalDay() {
        int i = 0;
        int minutes = 0;
        for (int j = 0; j < regularDay.length; j++) {
            if (min < regularDay[j]) {
                i = j;
                break;
            }
            i = j;
            if (j == 7) {
                i = 8;
            }
        }

        if (i == 8) {
            minutes = 2400 - min + regularDay[0];
        } else {
            minutes = regularDay[i] - min;
        }
        return "" + minutes + blockText[i];

    }

    public String getAdvisory() {
        int i = 0;
        int minutes = 0;
        for (int j = 0; j < advisoryDay.length; j++) {
            if (min < advisoryDay[j]) {
                i = j;
                break;
            }
            i = j;
            if (j == 9) {
                i = 10;
            }
        }
        if (i == 10) {
            minutes = 1440 - min + regularDay[0];
        } else {
            minutes = advisoryDay[i] - min;
        }
        return "" + minutes + advisoryBlockText[i];

    }

}
