package Utils;
import java.io.File;
//import java.io.IOException;
import java.io.IOException;

public class CreateFile {
     private String path = "c:\\GitHubProjects\\java\\learning\\Outputs\\";

    public File createFile(String title) {  ;
        String file1 = path + title;
        File file = new File(file1);
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка доступа, невозможно записать файл.");
            
        }
        return file;        
    }    

    public File checkExistingFile(String title) {  
        String file1 = path + title;
        File file = new File(file1);
        try {
            if (!file.createNewFile()) {
                return file;
            } else {
               System.out.println("Такого файла нет.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при проверке наличия файла.");
            e.getMessage();
        }
         return file;
    }    
}