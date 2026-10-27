package src;

import java.util.List;
import java.util.function.Predicate;

import src.model.Person;



class SearchWithRunnable implements Runnable {

    List<Person> list;
    Predicate<Person> condition;
    String searchKey;

    public SearchWithRunnable(List<Person> list, Predicate<Person> condition) {
        this.searchKey = searchKey;
        this.list = list;
        this.condition = condition;
    }//end constructor


    @Override
    public void run() {
        int counter = 0;
        for (Person person : list) {
            if (condition.test(person)) {
                counter++;
            }
        }
        System.out.println(searchKey + " found " + counter + " times");
    }
}//end src.SearchWithRunnable