## Lab Exercise 3 :point_down:

### 1. Passing a lambda expression to a method

Create a functional interface called `NumberTest` with a single method called `test` that accepts an `int` and returns a `boolean`.

Write a method called `testNumber` that accepts an `int` and a `NumberTest` as arguments. The method should apply the test to the number and return the resulting boolean.

Use lambda expressions to test whether a number is:

- even
- odd
- greater than 10
- a multiple of 7 etc.

For example:

```java
testNumber(8, n -> n % 2 == 0);
```
which is equilavent to
```java
NumberTest nt =  n -> n % 2 == 0;
testNumber(8, nt);
```
Write some code to test your method with different numbers and lambda expressions.


## SOLUTION

Step 1: create the functional interface.

```java
@FunctionalInterface
interface NumberTest {
    boolean test(int number);
}
```

STEP 2: create a main class with the `testNumber` method

```java

public class Main {

    public static boolean testNumber(int number, NumberTest test) {
        return test.test(number);
    }

    public static void main(String[] args) {

        //test even
        System.out.println("Is 8 even? " + testNumber(8, n -> n % 2 == 0));

        //test odd
        System.out.println("Is 8 odd? " + testNumber(8, n -> n % 2 != 0));

        //test greater
        System.out.println("Is 15 greater than 10? " + testNumber(15, n -> n > 10));

        //test multiple
        System.out.println("Is 21 a multiple of 7? " + testNumber(21, n -> n % 7 == 0));

        //Store a lambda in a variable
        NumberTest nt = n -> n % 2 == 0;
        System.out.println("Is 12 even? " + testNumber(12, nt));
    }
}
```
----


### 2.	Write a method to count the number of elements in an int array that have a specific property
Write a method to count the number of elements in an int array that have a specific property (for example, odd integers, even numbers, prime numbers etc.). This method should accept the int array and a lambda expression as arguments. It should return an int (how many elements in the array satisfied the condition specified in the lambda).


### 3.	Write a method to count the number of elements in a String array that have a specific property 
Write a method to count the number of elements in a String array that have a specific property (for example, how terms in the array begin/end with a particular pattern). This method should accept the String array and a lambda expression as arguments. It should return an int (how many elements in the array satisfied the condition specified in the lambda). 


You must write an appropriate functional interface for steps each of the above steps, and the code necessary to test these methods.

_Is there scope to replace the two methods you created in tasks 2 and 3 with a single generic method? It would certainly cut down on the amount of code duplication in your solution. You will have to tweak the interface you developed for steps 1 and 2 (or perhaps create a new one) and subsequently create new lambda expressions to test this generic method._
