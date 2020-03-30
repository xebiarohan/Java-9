# Java-9
Java 9 features

1 Immutable List

       List.of(1,2,3);              // example

  Characteristics :
            cant add null value, it will give NullPointerException
            cant add more values to the list, it will give UnsupportedOperationException
            can add value only at the time of initialization

 2 Immutable Set
       
       Set.of(1,2,3);           //example
       
   Characteristics :
            cant add duplicate values like Set.of(1,1,2), it will give IllegalArgumentException
            cant add null value, it will give NullPointerException
            cant add more values to the set, it will give UnsupportedOperationException
            can add value only at the time of initialization

  3 Immutable Map

        we can create Immutable map in 2 ways

        i)  Map.of(K1,V1,K2,V2);       // K is key and V is value
        ii) Map.ofEntries(
                Map.entry(K1,V1),
                Map.entry(K2,V2)
           )

   Characteristics :
            cant add more values to the map, it will give UnsupportedOperationException
