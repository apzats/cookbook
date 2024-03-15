package Utils;
import java.io.*;

public class FileIO {
    private File fileFileld;
    public String fileName;

    public FileIO(){};
    public FileIO(String fileName) { 
        CreateFile createFile = new CreateFile();
        File newFile = createFile.createFile(fileName); 
        this.fileFileld = newFile;
        this.fileName = "";
    }
    

    // public String getExtension(){
    //     String extension = getFilenameExtension(fileName);
    //     return extension;
    // }


    public String getExtension(String inputText){
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
