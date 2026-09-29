package main;

import io.FileIO;
import model.Medals;

import java.util.ArrayList;

/**
 *
 * @author Alan.Ryan
 */
public class Main {

    public static void main(String[] args) {
       //put your code here
        ArrayList<Medals> list = FileIO.readFile("medals.txt");

        list.stream().forEach(System.out::println);


    }
}
