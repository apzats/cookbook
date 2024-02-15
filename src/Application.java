import java.util.Scanner;
import DomainArea.*;
import Playground.SerializeTest;
import Serialization.SerializeFactory;
import Serialization.Abstract.Serializer;
import Serialization.Libraries.ObjectMap;
import Serialization.Libraries.Xml;
import Utils.CreateFile;
import Utils.FileIO;

import java.io.File;
import java.lang.String;

public class Application {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Cookbook book = new Cookbook();

        int choice = 0;
        String input = "";

        while (!"4".equals(input)) {
            System.out.println("1. Для добавления рецепта введите 1");
            System.out.println("2. Для просмотра всех рецептов введите 2");
            System.out.println("3. Для поиска рецепта введите 3");
            System.out.println("4. Для выхода из приложения введите 4");
            input = userInput.next();

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }

            switch (choice) {
                case 1:                
                    Recipe rec = makeRecipe(userInput);
                    book.addRecipe(rec);
                    break;
                case 2:
                    getAllRecs(book);
                    break;
                case 3:
                    menuSearchRecipes(userInput, book);
                    break;
                case 4:
                    //exit
                    break;
                case 5:
                    // System.out.println(testFileSerializeXml(userInput,book,xml));
                    //testFileXmlWrite(userInput,book,xml);
                    // testFileDeserializeXml(userInput,book,xml);
                    //testDeserializeFromFileXml(userInput,book,xml);
                    // String inputText = input(userInput);
                    //splitter(userInput,book,objectMap,xml);
                    //xmlserializer.serialize(book);
                    //jsonserializer.serialize(book);
                    //serializeFactory.chooseSerializer(null);
                    //getSubstring(userInput, book, objectMap, xml);
                    splitter(userInput, book);

                
                    break;       
                case 8:
                    System.out.println("Адьёз липидос!");    
                    System.exit(0);    
                default:
                    System.out.println("Введено неверное значение меню.\n");
            }
        }

        userInput.close();
    }

    //todo: иногда стоит подумать, что если ты таскаешь кучу параметров по вложенным методам, что-то пошло не так.
    public static void splitter(Scanner userInput, Cookbook book) {
        FileIO fileIO = new FileIO();
        fileIO.createNamedFile();
        String extension = fileIO.getExtension();
        Serializer newSerializer = SerializeFactory.chooseSerializer(extension);
        book.addRecipe(makeRecipe(userInput));
        String serializedString = newSerializer.serialize(book);
        fileIO.write(serializedString);
    }

    public static Recipe makeRecipe(Scanner userInput) {
        Recipe rec1 = new Recipe();

        System.out.print("Введи название: ");
        String title = userInput.next();
        rec1.setName(title);

        int len = 0;
        while (true) {
            System.out.print("Введи количество ингредиентов: ");
            try {
                len = userInput.nextInt();
                break;
            } catch (RuntimeException e) {
                System.out.println("Это не число. Попробуйте ещё раз.");
                continue;
            }
        }

        for (int k = 0; k < len; k++) {
            Ingridient item = new Ingridient();
            System.out.print("Введи ингредиенты: ");
            item.setIngridientText(userInput.next());

            int inp = 0;
            while (true) {
                System.out.print("Введи количество ингридиента: ");
                try {
                    inp = userInput.nextInt();
                    item.setQuantityIngridient(inp);
                    break;
                } catch (RuntimeException e) {
                    System.out.println("Это не число. Попробуйте ещё раз.");
                }
            }

            System.out.print("Введи тип количества(штуки,граммы или миллилитры): ");
            item.setType(userInput.next());
            rec1.addIngridient(item);
        }
        return rec1;
    }

    public static void doActualSearch(String text, Cookbook book) {
        Cookbook bookForPrint = book.searchRecipes(text);
        System.out.println("Мы искали и нашли: " + (bookForPrint.getTextRecipes()));
    }

    public static void menuSearchRecipes(Scanner userInput, Cookbook book) {
        System.out.println("Введи слово для поиска: ");
        String substring = userInput.next();

        doActualSearch(substring, book);
    }
    
    public static void getAllRecs(Cookbook book) {
            System.out.println(book.getTextRecipes());
    }
}
