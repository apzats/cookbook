package cookbook_application;


import java.util.ArrayList;
import java.util.Arrays;



public class Utils {

    public static <T> T[] append(T[] origArr, T newItem){
        int n = origArr.length;
        T[] newArr = Arrays.copyOf(origArr, n + 1);
        newArr[n] = newItem;
        return newArr;
    }
  
   
  
}