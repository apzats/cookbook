package Serialization.Serializers;

import Serialization.Abstract.Serializer;
import Serialization.Libraries.ObjectMap;
import DomainArea.Cookbook;

public class JsonSerial implements Serializer{
    public ObjectMap adaptee;
    
    public JsonSerial(){
        this.adaptee = new ObjectMap();
    };
    
    public String serialize(Cookbook book) {
        String result = this.adaptee.serializeToJson(book);
        return result;
    }
    public Cookbook deserialize(String text){
        Cookbook result = this.adaptee.deserializeJson(text);
        return result;
    }
}