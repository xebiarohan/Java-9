package Immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableList {
    public static void main(String[] args) {

        // Till Java8
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(null);

        integers = Collections.unmodifiableList(integers);



        // In Java 9
        List<Integer> list = List.of(1, 2, 3);
        list.stream().forEach(System.out::println);
        // list.add(1); UnsupportedOperationException
        // List.of(1,2,null) will give NullPointer exception
    }
}
