package com.test.ivan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseIntArray;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int RANGE = 100000;

    private static final int SIZE = 250000;

    private static final int MAX = RANGE;
    private static final int MIN = -MAX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ///////////////////////// init /////////////////////
        List<Integer> array = new ArrayList<>(SIZE);
        Random r = new Random();
        for (int i = 0; i < SIZE; i++) {
            if (i % 2 == 0) {
                array.add(i, r.nextInt(RANGE + 1));
            } else {
                array.add(i, -r.nextInt(RANGE + 1));
            }
        }
        Log.e("!!!", "Set " + array.size() + " items");
        //////////////////// run task1 /////////////////////////
        task1(array, array.size());
    }

    private void task1(List<Integer> array, int size) {
        final long time = System.currentTimeMillis();
        int min = array.get(0);
        int max = array.get(0);
        SparseIntArray frequentArray = new SparseIntArray(size);
        BitSet set = new BitSet(array.size() * 2);
        for (int pos = size - 1; pos >= 0; pos--) {
            int current = array.get(pos);
            if (current > max) {
                max = current;
            } else if (current < min) {
                min = current;
            }

            if (current >= 0) {
                set.set(current);
            } else {
                set.set(RANGE - current);
            }

            frequentArray.put(current, frequentArray.get(current) + 1);
        }
        long took = System.currentTimeMillis() - time;
        Log.e("TASK1", "It took " + took + " ms");
        //printRes(max, min, frequentArray, set);
    }

    private void printRes(int max, int min, SparseIntArray frequentArray, BitSet set) {
        for (int current = max; current >= min; current--) {
            final int times = frequentArray.get(current);
            if (times >= 2) {
                final String line4 = current + " appears " + times + " times";
                Log.e("!!!", line4);
            }
        }
        for (int current = MAX; current >= MIN; current--) {
            if (current >= 0) {
                if (!set.get(current)) {
                    Log.e("!!!","missing " + current);
                }
            } else {
                if (!set.get(RANGE-current)) {
                    Log.e("!!!","missing " + current);
                }
            }
        }
    }

}