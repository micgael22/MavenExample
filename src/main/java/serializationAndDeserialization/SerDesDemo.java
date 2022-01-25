package serializationAndDeserialization;

import javax.imageio.stream.FileImageOutputStream;
import java.io.*;

public class SerDesDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("John",25,"25 Longstreet, Western Cape");

        String filename = "src/main/java/serializationAndDeserialization\\Test.txt";
        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;

        //Serialization
        try {
            fileOut = new FileOutputStream(filename);
            objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(student);

            objOut.close();
            fileOut.close();

            System.out.println("Object has been serialized: \n " + student);
        }
        catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        //Deserialization
        FileInputStream fileIn = null;
        ObjectInputStream objIn = null;

        try {
           fileIn = new FileInputStream(filename);
           objIn = new ObjectInputStream(fileIn);

        Student object = (Student) objIn.readObject();
        System.out.println("Object has been deserialize: \n " + object);

        objIn.close();
        fileIn.close();
    }
    catch (IOException ex) {
        System.out.println("IOException is caught");
    }
    catch (ClassNotFoundException ex) {
        System.out.println("ClassNotFoundException" + "is caught");
        }
    }
}
