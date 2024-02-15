package Serialization;

import Serialization.Abstract.Serializer;
import Serialization.Serializers.*;

public class SerializeFactory {

    public static Serializer chooseSerializer(String text) {
        Serializer serializer = null;
        
        switch (text) {  
            case "xml":
                serializer = new XmlSerial();
                break;
            case "json":
                serializer = new JsonSerial();
                break;
        }

        return serializer;
    }
}


        
       