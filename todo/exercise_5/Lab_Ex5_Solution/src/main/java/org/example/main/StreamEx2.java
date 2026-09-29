package org.example.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx2 {

    public static void run() {

        List<String> months = Arrays.asList(
                "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"
        );

        /*
        TASK 10
         */
        System.out.println(months.stream().count());

        /*
        TASK 11
         */
        months.stream()
                .filter(m -> m.startsWith("J"))
                .forEach(System.out::println);

       /*
        TASK 12
         */
        months.stream()
                .filter(m -> m.length() <= 5)
                .forEach(System.out::println);

       /*
        TASK 13
         */
        months.stream()
                .filter(m -> m.endsWith("ber") && m.length() == 8)
                .forEach(System.out::println);

       /*
        TASK 14
         */
        List<String> filteredMonths = months.stream()
                .map(m -> {
                    if (m.contains("a")) {
                        return m.replaceAll("a", "@");
                    } else {
                        return m;
                    }
                })
                .collect(Collectors.toList());
 
        filteredMonths.stream().forEach(System.out::println);
    }
}
