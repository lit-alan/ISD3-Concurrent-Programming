import java.io.*;
import java.lang.reflect.Field;

public class ObjectFromFileV1 
{
    
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException 
    {
        boolean data = true;
        
        try
        {
            File file = new File("Objects.dat");
            
            if(!file.exists())
            {
                System.out.println("Can't find file.");
            }
            else
            {

                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                
                while(data)
                {
                    try
                    {

                        Object o = objectInputStream.readObject();
                        Class c = o.getClass();
                        System.out.println("Name of Class: " + c.getName());
                        Field[] publicFields = c.getFields();
                        
                        for (Field publicField : publicFields) 
                        {
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
                    catch (EOFException end)
                    {
                        data = false;
                    }
                    
                    
                }
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Problem reading from file: " + e);
        }
    }    
}
