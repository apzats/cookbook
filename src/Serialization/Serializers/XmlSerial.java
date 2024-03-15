package Serialization.Serializers;

import Serialization.Abstract.Serializer;
import Serialization.Libraries.Xml;

import DomainArea.Cookbook;

public class XmlSerial implements Serializer{
    public Xml adaptee;

    public XmlSerial(){
        this.adaptee = new Xml();
    };
    
    public String serialize(Cookbook book) {
        String result = this.adaptee.serializeToXML(book);
        return result;
    }
    
    public Cookbook deserialize(String text){
        Cookbook result = this.adaptee.deserializeXml(text);
        return result;
    }
}