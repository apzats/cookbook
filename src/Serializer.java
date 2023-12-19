 public interface Serializer {
   public String serialize(Cookbook book);
   public String deserialize(String text);
}

class XmlSerial implements Serializer{
    public Xml adaptee;

    public XmlSerial(){};
    public XmlSerial(Xml adaptee) {
        this.adaptee = adaptee;
    }
    
    public String serialize(Cookbook book) {
        String result = this.adaptee.serializeToXML(book);
        return result;
    }
    public String deserialize(String text){
        String result = this.adaptee.deserializeXml(text);
        return result;
    }
}

class JsonSerial implements Serializer{
    public ObjectMap adaptee;
    
    public JsonSerial(){};
    public JsonSerial(ObjectMap adaptee) {
        this.adaptee = adaptee;
    }
    public String serialize(Cookbook book) {
        String result = this.adaptee.serializeToJson(book);
        return result;
    }
    public String deserialize(String text){
        String result = this.adaptee.deserializeJson(text);
        return result;
    }
}


