import com.fasterxml.jackson.databind.JsonSerializer;

public class SerializeFactory {
    /*public enum SerializerType {
        XML("xml"), JSON("json");

        String extension;

        SerializerType(String extension) {
            this.extension = extension;
        }
    }*/

    public Serializer chooseSerializer(String text) {
        Serializer serializer = null;
        
        switch (text) {  
            case "xml":
                serializer = new XmlSerial(new Xml());
                break;
            case "json":
                serializer = new JsonSerial(new ObjectMap());
                break;
        }

        return serializer;
    }
}


        
       