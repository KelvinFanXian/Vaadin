package com.kelvin.util;

/**
 * @author Kelvin范显
 * @createDate 2017年08月23日
 */
public class TestUtils {

    public void print(Object object){
        System.out.println();
        line(object);
        System.out.println(object);
        line(object);
        System.out.println();
    }

    public void line(Object object){
        int len = object.toString().length()+10;
        while (len>0){
            System.out.print("-");
            len--;
        }
        System.out.println();
    }
}
