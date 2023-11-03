package cookbook_application;

public class Ingridient {

  private String ingridientText;
  private int quantityIngridient;
  private String quantityType; 
  
  
  public void setIngridientText(String ingridientText) {
        this.ingridientText = ingridientText;
    }
    
  public void setQuantityIngridient(int quantityIngridient) {
        this.quantityIngridient = quantityIngridient;
    }  
      
  public void setType(String quantityType) {
        this.quantityType = quantityType;
    }

  public String toString() {

      String total = "";
      total = ("Ингредиент: " + this.ingridientText + " Сколька: " + this.quantityIngridient + " " + this.quantityType + total);
      return total;
  }

    
  

}

    