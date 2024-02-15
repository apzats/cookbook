package Playground;

import java.io.File;

import DomainArea.Cookbook;
import Utils.CreateFile;
import Utils.FileIO;

/**
 * Класс-песочница для проверки работы кода по работе с файлами. 
 */
public class FileOperations {

    //todo: обрати внимание, как сократилось кол-во параметров методов. Т.к они работают с тестовыми данными, 
    //то даже Книгу не нужно передавать, остальное создаётся прямо на месте. 
    //В итоге передаётся необходимый минимум, что избавляет тебя в мэйне от утомительной передачи всех параметров

    public static void testJsonFileWrite(String fileName) { 
        CreateFile createFile = new CreateFile();
        File newFile = createFile.createFile(fileName);
        FileIO writer = new FileIO(newFile);
        Cookbook book = Mocker.makeTestBook();

        String result = SerializeTest.testJsonSerializeBook(book);
        writer.write(result);
    }

    public static void testXmlFileWrite(String fileName) { 
        CreateFile createFile = new CreateFile();
        File newFile = createFile.createFile(fileName);
        FileIO writer = new FileIO(newFile);
        Cookbook book = Mocker.makeTestBook();

        String result = SerializeTest.testXmlSerializeBook(book);
        writer.write(result);
    }

    public static void testJsonFileRead(String fileName) {
        CreateFile createFile = new CreateFile();
        File existingFile = createFile.createFile(fileName);
        FileIO writer = new FileIO(existingFile);
        String result = writer.read();

        Cookbook book = SerializeTest.testJsonDeserializeBook(result);
        System.out.println(book.getTextRecipes());
    }

    public static void testXmlFileRead(String fileName) {
        CreateFile createFile = new CreateFile();
        File existingFile = createFile.createFile(fileName);
        FileIO writer = new FileIO(existingFile);
        String result = writer.read();
        
        Cookbook book = SerializeTest.testXmlDeserializeBook(result);
        System.out.println(book.getTextRecipes());
    }

    public static void testChooseByFileExtension(String inputText) {
        // System.out.println("Введи название файла c .json или с .xml:");
        
        String substring = FileIO.getFilenameExtension(inputText);
        if (substring.equals("json")) {
            FileOperations.testJsonFileWrite(inputText);
          } else if(substring.equals("xml")){
            FileOperations.testXmlFileWrite(inputText);
          } else {
            System.out.println("Неправильно указано расширение файла.");
        }
    }
}