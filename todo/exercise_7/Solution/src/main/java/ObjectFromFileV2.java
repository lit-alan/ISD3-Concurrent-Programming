import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ObjectFromFileV2 {

    static List<Object> objectList = new ArrayList();

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException  {
        boolean data = true;

        try {
            File file = new File("Objects.dat");

            if (!file.exists()) {
                System.out.println("Can't find file.");
            } else {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                while (data) {
                    try {
                        objectList.add(objectInputStream.readObject());

                    } catch (EOFException end) {
                        data = false;
                    }

                }
            }

            printObjectDetails(objectList);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Problem reading from file: " + e);
        }
    }

    static void printObjectDetails(List<Object> objList) throws IllegalArgumentException, IllegalAccessException {
        for (Object o : objList) {
            Class c = o.getClass();

            System.out.println("Name of Class: " + c.getName());
            Field[] publicFields = c.getFields();

            for (Field publicField : publicFields) {
                publicField.setAccessible(true);
                String fieldName = publicField.getName();
                Class classType = publicField.getType();
                String fieldType = classType.getName();
                String value = publicField.get(o).toString();
                System.out.println("Field Details: " + fieldName);
                System.out.println("Type: " + fieldType);
                System.out.println("Value: " + value);
                System.out.println("");
            }

            System.out.println("----------------------------");
            System.out.println("");

        }
    }

}
