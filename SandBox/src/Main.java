import java.io.*;

public class Main {
    public static void main(String[] args) {
        SymmetricalMatrix matrix = new SymmetricalMatrix(5);
        System.out.println(matrix);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("matrix.bin"))) {
            outputStream.writeObject(matrix);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("matrix.bin"))) {
            SymmetricalMatrix matrix1 = (SymmetricalMatrix) inputStream.readObject();
            System.out.printf("%s", matrix1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
