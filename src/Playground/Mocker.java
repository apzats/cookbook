package Playground;

import DomainArea.*;

/**
 * Класс отвечающий за генерацию готовых тестовых данных, чтобы не вводить
 * руками.
 */
public class Mocker {

    /**
     * Тестовый Cookbook с 3мя рецептами
     * 
     * @return Cookbook
     */
    public static Cookbook makeTestBook() {

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
    }

    /**
     * Тестовый рецепт
     * 
     * @return Recipe
     */
    public static Recipe makeTestRecipe() {
        Recipe rec = new Recipe();
        rec.setName("Blini so smetanoi");

        Ingridient[] ings = new Ingridient[] {
                new Ingridient("yaitso", 1, "sht"),
                new Ingridient("moloko", 200, "ml"),
                new Ingridient("muka", 150, "gr"),
                new Ingridient("smetana", 100, "gr"),
        };

        for (Ingridient item : ings) {
            rec.addIngridient(item);
        }

        return rec;
    }
}
