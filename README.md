# Revising all java features from JAVA-9 to JAVA-14

## Java 9 features

#### Immutable List
Creates a immutable list (read-only), cannot modify the list once it is created.

```java
List.of(1,2,3);              
```

                                                                                              
- Cannot add null value, it will give NullPointerException.
- Cannot add more values to the list, it will give UnsupportedOperationException.
- Can add values only at the time of initialization.

#### Immutable Set
```java       
Set.of(1,2,3);           
```
                                                                                                    
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
                                                                                                    
- Cannot add more values to the map, it will give UnsupportedOperationException.


#### \_ becomes a keyword
Cannot use it as a user defined name.
        
```java        
String _ = "alpha";        // compilation error
```

#### Stream modifications :
  
##### - ofNullable
To wrap a value which may be null, it prevents from null pointer.
     
```java
String key = "";
Stream<String> strng = Stream.ofNullable(key);
```

##### - takeWhile
Takes a predicate and decides till when to process the data.

```java
Stream<Integer> take = Stream.of(1, 2, 3, 4, 5).map(x -> x * x).takeWhile(x -> x < 3);
```
It will create a stream of only 1 element because only 1 element satisfies the takewhile condition. Even if the change the values to (1,2,3,4,1) then also it 
will create a stream of 1 element because once the predicate fails it stops its processing, it will not compute the further elements.

##### - dropWhile
Takes a predicate and decides from which element to start processing the data.

```java
Stream<Integer> drop = Stream.of(1, 2, 3, 4, 5).map(x -> x * x).dropWhile(x -> x < 2);
```

It will create a stream of 4 elements (2,3,4,5) as they satisfies the dropwhile() condition. Now, if we change the values to (1,2,3,4,5,1) then also
it will create a stream of 5 elements because once the predicate condition passes it will take all the remaining elements without computing it with predicate present
in dropwhile() method.

##### - iterate
Till java8 iterate method comes with seed and operator only. From java9 iterate comes with  predicate.

till java 8

```java
Stream.iterate(1, count->count+2 ).forEach(System.out::println); // infinite loop
```

from java 9

```java
IntStream.iterate(0, i -> i <10, i-> i++).forEach(System.out::println);
```

#### Optional modifications :

##### - or
It is used to return an Optional default value. Till java 8 we had orElse() and orElseGet() method, these methods returns the object value but if we need out result in optional format then we can used or() instead or these two methods.

```java
Optional<Integer> pt1 = Optional.ofNullable(val1).or(() -> Optional.of(3));
```
If the value of val1 integer is null then it will return the Optional of "beta". So when we will get the value of pt1 then we will get 3 as value.


##### - ifPresentOrElse
It takes 2 arguments, 1st is a Consumer and second is a Runnable. Consumer gets executed if the optional value computes to a not null value otherwise 
Runnable method will get executed.

```java
Optional.ofNullable(val1).ifPresentOrElse(
     v -> print(v),
     Person:: error
);

public static void error() {
    System.out.println("Error....");
}
```
Here if the value of v1 is null then it will call the error method of the Person class otherwise, it will just print the value of val1.

##### - stream
Now we can create a stream on optional value like:

```java
 List<String> collect =  Optional.ofNullable(val1).stream().map(String::toUpperCase).collect(Collectors.toList());
```
It will first check if val1 is null or not, if it is not null then it will creates a stream on that, applies the upper case method and collects the response in
the list.
 
#### Private method in interface
From java 9 we can have private methods in interface. It is used to remove the duplicate code from the default methods present in the interface.

       
#### Try with resource
Try with resource was introduced in Java 7 but we have to declare and use define the object in try only. we cannot use object which is already  defined outside try. 

Let say we have a class name Person which implements Closable interface and we want to use it in try with resource. So, till java 8 we have to use it like:

```java
try(Person person = new Person()){
...
} 
```

we have to declare the class object in the try statement.
       
So in Java 9, we can use object which is defined outside try. Object must be implementing either autocloseable or closeable interface and object must be final of effective final.

```java
Person person = new Person();
try(person) {
...
}

```
Here we can see we defined the person object outside the try statement.
       
We can use multiple object in try block using ';' as delimiter like:

```java
 try(Scanner scanner = new Scanner(new File("txt")); person) {
 ...
 } 
```
 
     
