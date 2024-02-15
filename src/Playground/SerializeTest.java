package Playground;

import DomainArea.*;
import Serialization.Libraries.ObjectMap;
import Serialization.Libraries.Xml;

public class SerializeTest {

    public static String testJsonSerializeBook(Cookbook book) { 
        ObjectMap objectMap = new ObjectMap();
        return objectMap.serializeToJson(book);
    }

    public static Cookbook testJsonDeserializeBook(String text) {
        ObjectMap objectMap = new ObjectMap();
        return objectMap.deserializeJson(text);

    }

    public static String testXmlSerializeBook(Cookbook book) {
        Xml xml = new Xml();
        return xml.serializeToXML(book);
    }

    public static Cookbook testXmlDeserializeBook(String text) {
        Xml xml = new Xml();
        return xml.deserializeXml(text);
    }
}
