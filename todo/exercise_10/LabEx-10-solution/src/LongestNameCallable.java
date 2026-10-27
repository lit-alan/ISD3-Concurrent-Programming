package src;

import src.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/** Returns every record whose name has the maximum length. */
public class LongestNameCallable implements Callable<List<Person>> {
    private final List<Person> records;

    public LongestNameCallable(List<Person> records) {
        this.records = records;
    }

    @Override
    public List<Person> call() {
        List<Person> longestNames = new ArrayList<>();
        int maximumLength = 0;

        for (Person record : records) {
            int length = record.getName().length();

            if (length > maximumLength) {
                maximumLength = length;
                longestNames.clear();
                longestNames.add(record);
            } else if (length == maximumLength) {
                longestNames.add(record);
            }
        }

        return longestNames;
    }
}
