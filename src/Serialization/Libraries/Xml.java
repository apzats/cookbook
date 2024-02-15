package Serialization.Libraries;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import DomainArea.Cookbook;

public class Xml {
    public String xml = "";
    
    public String serializeToXML(Cookbook book) {
        XmlMapper xmlMapper = new XmlMapper();
        
        try {
            xml = xmlMapper.writeValueAsString(book);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return xml;
        
    }

    public Cookbook deserializeXml(String resultXml) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            Cookbook newBook = xmlMapper.readValue(resultXml, Cookbook.class);
            return newBook;
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    
}