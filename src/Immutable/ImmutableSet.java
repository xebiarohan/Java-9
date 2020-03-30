package Immutable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableSet {
    public static void main(String[] args) {
        // Till Java 8
        Set<Integer> ints = new HashSet<>();
        ints.add(1);
        ints.add(2);
        ints.add(null);

        ints = Collections.unmodifiableSet(ints);

        // In Java9
        Set<Integer> integers = Set.of(1, 2, 3, 4);
        integers.stream().forEach(System.out::println);
    }
}
