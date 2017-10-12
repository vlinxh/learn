package com.xhlim.jdk18;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-17 14:03
 */
public class ParallelDemo {

    public static void main(String[] args) {
        long[] array = new long[20000];
        Arrays.parallelSetAll(array, index -> ThreadLocalRandom.current().nextInt(100000));
        Arrays.stream(array)
                .limit(10)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        Arrays.parallelSort(array);
        Arrays.stream(array)
                .limit(10)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

}
