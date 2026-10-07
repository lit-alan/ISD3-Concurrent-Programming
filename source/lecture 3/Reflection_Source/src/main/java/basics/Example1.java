package basics;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JButton;


public class Example1 {

 
    public static void main(String[] args) {

      
        JButton btn = new JButton("Click ME");
        Integer i =10;
        String str = new String("The quick brown fox jumps over the lazy dog");
        File f = new File("c:\temp.txt");
        
        Object[] arr = new Object[5];
        arr[0] = btn;
        arr[1] = i;
        arr[2] = str;
        arr[3] = f;
        arr[4] = 23;

        Customer c = new Customer("Tom", 34);
        
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        
      //  Object AnotherObject =
        printMethodNames(arr[randomNum]);
        printMethodNames(c);
    }

    private static void printMethodNames(Object AnObject) {
       
        Class c = AnObject.getClass();
        Method[] methods   =c.getMethods();
        
        System.out.println("Methods of the " + c.getName() + " class");
        for(Method method : methods){
            System.out.println(method.getName());
        }
    }
    
}

 class Customer {
    private String name;
    private int age;
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

     public int getAge() {
         return age;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public void setAge(int age) {
         this.age = age;
     }
 }
