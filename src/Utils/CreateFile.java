package Utils;
import java.io.File;
import java.io.IOException;

public class CreateFile {
     private String path = "c:\\GitHubProjects\\java\\learning\\Outputs\\";

    public File createFile(String title) {  
        //todo: зачем две строчки ниже, если код вообще не взаимодействует ни с доменом, ни с сериализацией
        // Cookbook book = new Cookbook();
        // ObjectMap objectMap = new ObjectMap();
        //fileName = title;
        String file1 = path + title;
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
    }    
}