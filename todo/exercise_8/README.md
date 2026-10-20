## Lab Exercise 7️⃣ Analysing and Manipulating a Generic List Using Reflection and Streams


The objective of this exercise is to test your understanding of reflection, lambda expressions, streams, and generics in Java. You will be working with generic lists and using reflection to analyse and manipulate its elements.

**ToDo**

**1.** Open the starter code for this exercise and observe a `BankAccount` class, a generic interface called `GenericOperation` and some other code snippets. You will need this code base to attempt this exercise.

<br>
  
**2.** Edit the generic class `GenericList<T>`. This class is designed to represent a list of elements of type `T`. Add code to the following methods:
   - `void add(T element)` - Adds an element to the list.
   - `T get(int index)` - Returns the element at the specified index.
   - `int size()`  - Returns the size of the list.
   - `void printList()` - Prints all elements in the list.
   - `boolean isEmpty()` - Returns: true if the list is empty (contains no elements), false otherwise.

<br>
    
**3.** Create a class called `ListAnalyser` with the following methods:

```java
public static <T> List<T> filterList(GenericList<T> list, GenericOperation<T> opp) { }
```
_Using a lambda expression (opp), the method is to filter the elements of the list based on the given `GenericOperation` and return a new list containing only the matching elements._

<br><br>
```java
public static <T> void analyseList(GenericList<T> list) { }
```
This method is to use reflection to analyse the list and prints the following information:
- The class name of the elements in the list.
- The number of elements in the list.
- The names of all public methods of the elements' class.

<br>
  
**4.** In the main method of the `Main` class, do the following:
   - Create a `GenericList` of `String` and add several strings to it.
   - Create a `GenericList` of `Integer` and add some integers to it.
   - Create a `GenericList` of `BankAccount` and add some bank accounts to it.
   - For each of the three lists:
     - Print the contents of each list by invoking the `printList` method in the `GenericList` class (on each list).
     - Pass each list to the `analyseList` method in the `ListAnalyser` class.
     - Using the `GenericOperation` interface and the `filterList` method in the `ListAnalyser` class, filter each list. For example:
       - Filter the list of `Integers` keeping only even numbers.
       - Filter the list of `Strings` keeping only those strings that start with a specific pattern.
       - Filter the list of `BankAccounts` keeping only those `BankAccounts` with a `balance` greater than 2000.
       - Print each of the filtered lists.


-----
**Output for Generic `String` list containing some arbitrary strings (fruits).**

<img width="1465" height="511" alt="image" src="https://github.com/user-attachments/assets/0c01653b-b6bd-437f-b57e-b74f62f520b0" />

<br><br>  


**Output for Generic Integer list containing some arbitrary numbers (1-6).**

<img width="1462" height="441" alt="image" src="https://github.com/user-attachments/assets/2d1a92d2-145c-40fb-bf53-072bf79fe7f8" />

<br><br>



**Output for Generic BankAccount list.**

<img width="1465" height="364" alt="image" src="https://github.com/user-attachments/assets/3dbcde3c-79be-407a-aab6-0022a6e4bec9" />

<br><br>

**Output when the three lists are filtered and printed.**

<img width="1476" height="436" alt="image" src="https://github.com/user-attachments/assets/cf9ba2b5-ff1c-4451-937b-1bfdf4c29b1d" />


     
