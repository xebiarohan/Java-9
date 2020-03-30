package Immutable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMap {
    public static void main(String[] args) {
        //Till Java 8
        Map<Integer,String> oldMap = new HashMap<>();

        oldMap.put(1,"alpha");
        oldMap.put(2,"beta");
        oldMap.put(3,"gamma");

        oldMap = Collections.unmodifiableMap(oldMap);



        // In Java 9
        Map<Integer, String> newMap1 = Map.of(1, "alpha", 2, "beta", 3, "gamma");

        Map<Integer, String> newMap2 = Map.ofEntries(
                Map.entry(1, "alpha"),
                Map.entry(2, "beta"),
                Map.entry(3, "gamma")
        );
    }
}
