package DomainArea;

import java.lang.reflect.Array;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import Utils.MyArrays;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Recipe {
  @JacksonXmlElementWrapper(useWrapping = false)
  private Ingridient[] Ingridients;

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
    this.name = name; 
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
    this.Ingridients = MyArrays.append(this.Ingridients, item);
  }

  public boolean containsString(String text) {
    // for (String stringSearch : this.ingridients) {
    Boolean result = (toString().toLowerCase().contains(text.toLowerCase()));
    return result;
  }

}