package src;


import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import src.model.Person;


public class Main {

    //I'm going to read the data from the file into a List<Person>
    static List<Person> list = new ArrayList();
    static String file = "census.txt";

    public static void main(String[] args) {

        parseFile(file);

        list.forEach(System.out::println);


    }//end main

    private static void parseFile(String file) {
        FileReader frs;
        StreamTokenizer in;

        String code = "";
        String indicator = "";
        String name = "";

        try {
            frs = new FileReader(file);
            in = new StreamTokenizer(frs);

            //read headers
            in.nextToken();
            in.nextToken();
            in.nextToken();

            in.nextToken(); //first token of first record

            while (in.ttype != StreamTokenizer.TT_EOF) {

                //read code
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    code = in.sval.trim();
                } else {
                    System.out.println("Bad file format reading code");
                }

                //read indicator
                if (in.nextToken() == StreamTokenizer.TT_WORD) {
                    indicator = in.sval.trim();
                } else {
                    System.out.println("Bad file format reading indicator");
                }

                //read the name (dont need it for this exercise, but I'll read it anyway)
                if (in.nextToken() == StreamTokenizer.TT_WORD) {
                    name = in.sval.trim();
                } else {
                    System.out.println("Bad file format reading name");
                }
                //create a new Record and add it to the list
                list.add(new Person(code, indicator, name));

                in.nextToken();
            }//end while

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }//end parseFile()
}//end class
