package com.admala.blocktimer;


import android.text.format.Time;

/**
 * Created by rahul on 9/16/2015.
 */
public class Blocks {
    boolean isWednesday;
    int min;
    int[] regularDay={540,630,636,726,732,852,858,948};
    String[] blockText={" Minutes Until School Starts"," Minutes Until Block Ends"," Minutes until Next Block Starts"," Minutes Until School Ends" };
    public Blocks(boolean isWednesday,int minutes){
        this.isWednesday=isWednesday;
        min=minutes;

    }
    public String getNormalDay(){
        int i=0;
        int minutes=0;
        for(int j=0;j<regularDay.length;j++) {
            if (min < regularDay[j]) {

                break;
            }
            i=j;
        }
        minutes=regularDay[i]-min;
        if(i==7){
        minutes=2400-min+regularDay[0];
        }
        switch (i){
            case 0

        }
        return ""+minutes+blockText[i];
    }
    public int getAdvisory(){
        return 0;
    }

}
