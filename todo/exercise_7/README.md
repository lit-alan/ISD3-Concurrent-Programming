## Lab Exercise 7️⃣

The starter code for this exercise contains a file called `Objects.dat`. This file contains a number of Objects. 

Using reflection, write a program that reads the objects from the file and displays:

1. The name of the class of the object.
2. Details of each field in the class, including its name and type.
3. The value of each field in the object.
   
The following code demonstrates how to read an object from a file and you will need to add it to the starter code:

```java
import java.io.*;

class ObjectFromFile{

    public static void main(String args[]){

        boolean data = true;
        try{

            File f = new File("Objects.dat");
            if (!f.exists()) {
                Screen.message("Can not find file !!!!!");
            }else{
                FileInputStream FIS = new FileInputStream(f);
                ObjectInputStream OIS = new ObjectInputStream(FIS);

                while(data){
                    try{

                        Object o = (Object) OIS.readObject();

                    }catch (EOFException end){
                        data = false;
                    } // catch
                } // while loop
            } // end else

        }catch(Exception e){
            Screen.message("Problem reading from file" + e);
        }

    } // end main
}


```
