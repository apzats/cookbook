package cookbook_application;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Cookbook {

  Recipe[] Recipes;

  public Cookbook() {
    Recipes = new Recipe[0];
  }

  public String getRec() {

    int i = 1;
    String outcome = "";
    for (Recipe item : this.Recipes) {
      outcome = outcome + "Рецепт #" + i + " " + item;
      i++;
    }

    // outcome = ("Рецепт: " + outcome + "\n");
    return outcome;
  }

  public Recipe[] getArrRecipe() {
    return this.Recipes;
  }

  public void addRecipe(Recipe newItem) {
    this.Recipes = Utils.<Recipe>append(this.Recipes, newItem);
  }

  public boolean hasRecipes() {
    int length = Array.getLength(Recipes);
    if (length == 0) {
      return false;
    } else {
      return true;
    }
  }

  public static Recipe[] searchRecipes(String substring) {
    Cookbook newBook = new Cookbook();
    if (book.hasRecipes() == false) {
      System.out.println("В книге пока нет рецептов");
    } else {
      //System.out.println("Введи слово для поиска: ");
      //String substring = userInput.next();
      Recipe[] arrSearch = book.getArrRecipe();
      for (Recipe item : arrSearch) {
        boolean result = item.containsString(substring);
        if (result == true) {
          newBook.Recipes = Utils.append(arrSearch, item);
          return newBook.Recipes;
        } else {
          continue;
        }
        System.out.println("Такого рецепта тю-тю!");
      }

    }

  }
}
