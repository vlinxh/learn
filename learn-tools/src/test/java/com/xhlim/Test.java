package com.xhlim;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-04 18:10
 */
public class Test {

   static ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        // Map<String, String> map = toMap(String.class, String.class, "2", "3", "4", "5");
        // System.out.println(map);
    }

    // private static <K, V> Map<K, V> toMap(
    //         Class<K> keyType, Class<V> valueType, Object... entries) {
    //     if (entries.length % 2 == 1)
    //         throw new IllegalArgumentException("Invalid entries");
        // return IntStream.range(0, entries.length / 2).map(i -> i * 2).collect(HashMap::new, (m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])), Map::putAll);
    // }
}
