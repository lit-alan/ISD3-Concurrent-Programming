# Concurrent Programming Quiz - Revision Guide 👇

Revise the following Java methods, concepts, and operations.

## Streams 🌊

- `stream()` - create a stream from a collection.
- `Stream.of()` - create a stream from specified values.
- `filter()` - retain elements that satisfy a condition.
- `map()` - transform each element.
- `mapToInt()` - transform elements into an `IntStream`.
- `mapToDouble()` - transform elements into a `DoubleStream`.
- `distinct()`- remove duplicate elements.
- `sorted()` - sort stream elements.
- `reduce()` - combine stream elements into a single result.
- `sum()` - calculate the sum of numeric stream elements.
- `average()` - calculate the average of numeric stream elements.
- `min()` and `max()` - find the smallest or largest element, using natural ordering or a supplied comparator.
- `collect()` - gather stream results into a collection or another data structure.
- `orElse()`- provide a fallback value when an `Optional` is empty.
- `get()` - retrieve a value from an `Optional`; it throws an exception if no value is present.


  <br>

  
## Lambda Expressions 🔀

- Lambda expressions - while you won't be asked to write any code in the quiz, understanding how lambda expressions are written and how they're used to define stream operations will be VIP.

  <br> 
  
🔧 Methods Used in Lambda Expressions
   
-  `String.toUpperCase()` - convert a string to uppercase. 
 
-  `String.toLowerCase()` - convert a string to lowercase.
 
-  `String.length()` - return the number of characters in a string.
 
-  `String.isEmpty()` - check whether a string has zero characters.
   
-  `String.trim()` - remove leading and trailing whitespace.
   
-  `Math.abs()` - return the absolute value of a number.
   
-  `Math.max()` - return the larger of two numbers.
   
-  `Math.min()` - return the smaller of two numbers.
   
-  `Integer.parseInt()` - convert a string to an integer.
   
-  `String.valueOf()` - convert a value to its string representation.
  
 <br>

## Method References 🧩
-  Method references provide a concise alternative to lambda expressions when the lambda simply calls an existing method; they improve readability and reduce unnecessary code, particularly when working with Java Streams and functional interfaces.

  
| Method reference | Equivalent lambda |
|---|---|
| `Integer::sum` | `(a, b) -> a + b` |
| `Integer::max` | `(a, b) -> Math.max(a, b)` |
| `Integer::min` | `(a, b) -> Math.min(a, b)` |
| `Math::abs` | `n -> Math.abs(n)` |
| `String::toUpperCase` | `s -> s.toUpperCase()` |
| `String::toLowerCase` | `s -> s.toLowerCase()` |
| `String::length` | `s -> s.length()` |
| `System.out::println` | `value -> System.out.println(value)` |
| `Objects::nonNull` | `value -> value != null` |
| `String::valueOf` | `value -> String.valueOf(value)` |

   <br>

## Comparisons and Ordering ⚖️

- `compareTo()` - compare objects using their natural ordering.
- `Comparator` - define a comparison or sorting order.
- Understand how `min()`, `max()`, and `sorted()` use natural ordering or a comparator.


  <br>

## Maps (feature on one question) 🗺️

- `Map<K, V>` - understand key-value pairs.
- `Collectors.toMap()` - collect stream elements into a map.
- Lambda expressions used to specify the key and value for each map entry.
- Understand how `filter()` determines which elements are collected into a map.

  <br>
  
## Reflection 🔍

- `getClass()` - obtain the runtime class of an object.
- `getDeclaredMethods()` - retrieve methods declared directly in a class, including private methods; inherited methods are not included.
- `getDeclaredField()` - retrieve a field declared directly in a class by name.
- `getName()` - obtain the name of a class, method, or field, depending on the reflection object.
- `setAccessible(true)` - allow reflective access to a member that would otherwise be inaccessible, subject to Java access restrictions.
- `Field.get()` - read a field's value from an object.
- `Method.invoke()` - invoke a method reflectively.
- Understand how reflection can be used to inspect classes and access fields or methods at runtime.

<br>
  
## Important Stream Concepts ⚙️

- Distinguish intermediate operations (for example, `filter()`, `map()`, `distinct()`, and `sorted()`) from terminal operations (for example, `collect()`, `reduce()`, `sum()`, `average()`, `min()`, and `max()`).
- Understand that streams do not normally modify the original collection.
- Understand that `reduce(0, Integer::sum)` uses `0` as the identity/starting value and returns `0` for an empty stream.
- Remember that integer division discards the fractional part.
- Be able to trace a stream operation by operation and determine its final output.


  <br>

> [!NOTE]  
> This guide is intended to support your revision and is not an exhaustive list of examinable material. Not all topics or methods listed will necessarily appear in the quiz, and the quiz may assess other concepts covered in the module. You are expected to undertake further research and revision to develop your understanding of the material.
