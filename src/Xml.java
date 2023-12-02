import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.io.FilenameUtils;

public class Xml {
    public String xml = "";
    
    public String serializeToXML(Cookbook book) {
        XmlMapper xmlMapper = new XmlMapper();
        /*Cookbook book = new Cookbook();
        String xml = "";
        Recipe rec = new Recipe();
        rec.setName("pyureshka s kotletkoi");
        Ingridient[] ings = new Ingridient[] {
                new Ingridient("kartoshka", 3, "sht"), 
                new Ingridient("moloko", 100, "ml"),
                new Ingridient("kotletka", 2, "sht"),
        };
        for (Ingridient item : ings) {
            rec.addIngridient(item);
        }

         book.addRecipe(rec);*/
        /*
         * Ingridient ingr = new Ingridient();
         * ingr.setIngridientText("kotletka");
         * ingr.setQuantityIngridient(200);
         * ingr.setType("gr");
         */
        try {
            xml = xmlMapper.writeValueAsString(book);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return xml;
        
    }

    public static void deserializeXml(String resultXml) {
        XmlMapper xmlMapper = new XmlMapper();
        Cookbook book = new Cookbook();
        // String xmlString = "<Cookbook><Recipes><Ingridients><ingridientText>kartoshka</ingridientText><quantityIngridient>3</quantityIngridient><quantityType>sht</quantityType></Ingridients><Ingridients><ingridientText>moloko</ingridientText><quantityIngridient>100</quantityIngridient><quantityType>ml</quantityType></Ingridients><Ingridients><ingridientText>kotletka</ingridientText><quantityIngridient>2</quantityIngridient><quantityType>sht</quantityType></Ingridients><name>pyureshka s kotletkoi</name></Recipes><Recipes><Ingridients><ingridientText>kartoshka</ingridientText><quantityIngridient>3</quantityIngridient><quantityType>sht</quantityType></Ingridients><Ingridients><ingridientText>myasko</ingridientText><quantityIngridient>100</quantityIngridient><quantityType>gr</quantityType></Ingridients><Ingridients><ingridientText>svekla</ingridientText><quantityIngridient>2</quantityIngridient><quantityType>sht</quantityType></Ingridients><name>borschik</name></Recipes><Recipes><Ingridients><ingridientText>uryuk</ingridientText><quantityIngridient>3</quantityIngridient><quantityType>gr</quantityType></Ingridients><Ingridients><ingridientText>izyum</ingridientText><quantityIngridient>100</quantityIngridient><quantityType>gr</quantityType></Ingridients><Ingridients><ingridientText>chernoscliva</ingridientText><quantityIngridient>2</quantityIngridient><quantityType>gr</quantityType></Ingridients><name>kompotik</name></Recipes></Cookbook>";
        try {
        Cookbook newBook = xmlMapper.readValue(resultXml, Cookbook.class);
        System.out.println("Рецепт: " + newBook.getTextRecipes());
        }catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

    }

    public String getExtensionByApacheCommonLib(String filename) {
        return FilenameUtils.getExtension(filename);
    }
    
}


