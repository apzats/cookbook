import java.util.Scanner;
import java.io.File;
import java.lang.String;

public class Application {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        // Recipe recipeUnit = testRecipe(userInput);
        Cookbook book = new Cookbook();
        // CreateFile createFile = new CreateFile();
        // Writer writer = new Writer(createFile);
        ObjectMap objectMap = new ObjectMap();
        Ingridient ingridient = new Ingridient();
        Xml xml = new Xml();
        Serializer serializer = new XmlSerial(xml);
        //Serializer jsonserializer = new JsonSerializer();
        SerializeFactory serializeFactory = new SerializeFactory();
        FileIO fileIO = new FileIO();
        //Cookbook testBook = makeTestBook();
        // System.out.println(recipeUnit.toString());

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
                    testRecipe(userInput, book);
                    break;
                case 2:
                    getAllRecs(book);
                    break;
                case 3:
                    menuSearchRecipes(userInput, book);
                    break;
                case 4:
                    //objectMap.serialize(ingridient);
                    //testFileWrite(inputText,userInput, book, objectMap);
                    break;
                case 5:
                    //objectMap.deserialize();
                    // testFileRead(inputText,book,objectMap);
                    // Writer.reader();
                    break; 
                case 6:
                    System.out.println(testFileSerialize(userInput,book,objectMap));
                    //testFileDeserialize(userInput,book,objectMap);
                    break; 
                case 7:
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
                    splitter(fileIO, userInput, book, objectMap, xml, serializeFactory, serializer);

                
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

    /*public static void getSubstring(Scanner userInput, Cookbook book, ObjectMap objectMap, Xml xml) {
        System.out.println("Введи название файла c .json или с .xml:");
        String inputText = userInput.next();
        String substring = getFilenameExtension(inputText);
        if (substring.equals("json")) {
            testFileWrite(inputText, userInput, book, objectMap);
          } else if(substring.equals("xml")){
            //testFileXmlWrite(inputText, userInput, book, xml);
          } else {
            System.out.println("Неправильно указано расширение файла.");
        }
    }*/

    public static void splitter(FileIO fileIO, Scanner userInput, Cookbook book, ObjectMap objectMap, Xml xml, SerializeFactory serializeFactory, Serializer serializer) {
        fileIO.createNamedFile(book, objectMap);
        String extension = fileIO.getExtension();
        Serializer newSerializer = serializeFactory.chooseSerializer(extension);
        testRecipe(userInput,book);
        String serializedString = newSerializer.serialize(book);
        fileIO.write(serializedString);
    }

    //todo: здесь и далее, обрати внимание на количество параметров, которое нужно для работы каждого метода и дублирование логики обработки
    public static void testFileWrite(String inputText, Scanner userInput, Cookbook book, ObjectMap objectMap) { 
        CreateFile createFile = new CreateFile();
        File newFile = createFile.createFile(inputText);
        FileIO writer = new FileIO(newFile);
        String fileJson = testFileSerialize(userInput, book, objectMap);
        writer.write(fileJson);

    }

    public static void testFileRead(String inputText, Cookbook book, ObjectMap objectMap) {
        CreateFile fileCreator = new CreateFile();
        File existingFile = fileCreator.createFile(inputText);
        FileIO writer = new FileIO(existingFile);
        String result = writer.read();
        System.out.println(result);
    }

    public static String testFileXmlWrite(String inputText, Scanner userInput, Cookbook book, Xml xml) { 
        CreateFile createFile = new CreateFile();
        File newFile = createFile.createFile(inputText);
        FileIO writer = new FileIO(newFile);
        String fileXML = testFileSerializeXml(userInput, book, xml);
        writer.write(fileXML);
        return fileXML;
    }

    public static void testDeserializeFromFileXml(String inputText, Scanner userInput, Cookbook book, Xml xml) {
        String fileXML = testFileXmlWrite(inputText, userInput, book, xml);
        xml.deserializeXml(fileXML);
    }

    public static String testFileSerialize(Scanner userInput, Cookbook book, ObjectMap objectMap) {
        testRecipe(userInput,book);
        return objectMap.serializeToJson(book);
    }

    public static String testFileSerializeXml(Scanner userInput, Cookbook book, Xml xml) { 
        testRecipe(userInput,book);
        return xml.serializeToXML(book);
    }
    

    public static void testFileDeserialize(Scanner userInput, Cookbook book, ObjectMap objectMap) {
         testRecipe(userInput,book);
         String resultJson = objectMap.serializeToJson(book);
         objectMap.deserializeJson(resultJson);
    }

    public static void testFileDeserializeXml(Scanner userInput, Cookbook book, Xml xml) {
        testRecipe(userInput,book);
        String resultXml = xml.serializeToXML(book);
        xml.deserializeXml(resultXml);
    }

    // todo: Рецепт протестировала? Можно закомментить

    public static void testRecipe(Scanner userInput, Cookbook book) {
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

            System.out.print("Введи тип количества(штуки,граммы или миллил итры): ");
            item.setType(userInput.next());
            rec1.addIngridient(item);
        }
        book.addRecipe(rec1);
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

    /*public static Cookbook makeTestBook() {

        Cookbook book = new Cookbook();

        Recipe rec = new Recipe();
        rec.setName("pyureshka s kotletkoi");

        Ingridient[] ings = new Ingridient[] {
                new Ingridient("kartoshka", 3, "sht"),
                new Ingridient("moloko", 100, "ml"),
                new Ingridient("kotletka", 2, "sht"),
        };

        for (Ingridient item : ings) {
            rec.addIngridient(item);
        }

        book.addRecipe(rec);

        Recipe rec1 = new Recipe();
        rec1.setName("borschik");

        Ingridient[] ings1 = new Ingridient[] {
                new Ingridient("kartoshka", 3, "sht"),
                new Ingridient("myasko", 100, "gr"),
                new Ingridient("svekla", 2, "sht"),
        };

        for (Ingridient item1 : ings1) {
            rec1.addIngridient(item1);
        }

        book.addRecipe(rec1);

        Recipe rec2 = new Recipe();
        rec2.setName("kompotik");

        Ingridient[] ings2 = new Ingridient[] {
                new Ingridient("uryuk", 3, "gr"),
                new Ingridient("izyum", 100, "gr"),
                new Ingridient("chernoscliva", 2, "gr"),
        };

        for (Ingridient item2 : ings2) {
            rec2.addIngridient(item2);
        }

        book.addRecipe(rec2);

        return book;
    }*/

    /**
     * real main method, uncomment when needed
     * 
     * @param args
     */
    /*
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
     createRecipe(userInput, book);
     break;
     case 2:
     getAllRecs(book);
     break;
     case 3:
     menuSearchRecipes(userInput, book);
     break;
     default:
     System.out.println("Введено неверное значение меню.\n");
     }
     }
     
     userInput.close();
     }
     */

    /*
     * 
     * /*
     * public static Recipe makeRecipe(Scanner userInput) {
     * Recipe rec1 = new Recipe();
     * 
     * System.out.print("Введи название: ");
     * String title = userInput.next();
     * rec1.setName(title);
     * 
     * int len = 0;
     * System.out.print("Введи количество ингредиентов: ");
     * try {
     * len = userInput.nextInt();
     * } catch (RuntimeException e) {
     * System.out.println("Это не число. Попробуйте ещё раз.");
     * }
     * 
     * System.out.print("Введи ингредиенты: ");
     * for (int k = 0; k < len; k++) {
     * rec1.addIngridients(userInput.next());
     * int inp = 0;
     * for (int i = 0; i < len + 1; i++) {
     * System.out.print("Введи количество ингридиента: ");
     * try {
     * inp = userInput.nextInt();
     * rec1.setQIngridient(inp);
     * } catch (RuntimeException e) {
     * System.out.println("Это не число. Попробуйте ещё раз.");
     * }
     * 
     * System.out.print("Выбери тип количества: ");
     * int userChoice = 0;
     * String inputChoice = "";
     * 
     * for (int j = 0; j < len - 1; j++) {
     * System.out.println("1. Чтобы выбрать \"граммы\" введите 1");
     * System.out.println("2. Чтобы выбрать \"штуки\" введите 2");
     * System.out.println("3. Чтобы выбрать \"миллилитры\" введите 3");
     * inputChoice = userInput.next();
     * 
     * try {
     * userChoice = Integer.parseInt(inputChoice);
     * } catch (NumberFormatException e) {
     * System.out.println("Неверный ввод");
     * }
     * 
     * switch (userChoice) {
     * case 1:
     * rec1.setType("gr");
     * break;
     * case 2:
     * rec1.setType("sht");
     * break;
     * case 3:
     * rec1.setType("ml");
     * break;
     * 
     * }
     * }
     * }
     * }
     * 
     * return rec1;
     * }
     */

    /*
     * public static void createRecipe(Scanner userInput, Cookbook book) {
     * int quantity = 0;
     * System.out.print("Введи количество рецептов: ");
     * try {
     * quantity = userInput.nextInt();
     * } catch (RuntimeException e) {
     * System.out.println("Это не число. Попробуйте ещё раз.");
     * }
     * for (int i = 0; i < quantity; i++) {
     * Recipe recipeItem = makeRecipe(userInput);
     * book.addRecipe(recipeItem);
     * }
     * 
     * }
     * 
     * /**
     * main method for test purposes, comment it out when not needed
     * 
     * @param args
     * 
     * public static void main(String[] args) {
     * Scanner userInput = new Scanner(System.in);
     * // Recipe recipeUnit = testRecipe(userInput);
     * Cookbook testBook = makeTestBook();
     * // System.out.println(recipeUnit.toString());
     * getAllRecs(testBook);
     * 
     * // todo: окей, тогда это будет твой метод, вызывемый из меню
     * menuSearchRecipes(userInput, testBook);
     * 
     * }
     */

}
