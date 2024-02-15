package Serialization.Abstract;

import DomainArea.Cookbook;

public interface Serializer {
   public String serialize(Cookbook book);
   public Cookbook deserialize(String text);
}