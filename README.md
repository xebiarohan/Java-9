# Java-9
Java 9 features

1 Immutable List

       List.of(1,2,3);              // example

  Characteristics :                                                                                                
           i) cant add null value, it will give NullPointerException.
           ii) cant add more values to the list, it will give UnsupportedOperationException.
           iii) can add value only at the time of initialization.

 2 Immutable Set
       
       Set.of(1,2,3);           //example
       
   Characteristics :                                                                                                      
           i) cant add duplicate values like Set.of(1,1,2), it will give IllegalArgumentException.
           ii) cant add null value, it will give NullPointerException.
           iii) cant add more values to the set, it will give UnsupportedOperationException.
           iv) can add value only at the time of initialization.

  3 Immutable Map

        we can create Immutable map in 2 ways

        i)  Map.of(K1,V1,K2,V2);       // K is key and V is value
        ii) Map.ofEntries(
                Map.entry(K1,V1),
                Map.entry(K2,V2)
           )

   Characteristics :
           - cant add more values to the map, it will give UnsupportedOperationException.


  4 '_' becomes keyword
        cant use it as a user defined name
            String _ = "alpha";        // compilation error


  5 Stream modifications :
        i) ofNullable
            to wrap a value which may be null. Prevent from null pointer

        ii) takeWhile
            takes a predicate and decides till when to process data

        iii) dropWhile
            takes a predicate and decides from which takes to start processing data

        iv) iterate
            Till java8 iterate method comes with seed and operator only. From java9 iterate
            comes with  predicate.
