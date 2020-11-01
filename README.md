# Revising all java features from JAVA-9 to JAVA-14

## Java 9 Features

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
 
     
     
## Java 10 Features

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


## JAVA 11 Features

#### Running java class with a single command

Till Java-10 we first need to compile the code with javac command then we can run it with java command but from Java-11 we can directly run our java class using
java command without compiling it with javac command.

```java
// Till java 10
javac Myclass.java
java Myclass

// From Java 11

java Myclass
```

#### New String methods
Java 11 added new string methods:

##### isBlank()
Checks if the current string value is blank or not, empty string or the string with white spaces only will be considered as blank string. This method will throw
NullPointerException in case string value is null.

```java
String str1 = "";
boolean isStr1Blank = str1.isBlank();   //true

String str2 = null;
boolean isStr2Blank = str1.isBlank();   //java.lang.NullPointerException

String str3 = "alpha";
boolean isStr3Blank = str3.isBlank();   //false

```

##### lines()
This method returns a stream of strings, which is a collection of all substrings split by lines.

```java
String essay = "line1\nline2\nline3";
System.out.println("Current value:");
System.out.println(essay);

System.out.println("List :");
List<String> collect = essay.lines().collect(Collectors.toList());
System.out.println(collect);

//Current value:
//line1
//line2
//line3

//List:
//[line1, line2, line3]

```

##### strip(), stripLeading(), stripTrailing()
These methods are used to remove the all the white spaces, leadingwhite spaces and trailing white spaces from a string. It is like a advanced version of trim,
strip is unicode aware. Unicode was not there at the time of trim.

```java
String className = "  My Class  ";

System.out.println(className.strip());              // "MyClass"
System.out.println(className.stripLeading());       // "My Class  "
System.out.println(className.stripTrailing());      // "  My Class"

```

##### repeat()
It repeats the given string that many number of times as mentioned in the given parameter value.

```java
String plus = "+";

System.out.println(plus.repeat(3));    // +++
```

#### Local variable syntax for lambda expression
In Java-10 we saw the usage of var keyword for declaring local variables, now in java 11 we can use it in the lambda expressions

```java
(var a, var b) -> a+b;    // valid expression

var a, var b  -> a +b;    // invalid expression

var a, int b -> a+b;   // invalid expression
```
Second expression is invalid because we need to have parenthesis if we are using var in lambda expression and third expression is invalid because mixing of any other
data type is not allowed with var.



## Java 12 Features

#### Switch statement
Java 12 introduced lambda expression in switch statements. Till Java 11 if we want to use switch statement then we use to use it like:

```java
String result = "";
int number = 1;
switch (number) {
    case 1:
    case 3: {
        result = "odd number";
        break;
    }

    case 2:
    case 4: {
        result = "even number";
        break;
    }

    default: {
        throw new NumberFormatException();
    }

}
```

Now we can write the same switch expression with lambda expression like:

```java
String result = "";
int number = 1;
result = switch (number) {
    case 1, 3 -> "odd numbers";
    case 2, 4 -> "even numbers";
    default -> {
        throw new NumberFormatException();
    }
};

```

#### File.mismatch method

Java 12 introduced a new method to compare 2 files present at different locations, it returns the location of the first mismatch byte between the 2 files or -1L if both
the files are identical.

```java
public static long mismatch(Path path, Path path2) throws IOException
```
It compares the bytes of the files and returns the first byte which does not match, if all bytes matches then returns -1L.


#### Collectors.teeing()
This new collectors method takes 2 collector and 1 BiFunction

```java

public static <T, R1, R2, R> Collector<T, ?, R> teeing(Collector<? super T, ?, R1> downstream1,
                          Collector<? super T, ?, R2> downstream2,
                          BiFunction<? super R1, ? super R2, R> merger) {
    return teeing0(downstream1, downstream2, merger);
}
```

So the result of first 2 collectors becomes the arguments of the Bifunction, lets understand with an example:

If we have a list of numbers and we want to calculate odd numbers are more or even numbers, how can we acheive this with teeing.

So we can calculate the number of odd numbers in 1st collector of the teeing method, even numbers in 2nd collector and can compute which one is more in function.

```java
Boolean isEvenDominatedList = Stream.of(1, 2, 3, 4, 5)
        .collect(Collectors.teeing(
                Collectors.filtering(x -> x % 2 == 0, Collectors.toList()),
                Collectors.filtering(x -> x % 2 != 0, Collectors.toList()),
                (evenList, oddList) -> evenList.size() > oddList.size()
        ));
```

#### String new Methods
Java-12 introduced few new string methods

##### indent()
This method is used to add or remove white spaces in a multi line string.

```java
 String intro = "My\nname id\nRohan.";
 
 System.out.println(intro);
 
//My
//name id
//Rohan.

System.out.println(intro.indent(2));

//  My
//  name id
//  Rohan.
 
```

Similarly if we have white space in a multiline string we can remove it using negative value in the same method.

##### transform()
As the name suggests this method is used to transform a string into another value using a java.util.Function

```java
Integer transform = "x".transform(x -> x.length());
String transform1 = "alpha".transform(x -> x + "beta");
```

we can apply any function and transform a string in any format we want.


##### describeConstable()
It is used to get optional value of any string

```java
String name = "Rohan"
Optional<String> optionalName = name.describeConstable();
System.out.println(optionalName);       

// Optional[Rohan]
```


## Java-13

#### Text block

Java 13 introduced a new text block preview feature, preview feature means it will not work by default, you have to enable it. It allows us to create multiline string
easily.

```java
String html = """
		<html>
		<head>
			<link href='/css/style.css' rel='stylesheet' />
		</head>
		<body>
                        <h1>Hello World</h1>
    </body>
    </html>""";

```


#### Modification in switch expression
Java-12 introduced switch expression, Java-13 has the same but it replaced break with yield keyword. 'yield' is used to return a value from a switch case.

```java
String result = switch (number) {
      case 1,3:
          yield "odd";
      case 2,4:
          yield "even";
      default:
          throw new NumberFormatException();
};
```

#### New String methods

##### formatted(Object… args)
It is similar to the String format() method. It’s added to support formatting with the text blocks.

##### stripIndent()
It is used to remove the incidental white space characters from the beginning and end of every line in the text block. This method is used by the text blocks and it preserves the relative indentation of the content.

##### translateEscapes()
It returns a string whose value is this string, with escape sequences translated as if in a string literal.
