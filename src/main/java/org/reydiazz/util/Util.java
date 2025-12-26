package org.reydiazz.util;

import java.util.concurrent.ThreadLocalRandom;

public class Util {

    public static int randomIntegerPositive() {
        return ThreadLocalRandom.current().nextInt();
    }
    public static int randomIntegerPositive(int max) {
        return ThreadLocalRandom.current().nextInt(0,max + 1);
    }
}
