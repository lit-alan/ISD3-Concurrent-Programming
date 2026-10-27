package src;

import src.model.Person;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
class SearchWithCallable implements Callable<Integer> {

    List<Person> list;
    Predicate<Person> condition;

    public SearchWithCallable(List<Person> list, Predicate<Person> condition) {

        this.list = list;
        this.condition = condition;
    }//end constructor

    @Override
    public Integer call() throws Exception {
        int counter = 0;
        for (Person person : list) {
            if (condition.test(person)) {
                counter++;
            }
        }
        return counter;
    }//end call
}//end src.SearchWithCallable