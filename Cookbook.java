package cookbook_application;

import java.lang.reflect.Array;

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

}
