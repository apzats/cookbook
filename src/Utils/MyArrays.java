package Utils;

import java.util.Arrays;

public class MyArrays {

    public static <T> T[] append(T[] origArr, T newItem){
        int n = origArr.length;
        T[] newArr = Arrays.copyOf(origArr, n + 1);
        newArr[n] = newItem;
        return newArr;
    }
}