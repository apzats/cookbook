package DomainArea;

public class Ingridient {

  private String ingridientText;
  private int quantityIngridient;
  private String quantityType;

  public Ingridient() {}

  public Ingridient(String ingridientText, int quantityIngridient, String quantityType) {
    this.ingridientText = ingridientText;
    this.quantityIngridient = quantityIngridient;
    this.quantityType = quantityType;
  }

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
    //todo: как можно упростить одной строчкой вместо 3-х?
    String total = "";
    total = (this.ingridientText + " " + this.quantityIngridient + " " + this.quantityType + "\n");
    return total;
  }

}
