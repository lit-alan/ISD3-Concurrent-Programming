package isd3.src.classes.task1;


public class Main {

    public static boolean testNumber(int number, NumberTest test) {
        return test.test(number);
    }

    public static void main(String[] args) {

        //test even
        System.out.println("Is 8 even? " + testNumber(8, n -> n % 2 == 0));

        //test odd
        System.out.println("Is 8 odd? " + testNumber(8, n -> n % 2 != 0));

        //test greater
        System.out.println("Is 15 greater than 10? " + testNumber(15, n -> n > 10));

        //test multiple
        System.out.println("Is 21 a multiple of 7? " + testNumber(21, n -> n % 7 == 0));

        //Store a lambda in a variable
        NumberTest nt = n -> n % 2 == 0;
        System.out.println("Is 12 even? " + testNumber(12, nt));
    }
}