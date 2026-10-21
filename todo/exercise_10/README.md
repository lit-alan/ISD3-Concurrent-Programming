# Lab Exercise 🔟 - Census Data Analysis Using Java Concurrency

The starter code for this exercise contains a text file `census.txt`. This file contains a list of first names from a census in the USA in the mid-2000s.

There are over 5,000 names appearing in the file. The file takes the following format, with a code and an indicator appearing alongside each name.

<img width="402" height="534" alt="image" src="https://github.com/user-attachments/assets/2591626d-ca1f-4e05-ade5-8cc878d65901" />


## The key for the code

- **MF:** Used as both a male and female name (331 names identify as MF in the file).
- **MO:** Used as a male-only name (888).
- **FO:** Used as a female-only name (3,944).

## The key for the indicator

- **LY:** Used as a last name as well as a first name (2,052).
- **LN:** Not used as a last name (3,111).

## Tasks

### Task 1: Concurrent Analysis Using `Callable`

Write an application that will read the file and create **at most two `Callable` tasks** to return the following statistics:

1. How many names from the file are used as both a male and female name.
2. How many names from the file are male-only names.
3. How many names from the file are female-only names.
4. How many names from the file are used as both a last name and a first name.
5. How many names from the file are not used as a last name.

Print the return values from the five tasks they have finished executing.

<img width="279" height="142" alt="image" src="https://github.com/user-attachments/assets/32fa4631-7baa-4857-b16a-df69bf3f1215" />


All tasks should execute concurrently, Due to the number of searches taking place and the volume of data involved, there should be a marked difference between using multithreading for this exercise and not.

It is worth noting that the codes and indicators are contained in a variety of names. For example:

| Code/Indicator | Found in names | Example |
|---|---:|---|
| MF | 0 | N/A |
| FO | 18 | Adolfo |
| MO | 65 | Desmond |
| LY | 147 | Billy |
| LN | 5 | Maryln |

### Task 2: Find the Longest Name

Modify the application to find the longest first name in the file.

1. Return the longest name or names, including their length.
2. If multiple names share the maximum length, return all of them.
3. Display the results clearly.

Implement this functionality using a `Callable` that returns the matching name records.

<img width="132" height="189" alt="image" src="https://github.com/user-attachments/assets/319fb981-21f8-4455-818a-593279f966d8" />


### Task 3: Search for a Specific Name

Extend the application to allow the user to search for a specific name.

1. Prompt the user to enter a name.
2. Search the records for the specified name.
3. If the name is found, display the name, its code and its indicator.
4. If the name is not found, display an appropriate message.
5. The search should be case-insensitive.

<img width="294" height="49" alt="image" src="https://github.com/user-attachments/assets/9b81cc1b-b6d7-46c0-adc2-068018b24c07" /> <br>

<img width="323" height="55" alt="image" src="https://github.com/user-attachments/assets/af06e804-fbef-4dff-8663-50ed0db57532" />


