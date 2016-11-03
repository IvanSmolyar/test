package com.test.ivan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseIntArray;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss", Locale.ENGLISH);

    private static final int RANGE = 10;
    private static final int SIZE = 10;

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
        Log.e("TASK1", "Array " + array.toString() +
                " - " + array.size() + " items");
        //////////////////// task1 /////////////////////////
        task1(array, array.size());
    }

    private void task1(List<Integer> array, int size) {
        int min = array.get(0);
        int max = array.get(0);
        final long time = System.currentTimeMillis();
        SparseIntArray frequentArray = new SparseIntArray(size);
        List<Integer> missing = new ArrayList<>(size);
        Set set = new TreeSet();

        for (int pos = size - 1; pos >= 0; --pos) {
            int current = array.get(pos);
            if (current > max) {
                max = current;
            } else if (current < min) {
                min = current;
            }
            set.add(current);
            frequentArray.put(current, frequentArray.get(current) + 1);
        }
        for (int i = max; i >= min; --i) {
            if (!set.contains(i)) {
                missing.add(i);
            }
        }

        long took = System.currentTimeMillis() - time;
        ///////////////// print ////////////////////
        printResult(set, min, max, missing, frequentArray, took);
    }

    private void printResult(Set set, int min, int max, List<Integer> missing, SparseIntArray frequentArray, long took) {
        final String line = "Set " + set;
        final String line1 = "Range is " + min + " to " + max;
        final String line2 = "Missing Numbers: " + missing;
        final String line3 = "Duplicate Numbers: " + frequentArray.toString();
        final String line5 = "It took " + took + " ms";

        Log.e("TASK1", line);
        Log.e("TASK1", line1);
        Log.e("TASK1", line2);
        Log.e("TASK1", line3);
        Log.e("TASK1", line5);

        final File file = new File("/storage/emulated/0/task1_" + DATE_FORMAT.format(new Date()) + ".txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.append(line);
            writer.append("\n");
            writer.append(line1);
            writer.append("\n");
            writer.append(line2);
            writer.append("\n");
            writer.append(line3);
            writer.append("\n");

            for (int current = android.R.attr.max; current >= min; current--) {
                final int times = frequentArray.get(current);
                if (times >= 2) {
                    final String line4 = current + " appears " + times + " times";
                    Log.e("TASK1", line4);
                    writer.append(line4);
                    writer.append("\n");
                }
            }

            writer.append(line5);
            writer.append("\n");

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}