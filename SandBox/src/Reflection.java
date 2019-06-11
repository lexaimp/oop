import java.io.*;
import java.lang.reflect.Field;

public class Reflection {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("IOStreamTest");
            Class[] interfaces = c.getInterfaces();
            Field field = c.getDeclaredField("string");
            for (Class anInterface : interfaces) {
                System.out.println(anInterface);
            }
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("MyClass.bin"))) {
            out.writeObject(new MyClass("Hi"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("MyClass.bin"))) {
            MyClass myClass = (MyClass) in.readObject();
            System.out.println(myClass.getTestField());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
