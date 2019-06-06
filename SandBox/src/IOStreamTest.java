import java.io.*;

public class IOStreamTest {
    public static void main(String[] args) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("/home/imp/oop/SandBox/testFile.txt"));
            int read;
            int off = 0;
            byte[] res = new byte[9999999];
            while ((read = bufferedInputStream.read(res, off, res.length - off)) != -1) {
                off += read;
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("/home/imp/oop/SandBox/testFile1.txt"));
            bufferedOutputStream.write(res, 0, off);
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("/home/imp/oop/SandBox/String.txt"));
            PrintWriter printWriter = new PrintWriter(bufferedOutputStream);
            for (int i = 1; i <= 100; i++) {
                printWriter.print("«Строка " + i + "»");
                if (i == 100) {
                    break;
                }
                printWriter.print(System.lineSeparator());
            }
            printWriter.printf("%nhello").println();
            printWriter.print("bye");
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
