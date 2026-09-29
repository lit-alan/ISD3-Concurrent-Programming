# Lab Exercise 6️⃣

The summer Olympic Games are held every four years, with the games being held in Tokyo in 2021. For each event there is a gold, silver and bronze medal awarded to the top three teams or individual athletes.

The Olympic medal table shows each country in order from most gold medals won to the least number of gold medals won. Silver and bronze medals are used as tie-breaks, should there be two nations with an equal amount of gold medals.

The file `medals.txt` contains 93 different records about the different countries/teams who won medals at the Tokyo Olympic Games.

## Data Fields

The fields in the file are as follows:

| Field | Description |
|---|---|
| `Rank` | The team's overall rank in terms of Gold medals won. |
| `Team` | The team/country. |
| `Gold` | Number of gold medals won. |
| `Silver` | The number of silver medals won. |
| `Bronze` | The number of bronze medals won. |
| `Total` | The total number of medals won by a team/country. |
| `Rank_by_total` | The rank of a team/country based on the total number of medals won. |

## Starter Code

In the starter code that is available, a `Medals` class is provided and models a record from the file.

A class called `FileIO` is also provided and contains one public method – `readFile`. This method accepts the file name as an argument and will then read each record from the file, convert it to a `Medals` object and then add the object to a list. It is this list of `Medals` objects that the method returns.

For this exercise, write the following four methods and the necessary code to test them.


<br>

## Method One

Write a method that will accept two arguments – a list of medals and an `int` value (call it `X`).

The method will then determine and return the **percentage of countries whose rank is greater than their `rank_by_total`**.

However, before you return the percentage value you must format it to `X` decimal places.


<img width="751" height="58" alt="image" src="https://github.com/user-attachments/assets/f4bf79d9-b682-4c30-83b0-0427a5c33352" />

The percentage value when `X` has a value of `2`.




<img width="766" height="58" alt="image" src="https://github.com/user-attachments/assets/f29443e3-9aca-47d4-9b00-bd06ce74ec34" />


The percentage value when `X` has a value of `4`.

<br>
The signature for this method should be:

```java
public static double calculatePercRank(List<Medals> medalList, int x) { }
```

<br>

## Method Two

Write a method that will accept a single argument – a list of medals.

The method should generate a random number between 1 and 86 and then print the rank of each record in the file that matches the random number.

You need to be cognisant of the fact that more than one record may share the same rank (in which case you should print all matching records).

Should your application generate a random number/rank that isn't found in the file, you should print a suitable error message. For example:

<img width="777" height="109" alt="image" src="https://github.com/user-attachments/assets/2d5cbe7f-9609-417b-875e-4656cd5878d4" />

<br>


 
The signature for this method should be:

```java
public static void printRank(List<Medals> medalList) { }
```
<br>

## Method Three

Write a method that will accept a single argument – a list of medals.

The method must then return a filtered list of those medals objects whose team name ends in either `"stan"` or `"land"`.

The filtered list must be ordered by `rank_by_total`.

You must then display the filtered and ordered list on the console.


<img width="771" height="205" alt="image" src="https://github.com/user-attachments/assets/4f581c96-e652-4c98-972b-7371acc4b24a" />


<br>
You can decide on the signature of this method yourself.

<br>

## Method Four

Write and execute a method that will accept three arguments – a list of medals, an offset (specified as an `int`) and a sort key.

The sort key will indicate that the list should be sorted in descending order by the number of either gold, silver or bronze medals won.

You can model the sort key in whatever way you want. It could be a simple `String` holding a value of `"Gold"`, `"Silver"` or `"Bronze"`, you could model it as a lambda expression or a `Comparator`.

After the list has been sorted, the method should then return a subset of the sorted list (based on the offset).

<img width="727" height="226" alt="image" src="https://github.com/user-attachments/assets/a03c780a-a2de-4151-bdf6-4d967d42d4de" />

_Above, is a screengrab where the sort key was gold with an offset of 15._


<img width="766" height="94" alt="image" src="https://github.com/user-attachments/assets/31ce8123-4980-403b-8d8c-876c575c99cb" />

_Above, is a screengrab where the sort key was silver with an offset of 5._


<img width="772" height="76" alt="image" src="https://github.com/user-attachments/assets/07a3622a-6d73-4985-9aef-d25696a4e2a3" />
_
Above, is a screengrab where the sort key was bronze with an offset of 3._

<br>
You can decide on the signature of this method yourself.

