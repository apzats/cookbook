import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.*;

public class ObjectMap {
    public String json = "";

    public String serializeToJson(Cookbook book) {
        ObjectMapper objectMapper = new ObjectMapper();
        // Cookbook book = new Cookbook();

        // Recipe rec = new Recipe();
        // rec.setName("pyureshka s kotletkoi");
        //Ingridient[] ings = new Ingridient[] {
       //         new Ingridient("kartoshka", 3, "sht"), //сделать чтобы работал с книгой
       //        new Ingridient("moloko", 100, "ml"),
       // //        new Ingridient("kotletka", 2, "sht"),
       // };
       // for (Ingridient item : ings) {
      //      rec.addIngridient(item);
       // }

        // book.addRecipe(rec);
        /*
         * Ingridient ingr = new Ingridient();
         * ingr.setIngridientText("kotletka");
         * ingr.setQuantityIngridient(200);
         * ingr.setType("gr");
         */
        try {
            json = objectMapper.writeValueAsString(book);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return json;
    }


    //todo: Лучше сделать, чтобы метод возвращал распакованный объект, а не выводил сразу на экран - т.к сценарии использования этого объекта могут быть разными    
    public static String deserializeJson(String resultJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        String deserializedString = "";
        // String jsonString = "{\"Recipes\":[{\"Ingridients\":[{\"ingridientText\":\"kartoshka\",\"quantityIngridient\":3,\"quantityType\":\"sht\"},{\"ingridientText\":\"moloko\",\"quantityIngridient\":100,\"quantityType\":\"ml\"},{\"ingridientText\":\"kotletka\",\"quantityIngridient\":2,\"quantityType\":\"sht\"}],\"name\":\"pyureshka s kotletkoi\"}]}";
        try {
        Cookbook newBook = objectMapper.readValue(resultJson, Cookbook.class);
        deserializedString = "Рецепт: " + newBook.getTextRecipes();
        }catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return deserializedString;
    }


    /*public static void Writer(Ingridient ingridient) {
        Cookbook book = new Cookbook();
        try(FileWriter writer = new FileWriter("C:\\GitHubProjects\\java\\learning\\output.txt", true))
        {
            //Cookbook nextBook = serialize(ingridient);
            System.out.println(serialize(ingridient));
            String text = "";
            writer.write(text);

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }*/

    

}
