package com.test.ivan.struct.adapter;

/**
 * Created by user on 06.09.2016.
 */
public class RandomGeneratorAdapter extends RandomGenerator implements Generator {

    @Override
    public int next() {
        return getRandomNumber();
    }


}
