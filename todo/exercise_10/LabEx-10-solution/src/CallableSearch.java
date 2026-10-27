package src;

import src.model.Person;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

class CallableSearch implements Callable<Integer> {

    List<Person> list;
    String searchTerm;

    public CallableSearch(List<Person> list, String searchTerm) {

        this.list = list;
        this.searchTerm = searchTerm;
    }//end constructor

    @Override
    public Integer call() throws Exception {
        int counter = 0;
        for (Person person : list) {
              if  (person.getCode().equalsIgnoreCase(searchTerm))
               counter++;
        }
        return counter;
    }//end call
}//end src.SearchWithCallable