package cookbook_application;

import java.util.Scanner;
import java.lang.String;

public class Application {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        // Recipe recipeUnit = testRecipe(userInput);
         Cookbook book = new Cookbook();
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
                    System.out.println("Адьёз липидос!");    
                    System.exit(0);    
                default:
                    System.out.println("Введено неверное значение меню.\n");
            }
        }

        userInput.close();
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
