package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        String key = "";


        //1.  OfNullable
        Stream<String> strng = Stream.ofNullable(key);

        List<String> collect = strng.collect(Collectors.toList());// will not give NullPointerException


        //2. takeWhile
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5).map(x -> x * x).takeWhile(x -> x < 3);

        //3. dropWhile
        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5).map(x -> x * x).dropWhile(x -> x < 2);


        //iterate till java 8
        Stream.iterate(1, count->count+2 ).forEach(System.out::println);  // infinite loop


        //4. iterate in  Java 9
        IntStream.iterate(0, i -> i <10, i-> i++).forEach(System.out::println);
    }
}
