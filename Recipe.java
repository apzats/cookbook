package cookbook_application;
import java.lang.reflect.Array;

public class Recipe {
  
    Ingridient[] Ingridients;
    
    public Recipe() {
      Ingridients = new Ingridient[0];
    }
    private String name;
    
    @Override
    public String toString() {

        String total = "";
        for (Ingridient items : this.Ingridients) {
            total = (total + " " + items);
        }
        total = ("Название иды: " + this.name + " " + total);
        return total;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean hasIngridient() {
    int length = Array.getLength(Ingridients);
    if (length == 0) {
      return false;
    } else {
      return true;
    }
  }

    public void addIngridients(Ingridient item) {
        this.Ingridients = Utils.append(this.Ingridients, item);
    }

    public boolean containsString(String text) {
        // for (String stringSearch : this.ingridients) {
        Boolean result = (toString().toLowerCase().contains(text.toLowerCase()));
        return result;
    }

    //todo: the logic is broken, you iterate over ingridients yet the message displays it being "recipes"
    // the method was corrected(i made it smaller), but i dont understand why the logic is broken: Ingredients is an array of obj Ingredient type. Some set of ingredients in an array its a recipe, as I know.  
    public String getRecipeItem() {
      String result = "";
      for (Ingridient item : this.Ingridients) {
        result = item + " " + result;
      }
      return result;
    }

}