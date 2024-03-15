package Playground;

import java.io.File;
import java.io.IOException;

import DomainArea.Cookbook;
import Serialization.SerializeFactory;
import Serialization.Abstract.Serializer;
import Utils.CreateFile;
import Utils.FileIO;

/**
 * Класс-песочница для проверки работы кода по работе с файлами. 
 */
public class FileOperations {

    public static void testSplitterSerial() {
        Cookbook testBook = Mocker.makeTestBook();
        String input2 = "kukar.xml";
        FileIO fileIO = new FileIO(input2);
        String extension = fileIO.getExtension(input2);
        Serializer newSerializer = SerializeFactory.chooseSerializer(extension);
        String result = newSerializer.serialize(testBook);
        Playground.FileOperations.testFileWrite(input2,result);
    }

    public static void testSplitterDeserial() { 
        //Cookbook testBook = Mocker.makeTestBook();
        //String stringBook = testBook.getTextRecipes();
        String input2 = "kukar.xml";
        FileIO fileIO = new FileIO(input2);
        String resultReadng = Playground.FileOperations.testFileRead(input2);
        String extension = fileIO.getExtension(input2);
        Serializer newSerializer = SerializeFactory.chooseSerializer(extension);
        Cookbook resultBook = newSerializer.deserialize(resultReadng);
        //Playground.FileOperations.testFileRead(input2);
        System.out.println(resultBook.getTextRecipes());
    }

    public static void testJsonFileWrite(String fileName, String book) { 
        //CreateFile createFile = new CreateFile();
        //File newFile = createFile.createFile(fileName);
        FileIO writer = new FileIO();
        //Cookbook book = Mocker.makeTestBook();

        //String result = SerializeTest.testJsonSerializeBook(book);
        writer.write(book);
        //return newFile;
    }

    public static void testXmlFileWrite(String fileName, String book) { 
        // CreateFile createFile = new CreateFile();
        // File newFile = createFile.createFile(fileName);
        FileIO writer = new FileIO();
        //Cookbook book4 = Mocker.makeTestBook();

        //String result = SerializeTest.testXmlSerializeBook(book4);
        writer.write(book);
        //return newFile;
    }

    public static void testFileWrite(String fileName, String book) { 

        try {
            FileIO writer = new FileIO(fileName);
            writer.write(book);
        } catch (RuntimeException e) {
            System.out.println("Ошибка записи файла.");
            e.getMessage();
        }
    }

    public static String testFileRead(String fileName) {
        String result = "";

        try{
        FileIO writer = new FileIO(fileName);
        result = writer.read();
        } catch (RuntimeException e) {
            System.out.println("Ошибка чтения файла.");
            e.getMessage();
        }
        return result;

    }

    // public static void testXmlFileRead(String fileName) {  
    //     CreateFile createFile = new CreateFile();
    //     File existingFile = createFile.createFile(fileName);
    //     FileIO writer = new FileIO(existingFile);
    //     String result = writer.read();
        
    //     Cookbook book = SerializeTest.testXmlDeserializeBook(result);
    //     System.out.println(book.getTextRecipes());
    // }

    // public static void testChooseByFileExtension(String inputText) {
    //     // System.out.println("Введи название файла c .json или с .xml:");
        
    //     String substring = FileIO.getFilenameExtension(inputText); 
    //     if (substring.equals("json")) {
    //         FileOperations.testJsonFileWrite(inputText);
    //       } else if(substring.equals("xml")){
    //         FileOperations.testXmlFileWrite(inputText);
    //       } else {
    //         System.out.println("Неправильно указано расширение файла.");
    //     }
    // }

    // public static void testJsonFileRead(String fileName) {
    //     CreateFile createFile = new CreateFile();
    //     File existingFile = createFile.createFile(fileName);
    //     FileIO writer = new FileIO(existingFile);
    //     String result = writer.read();
        
    //     Cookbook book = SerializeTest.testXmlDeserializeBook(result);
    //     System.out.println(book.getTextRecipes());
    // }    

}