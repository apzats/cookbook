package cookbook_application;

import java.util.Scanner;
import java.lang.String;

public class Application {

    /**
     * main method for test purposes, comment it out when not needed
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        // Recipe recipeUnit = testRecipe(userInput);
        Cookbook book = new Cookbook();
        Cookbook testBook = makeTestBook(book);
        // System.out.println(recipeUnit.toString());

        System.out.println(menuSearchRecipes(userInput, book));

    }

    public static Recipe testRecipe(Scanner userInput) {
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
            rec1.addIngridients(item);
        }
        return rec1;
    }

    public static String menuSearchRecipes(Scanner userInput, Cookbook book) {
        if (book.hasRecipes() == false) {
            System.out.println("В книге пока нет рецептов");
        } else {
            System.out.println("Введи слово для поиска: ");
            String substring = userInput.next();
            Recipe[] foundRecipes = book.searchRecipes(substring);
            if (checkResult(foundRecipes) == false) {
                System.out.println("Такого рецепта тютю");
            } else {
                System.out.println(book.getRec(foundRecipes));
            }

        }

    }

    public boolean checkResult() {
        if (book.searchRecipes().length == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static Cookbook makeTestBook(Cookbook book) {

        Recipe rec = new Recipe();
        rec.setName("pyureshka s kotletkoi");

        Ingridient[] ings = new Ingridient[] {
                new Ingridient("kartoshka", 3, "sht"),
                new Ingridient("moloko", 100, "ml"),
                new Ingridient("kotletka", 2, "sht"),
        };

        int idx = 0;
        for (Ingridient item : ings) {
            rec.addIngridients(ings[idx]);
            idx++;
        }

        book.addRecipe(rec);

        return book;
    }

    /**
     * real main method, uncomment when needed
     * 
     * @param args
     */
    /*
     * public static void main(String[] args) {
     * Scanner userInput = new Scanner(System.in);
     * Cookbook book = new Cookbook();
     * 
     * int choice = 0;
     * String input = "";
     * 
     * while (!"4".equals(input)) {
     * System.out.println("1. Для добавления рецепта введите 1");
     * System.out.println("2. Для просмотра всех рецептов введите 2");
     * System.out.println("3. Для поиска рецепта введите 3");
     * System.out.println("4. Для выхода из приложения введите 4");
     * input = userInput.next();
     * 
     * try {
     * choice = Integer.parseInt(input);
     * } catch (NumberFormatException e) {
     * System.out.println("Неверный ввод");
     * }
     * 
     * switch (choice) {
     * case 1:
     * createRecipe(userInput, book);
     * break;
     * case 2:
     * getAllRecs(book);
     * break;
     * case 3:
     * menuSearchRecipes(userInput, book);
     * break;
     * default:
     * System.out.println("Введено неверное значение меню.\n");
     * }
     * }
     * 
     * userInput.close();
     * }
     */

    /*
     
    /*
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
     * 
     * public static void getAllRecs(Cookbook book) {
     * if (book.hasRecipes() == false) {
     * System.out.println("В книге пока нет рецептов");
     * } else {
     * System.out.println(book.getRec());
     * }
     * 
     * }
     * 
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
     */

}
