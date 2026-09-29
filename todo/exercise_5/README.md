## Lab Exercise 5️⃣. Streams and Filter.

Create an IntelliJ project and add a Main class to it called `StreamEX1`.

Within this class, initialise a `List` with the following 10 `Integer` (objects) 23, 5, 67, 4, 3, 31, 90, 12, 45,89

Then using streams carry out the following:

**1.** Print the numbers to the console. 

**2.** Sort the numbers and again print them (in ascending order) to the screen.

**3.** Determine and print the largest number in the list.

**4.** Determine and print the smallest number in the list.

**5.** Determine and print the average of the numbers in the list.

**6.** Determine and print the sum of all the numbers in the list.

**7.** Print the numbers in the list that are less than 20.

**8.** Print the numbers in the list that are between 20 and 50 (inclusive).

**9.** Print the even numbers in the list.


-----

Add another Main class to your project called `StreamEX2`.

Within this class, initialise a List with the months of the year (as Strings).

Then using _streams_ carry out the following:

**10.** Print a count of the number of elements in this list (use a stream for this and not simply printing the size of the list).

**11.** Print all those month names which start with the letter “J”.

**12.** Print all those month names which have 5 letters or less.

**13.** Print all those month names which end with “ber” and contain 8 characters.

**14.** Using a stream, produce a filtered list which contains each of the twelve month names. However, in the filtered list, each occurrence of the letter ‘a’ should be replaced with ‘@’ in each of the month names. Print the contents of the filtered list to the console. For example:


<img width="268" height="397" alt="image" src="https://github.com/user-attachments/assets/65f37883-2bf7-4b4a-900d-0549dd4ae4f5" />


You should end up with two lists here – the original and the filtered list (where every occurrence of the letter ‘a’ is replaced with ‘@’).


------


Add the following class to your project

```java

public class Person {
    private String id;
    private String name;
    private int age;
    private String address;
    private boolean employed;
    private boolean hasFullDrivingLicence;

    public Person(String id, String name, int age, String address, boolean employed, boolean hasFullDrivingLicence) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.employed = employed;
        this.hasFullDrivingLicence = hasFullDrivingLicence;
    }

    public Person(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isEmployed() {
        return employed;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public boolean isHasFullDrivingLicence() {
        return hasFullDrivingLicence;
    }

    public void setHasFullDrivingLicence(boolean hasFullDrivingLicence) {
        this.hasFullDrivingLicence = hasFullDrivingLicence;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", employed=" + employed +
                ", hasFullDrivingLicence=" + hasFullDrivingLicence +
                '}';
    }
}

```

Create a separate class called `StreamEx3` and add the following to the `main`

```java
 List<Person> people = new ArrayList<>();

        people.add(new Person("P001", "John Murphy", 34, "Limerick", true, true));
        people.add(new Person("P002", "Sarah Kelly", 28, "Cork", true, false));
        people.add(new Person("P003", "Michael Ryan", 52, "Dublin", true, true));
        people.add(new Person("P004", "Emma Byrne", 21, "Galway", false, false));
        people.add(new Person("P005", "David Walsh", 45, "Limerick", true, true));
        people.add(new Person("P006", "Aoife O'Brien", 31, "Waterford", true, true));
        people.add(new Person("P007", "Conor Doyle", 19, "Cork", false, false));
        people.add(new Person("P008", "Lisa Nolan", 39, "Dublin", true, false));
        people.add(new Person("P009", "Brian McCarthy", 67, "Galway", false, true));
        people.add(new Person("P010", "Rachel Smith", 25, "Limerick", true, false));
        people.add(new Person("P011", "Tom Higgins", 58, "Dublin", true, true));
        people.add(new Person("P012", "Niamh Burke", 42, "Cork", false, true));



```


Then using streams carry out the following on the list: 


  

**15.** Print to the console all the people aged 20 to 35 who have a full driving license.

**16.** Determine and print to the console (as a double) the average age of people who are not employed.

**17.** Using a stream, filter the names of all employed people into a separate list and then display them (you will end
up with two lists here – the original and the new list containing just the names of all the
employed people).

**18.** Display and group the names of the people in the list by employment status – you will need to use the
groupingBy method of the Collectors class to complete this exercise. Your output should
look something like the following:

<img width="187" height="505" alt="image" src="https://github.com/user-attachments/assets/14c0e4d1-d8f6-4dab-88c6-c46e70c89474" />



Use the following as code as a basis for your solution:



```java
 Map<Boolean, List<Person>> byEmployment
                = people
                .stream()
                .collect(
                        Collectors.groupingBy(Person::isEmployed)
                );

        for (Map.Entry<Boolean, List<Person>> entry : byEmployment.entrySet()) {
            String status = entry.getKey() ? "Employed" : "Unemployed";
            System.out.println(status + ": " + entry.getValue());
        }

        
```


The code takes a list of people and groups them based on whether they are employed or unemployed. It creates two groups in a `Map`: one for `true` (employed) and one for `false` (unemployed). It then loops through these groups and prints the employment status along with the list of people in each group.


The output would look something like the following:


<img width="1678" height="85" alt="image" src="https://github.com/user-attachments/assets/5d83c8da-ef65-474c-9b7b-0f7ace0ee031" />



