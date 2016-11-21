package com.test.ivan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int RANGE = 100000;

    private static final int SIZE = 1000000;

    private static final int MAX = RANGE;
    private static final int MIN = -MAX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ///////////////////////// init /////////////////////
        int[] array = new int[SIZE];
        Random r = new Random();
        for (int i = 0; i < SIZE; i++) {
            if (i % 2 == 0) {
                array[i] = r.nextInt(RANGE + 1);
            } else {
                array[i] = -r.nextInt(RANGE + 1);
            }
        }
        Log.e("!!!", "Set " +   array.length + " items");
        //////////////////// run task1 /////////////////////////
        task1(array, array.length);
    }

    private void task1(int[] array, int size) {
        final long time = System.currentTimeMillis();
        int min = array[0];
        int max = array[0];

        int[] frequent = new int[RANGE * 2];

        for (int pos = size - 1; pos >= 0; pos--) {
            int current = array[pos];
            if (current > max) {
                max = current;
            } else if (current < min) {
                min = current;
            }

            if (current >= 0) {
                frequent[current] = frequent[current] + 1;
            } else {
                frequent[RANGE - current - 1] = frequent[RANGE - current - 1] + 1;
            }
        }
        long took = System.currentTimeMillis() - time;
        Log.e("TASK1", "It took " + took + " ms");
        Log.e("!!!", "min " + min + ", max " + max);
        //printRes(frequent);
    }

    private void printRes(int[] frequent) {
        for (int current = frequent.length - 1; current >= 0; --current) {
            final int times = frequent[current];
            if (times >= 2) {
                final String line5 = (current > RANGE ? (-(current % RANGE + 1)) : current) + " appears " + times + " times";
                Log.e("!!!", line5);
            } else if (times == 0) {
                Log.e("!!!", (current > RANGE ? (-(current % RANGE + 1)) : current) + " missing");
            }
        }
    }

}