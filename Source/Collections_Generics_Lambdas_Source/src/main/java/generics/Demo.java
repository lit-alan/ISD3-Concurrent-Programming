package generics;

import javax.swing.*;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList(7);
        names.add("Alan");
        names.add("233232sd we");
        names.add("wew wew wewe");
        names.add("wewe w");
        names.add("a");
        System.out.println(names.get(3));
names.remove("Alan");
        if(names.contains("Alan"))
            System.out.println("Alan is in the list");
        else
            System.out.println("Alan is not in the list");
//        for (String aName: names) {
//            System.out.println(aName.length());
//        }

//        ArrayList ages = new ArrayList();
//        ages.add(23);
//        ages.add(45);
//        ages.add(56);
//        ages.add("56");
//        ages.add("Another String");
//        ages.add(new JButton("Click me"));
//
//        for (Object x: ages) {
//            String value= (String)x;
//            System.out.println(value.length());
//        }

    }
}
