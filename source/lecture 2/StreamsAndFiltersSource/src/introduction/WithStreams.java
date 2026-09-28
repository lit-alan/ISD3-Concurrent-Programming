package introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WithStreams {

    public static void main(String[] args) {
              List<Integer> l1 = Arrays.asList(25,16,10,14,5,7,14,25,23,17);
        List<Integer> l2 = Arrays.asList(8,3,75,1,15,70,7,2,55,3);
        
        List<Integer> l3 = l1.stream().filter(x -> x % 5 ==0).collect(Collectors.toList());
        List<Integer> l4 = l2.stream().filter(x -> x % 5 !=0).collect(Collectors.toList());
        
        int y = l3.stream().reduce((w,x) -> x + w).get();
        
        System.out.println("y " + y);
        int z = l4.stream().filter(x -> x >=50).findAny().orElse(50);
        System.out.println("z " + z);
        System.out.println(y+z);
        
//        List<String> names = new ArrayList<>();
//        names.add("Pablo");
//        names.add("Javier");
//        names.add("Steve");
//        names.add("Gustavo");
//        names.add("Tata");
//        names.add("Valeria");
//        names.add("Fernando");
//        
//        names.stream().forEach(System.out::println);
        
    }
      

}
