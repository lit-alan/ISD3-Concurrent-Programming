package org.example.main;

import org.example.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamEx3 {

    public static void main(String[] args) {
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


        /*
        TASK 15
         */
        System.out.println("================================================");

        System.out.println("People aged 20 to 35 who have a full driving licence:");
        people.stream()
                .filter(person -> person.getAge() >= 20 && person.getAge() <= 35)
                .filter(Person::isHasFullDrivingLicence)
                .forEach(System.out::println);



        /*
        TASK 16
         */
        System.out.println("================================================");

        double averageAge = people.stream()
                .filter(person -> !person.isEmployed())
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);

        System.out.println("Average age of people who are not employed: " + averageAge);


        /*
        TASK 17
         */
        System.out.println("================================================");

        System.out.println("Names of all employed people:");

        List<String> employedPeople = people.stream()
                .filter(Person::isEmployed)
                .map(Person::getName)
                .toList();

        employedPeople.forEach(System.out::println);


        /*
        TASK 18
         */
        System.out.println("================================================");

        System.out.println("People grouped by employment status:");
        Map<Boolean, List<String>> peopleByEmployment = people.stream()
                .collect(Collectors.groupingBy(
                        Person::isEmployed,
                        Collectors.mapping(Person::getName, Collectors.toList())
                ));

        peopleByEmployment.forEach((employed, names) -> {
            System.out.println(employed ? "\nEmployed:" : "\nNot employed:");
            names.forEach(System.out::println);
        });

    }
}
