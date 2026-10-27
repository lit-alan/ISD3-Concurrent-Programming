Census Callable solution

Project layout:
  src/Main.java
  src/SearchWithCallable.java
  src/LongestNameCallable.java
  src/NameStatistics.java
  src/model/Record.java
  census.txt  (copy the supplied data file here, beside the src folder)

Run src.Main. The program expects census.txt in the project's working directory.

The two submitted Callable tasks are:
1. SearchWithCallable: returns a NameStatistics object containing the five counts.
2. LongestNameCallable: returns all records tied for the longest name.

The user-entered name lookup runs in the main thread against the records already loaded in memory.
If your project already contains src.model.Person, keep that class and do not add the included example twice.
The code uses switch arrow syntax, so use Java 14 or newer (or change the switch statements to classic case/break syntax for older Java versions).
