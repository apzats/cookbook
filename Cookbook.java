package cookbook_application;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Cookbook {

  Recipe[] Recipes;

  public Cookbook() {
    Recipes = new Recipe[0];
  }

  public String getRec(Recipe[] Recipes) {
    int i = 1;
    String outcome = "";
    for (Recipe item : this.Recipes) {
      outcome = outcome + "Рецепт #" + i + " " + item;
      i++;
    }
    return outcome;
  }

  public Recipe[] getArrRecipe() {
    return this.Recipes;
  }

  public void addRecipe(Recipe newItem) {
    this.Recipes = Utils.<Recipe>append(this.Recipes, newItem);;
  }

  public boolean hasRecipes() {
    int length = Array.getLength(Recipes);
    if (length == 0) {
      return false;
    } else {
      return true;
    }
  }

  public Recipe[] searchRecipes(String substring) {
    Recipe[] arrSearch = this.getArrRecipe();
    Cookbook newBook = new Cookbook();
    for (Recipe item : arrSearch) {
      boolean result = item.containsString(substring);
      if (result == true) {
        newBook.addRecipe(item);
      }
    }
    return newBook.Recipes;

  }
}
