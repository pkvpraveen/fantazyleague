package com.fantazy.league.testutils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Praveen on 6/2/2017.
 */
public class RandomUtil {
    public static int randomIntBetween(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end);
    }
}
