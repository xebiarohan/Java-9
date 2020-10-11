# Revising all java features from JAVA-9 to JAVA-14

## Java 9 features

#### Immutable List
Creates a immutable list (read-only), cannot modify the list once it is created.

```java
       List.of(1,2,3);              
```

Characteristics :                                                                                                
           - Cannot add null value, it will give NullPointerException.
           - Cannot add more values to the list, it will give UnsupportedOperationException.
           - Can add values only at the time of initialization.

#### Immutable Set
```java       
       Set.of(1,2,3);           
```

Characteristics :                                                                                                      
           - Cannot add duplicate values like Set.of(1,1,2), it will give IllegalArgumentException.
           - Cannot add null value, it will give NullPointerException.
           - Cannot add more values to the set, it will give UnsupportedOperationException.
           - Can add values only at the time of initialization.

#### Immutable Map
we can create immutable map in 2 ways:

```java
          Map.of(K1,V1,K2,V2);      // K is key and V is value
```
AND

```
         Map.ofEntries(
                Map.entry(K1,V1),
                Map.entry(K2,V2)
           );
```

Characteristics :                                                                                                      
           i) Cannot add more values to the map, it will give UnsupportedOperationException.


#### '\_' becomes a keyword
        Cannot use it as a user defined name.
        
```java        
            String _ = "alpha";        // compilation error
```

#### Stream modifications :
  
 i) ofNullable
     to wrap a value which may be null. Prevent from null pointer.

 ii) takeWhile
     takes a predicate and decides till when to process data

 iii) dropWhile
     takes a predicate and decides from which takes to start processing data

 iv) iterate
     Till java8 iterate method comes with seed and operator only. From java9 iterate
     comes with  predicate.


#### Optional modifications :

       i) or
       this is used to get an optional in response if value is null

       ii) ifPresentOrElse
       passing 2 method 1st as a Consumer and second as a Runnable, Consumer will get executed
       if value evaluates to notnull and Runnable method will get executed if value evaluates to null

       iii) stream
         Used to get streamed data of Optional
                
 
 7 Private method in interface
 
       
       Private method interface is used to remove duplicate code from the default method.
       
 8 Try with resource
 
       Try with resource was introduced in Java 7 but we have to declare and use define the object in try 
       only. we cannot use object which is already  defined outside try. 
       
       So it Java 9, we can use object which is defined outside try. Object must be implementing either 
       autocloseable or closeable interface and object must be final of effective final
       
      we can use multiple object in try block using ';' as delimiter
 
     
