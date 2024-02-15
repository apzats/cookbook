package Utils;
import java.io.*;
// import java.util.Arrays;
import java.util.Scanner;
// import org.apache.commons.io.FilenameUtils;

// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;

public class FileIO {
    private File fileFileld;
    public String fileName = "";

    public FileIO(){};
    public FileIO(File file) {
        this.fileFileld = file;
    }
    Scanner userInput = new Scanner(System.in);

    public void createNamedFile() {
        System.out.println("Введи название файла c .json или с .xml:");
        fileName = userInput.next();
        CreateFile createFile = new CreateFile();
        File newFile = createFile.createFile(fileName);
        FileIO writer = new FileIO(newFile);

        //todo: созданы File и FileIO, может, стоит их сохранить в какие-то поля?
    }
    
    public String getExtension(){
        String extension = getFilenameExtension(fileName);
        return extension;
    }

    // public String getExtensionByApacheCommonLib(String filename) {
    //     return FilenameUtils.getExtension(filename);
    // }

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
