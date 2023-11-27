import java.io.*;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;

public class Writer {
    private String fileName;
    


    public File createFile(String title) {
        Cookbook book = new Cookbook();
        ObjectMap objectMap = new ObjectMap();
        fileName = title;
        String file1 = "c:\\GitHubProjects\\java\\learning\\Outputs\\" + fileName + ".txt";
        File file = new File(file1);
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла");
            e.getMessage();
        }
        return file;
        //file1.writer(objectMap); 
        
    }    

    public void writer(ObjectMap objectMap) {    
        //ObjectMap objectMap = new ObjectMap();
        Ingridient ingridient = new Ingridient();
        String fileRec = objectMap.serialize();    
        try { 
            FileWriter writer = new FileWriter(createFile(fileName)); 
            writer.write(fileRec);
            writer.close();
            System.out.println("Рецепт записан в файл!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void reader() {
        try (FileReader reader = new FileReader("C:\\GitHubProjects\\java\\learning\\output.txt")) {
            char[] buf = new char[256];
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
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }

    // public void setFileText(String fileName) {
        // this.fileText = fileText;
    // }

    // public String getFileText() {
        // return this.fileText;
    // }

}
