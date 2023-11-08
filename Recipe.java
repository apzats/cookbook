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
    total = ("Название иды: " + this.name + "\nИнгридиенты:\n" + total);
    return total;
  }

  public void setName(String name) {
    this.name = name; //vfdcl
  }

  public boolean hasIngridients() {
    int length = Array.getLength(Ingridients);
    if (length == 0) {
      return false;
    } else {
      return true;
    }
  }

  public void addIngridient(Ingridient item) {
    this.Ingridients = Utils.append(this.Ingridients, item);
  }

  public boolean containsString(String text) {
    // for (String stringSearch : this.ingridients) {
    Boolean result = (toString().toLowerCase().contains(text.toLowerCase()));
    return result;
  }

}