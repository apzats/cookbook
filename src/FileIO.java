import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIO {
    private File fileFileld;
    public String fileName = "";

    public FileIO(){};
    public FileIO(File file) {
        this.fileFileld = file;
    }
    Scanner userInput = new Scanner(System.in);
    Application application = new Application();

    public void createNamedFile(Cookbook book, ObjectMap objectMap) {
        System.out.println("Введи название файла c .json или с .xml:");
        fileName = userInput.next();
        CreateFile createFile = new CreateFile();
        File newFile = createFile.createFile(fileName);
        FileIO writer = new FileIO(newFile);
        // String fileJson = application.testFileSerialize(userInput, book, objectMap);
        // writer.write(fileJson);
    }
    
    public String getExtension(){
        String extension = getFilenameExtension(fileName);
        return extension;
    }

    public static String getFilenameExtension(String inputText){
        String substring = inputText.substring(inputText.indexOf(".")+ 1,inputText.length());
        return substring;
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
