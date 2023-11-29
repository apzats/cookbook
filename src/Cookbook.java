import java.lang.reflect.Array;
import java.util.Scanner;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

//@JsonIgnoreProperties({"Recipes"})
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY )
public class Cookbook {

  @JacksonXmlElementWrapper(useWrapping = false)
  private Recipe[] Recipes;
 
  public Cookbook() {
    Recipes = new Recipe[0];
  }


  @JsonIgnore
  public String getTextRecipes() {
    int i = 1;
    String outcome = "";
    for (Recipe item : this.Recipes) {
      outcome = outcome + "Рецепт #" + i + " " + item + "\n";
      i++;
    }
    if (outcome == "") {
      System.out.println("В книге пока еще нет рецептов");
    }
    return outcome;
  }

  @JsonIgnore
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

  public Cookbook searchRecipes(String substring) {
    Recipe[] arrSearch = this.getArrRecipe();
    Cookbook newBook = new Cookbook();

    for (Recipe item : arrSearch) {
      boolean result = item.containsString(substring);
      if (result == true) {
        newBook.addRecipe(item);
      }
    }
    return newBook;
  }
}
