package src;

import src.model.Person;

import java.util.List;


class SearchNameRunnable implements Runnable {

    private List<Person> list;
    private String searchName;

    public SearchNameRunnable(List<Person> list, String searchName) {
        this.list = list;
        this.searchName = searchName;
    }

    @Override
    public void run() {
        boolean found = false;

        for (Person record : list) {
            if (record.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Name: " + record.getName());
                System.out.println("Code: " + record.getCode());
                System.out.println("Indicator: " + record.getIndicator());
                found = true;
            }
        }

        if (!found) {
            System.out.println(searchName + " was not found.");
        }
    }
}