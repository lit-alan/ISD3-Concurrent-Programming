package org.example.main;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class StreamEX1 {

    public static void run() {

        List<Integer> list = Arrays.asList(23, 5, 67, 4, 3, 31, 90, 12, 45, 89);

        /*
        TASK 1
         */
        list.stream().forEach(System.out::println);

        //or
        //Stream.of(list).forEach(System.out::println);


        /*
        TASK 2
         */
        list.stream().sorted().forEach(System.out::println);



        /*
        TASKS 3, 4, 5, 6
         */

        IntSummaryStatistics stats = list.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());

//       or
//        int highest = list.stream()
//                .mapToInt(x -> x)
//                .max()
//                .getAsInt();
//
//        int lowest = list.stream()
//                .mapToInt(x -> x)
//                .min()
//                .getAsInt();
//
//        int sum = list.stream()
//                .mapToInt(x -> x)
//                .sum();
//
//        double average = list.stream()
//                .mapToInt(x -> x)
//                .average()
//                .getAsDouble();
//
//        System.out.println("Highest number in List : " + highest);
//        System.out.println("Lowest number in List : " + lowest);
//        System.out.println("Sum of all numbers : " + sum);
//        System.out.println("Average of all numbers : " + average);



        /*
        TASK 7
         */
        list.stream()
                .filter(x-> x < 20)
                .forEach(System.out::println);

        /*
        TASK 8
         */
        list.stream()
                .filter(x -> x >= 20 && x <= 50)
                .forEach(System.out::println);

        /*
        TASK 9
         */
        list.stream()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);
    }
}
