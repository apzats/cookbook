import java.io.*;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Writer {
    private File fileFileld;

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
        char[] charArray;
        String readedString = "";

        try(FileReader reader = new FileReader(fileFileld))
        {
            charArray = new char[(int)fileFileld.length()]; 
            reader.read(charArray);
 
            readedString = new String(charArray);
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return (readedString);

    }

    
}
