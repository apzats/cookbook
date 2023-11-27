import java.io.*;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Writer {
    private File fileFileld;

    // private String fileName;
    public Writer(File file) {
        this.fileFileld = file;
    }

    public void write(String text) {
        try {
            FileWriter writer = new FileWriter(fileFileld);
            writer.write(text);
            writer.flush();
            writer.close();
            System.out.println("Рецепт записан в файл!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String read() {
        char[] buf = new char[256];
        try (FileReader reader = new FileReader(fileFileld)) {
            int c;
            while ((c = reader.read(buf)) > 0) {

                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return (new String(buf));

    }

}
