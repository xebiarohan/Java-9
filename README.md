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
 
     
     
## Java 10

#### Local variable type inference

Until java 9 we have to mention the type of the local variable explicitly and ensure it was compatible with the initializer used to initialize it:

```
int a = 10;
```

now from Java 10 we dont have to specify the data type of variable, compiler itself infers the type of message from the type of the initializer present on the right-hand side. we can just define it with var keyword

```java
var a = 10;
```

Compiler will understand that it is a integer using the value on the right side. It can be only used for local variabes with initializer, it cannot be used as member
variable, parameter and return value.


#### List.copyOf()

In Java-9 we get List.of() method which creates a unmodifiable list from the elements but if we want to make a list from other collection we did not had any method in
Java-9. So, in Java-10 we got this copyOf() method which takes a collection and makes a unmodifiable list from it.

```java
List<Integers> list = Arrays.asList(1,2,3);

List<Integer> integers = List.copyOf(list);
```

If we try to alter this unmodifiable list then we will get 'java.lang.UnsupportedOperationException'. In this example we used list as argument, here we can use any
collection.

#### Set.copyOf()

It is similar to the List.copyOf() method and for acheiving the same goal.

```java
List<Integers> list = Arrays.asList(1,2,3);

Set<Integer> unmodifiableSet = Set.copyOf(list);
```


#### Map.copyOf()

Map also has the same method in Java-10.

```java
Map<String,Integer> map = new HashMap<>();
map.put("alpha",1);
map.put("beta",2);

Map.copyOf(map);        
```        


#### Collectors.toUnmodifiable*()

In Java-10 there is a new method introduced in Collectors to make collection unmodifiable, any try to make a change in this unmodifiable list will result in UnsupportedOperationException.

```java
List<String> strings = Arrays.asList("alpha","beta","gamma");
List<String> collect = strings.stream().collect(Collectors.toUnmodifiableList());
```
Similarly we have toUnmodifiableMap() and toUnmodifiableSet() to create read-only map and set respectively.

#### orElseThrow() method in Optional

All types of optional (OptionalInt, OptionalDouble, OptionalLong and Optional) got a new method in Java-10 which throws NoSuchElementException
when no element is present in optional.

```java
List<Integer> integers = Arrays.asList(1, 2, 3, 4);
Integer integer = integers.stream().filter(x -> x > 10).findFirst().orElseThrow();
```
