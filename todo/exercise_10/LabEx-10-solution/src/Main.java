package src;

import src.model.Person;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final String FILE = "census.txt";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Person> list;

        try {
            list = readRecords(Paths.get(FILE));
        } catch (IOException | IllegalArgumentException ex) {
            System.out.println("Could not read the census file: " + ex.getMessage());
            return;
        }

        System.out.println(list.size() + " records found");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> future = executor.submit(new CallableSearch(list,"FO"));
        System.out.println("FO COUNT " + future.get());
        try {
           //task 1: get the stats
            Future<Integer> f1 = executor.submit(new SearchWithCallable(list, (Person p) -> p.getCode().equalsIgnoreCase("MF")));
            Future<Integer> f2 = executor.submit(new SearchWithCallable(list, p -> p.getCode().equalsIgnoreCase("MO")));
            executor.submit(new SearchWithRunnable(list, p -> p.getCode().equalsIgnoreCase("FO")));
            executor.submit(new SearchWithRunnable(list, p -> p.getIndicator().equalsIgnoreCase("LY")));
            executor.submit(new SearchWithRunnable(list, p -> p.getIndicator().equalsIgnoreCase("LN")));
            try {
                //get future values of Callables
                System.out.println(list.size() + " records found");
                System.out.println("MF found " + f1.get() + " times");
                System.out.println("MO found " + f2.get() + " times");

            } catch (InterruptedException | ExecutionException ex) {
                System.out.println(ex);
            }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //task 2: search for a name
            Future<List<Person>> longestNamesFuture =
                    executor.submit(new LongestNameCallable(list));

            try {
                //Retrieve the results (waits for the task to finish)
                List<Person> longestNames = longestNamesFuture.get();

                if (!longestNames.isEmpty()) {
                    int length = longestNames.get(0).getName().length();

                    System.out.println("\nLongest name(s), length " + length + ":");

                    for (Person person : longestNames) {
                        System.out.println(person.getName());
                    }
                }

            } catch (InterruptedException | ExecutionException ex) {
                System.out.println(ex);
                Thread.currentThread().interrupt();
            }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
           //task 3: search for a name
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a name to search for: ");
            String searchName = scanner.nextLine();

            executor.submit(new SearchNameRunnable(list, searchName));

        } finally {
            executor.shutdown();
        }
    }

    private static List<Person> readRecords(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        List<Person> records = new ArrayList<>();

        if (lines.isEmpty()) {
            return records;
        }

        // The first line contains the column headings.
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.trim().isEmpty() || line.length() < 6) {
                continue;
            }

            String code = line.substring(0, 2).trim();
            String indicator = line.substring(2, 5).trim();
            String name = line.substring(5).trim();
            if (!name.isEmpty()) {
                records.add(new Person(code, indicator, name));
            }
        }
        return records;
    }

}
