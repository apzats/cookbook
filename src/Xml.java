import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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
    
}


