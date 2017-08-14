/*
 * Copyright  2017. qooco.com All Rights Reserved. 
 * Application : qoocoAPI 
 * Class Name  : BeanWrapperTest.java
 * Date Created: 2017年08月11日
 * Author      : Kelvin范显
 * 
 */
package runner;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;
import vo.User;

/**
 * @author Kelvin范显
 * @createDate 2017年08月11日
 */
public class BeanWrapperTest {

    public static void main(String[] args) {
        User user = new User();
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(user);
        bw.setPropertyValue("username","张三");
        System.out.println(user.getUsername());
        PropertyValue value = new PropertyValue("username", "李四");
        bw.setPropertyValue(value);
        System.out.println(user.getUsername());
    }
}
