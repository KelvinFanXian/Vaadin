/*
 * Copyright  2017. qooco.com All Rights Reserved. 
 * Application : qoocoAPI 
 * Class Name  : WfcBeanDefinitionParser.java
 * Date Created: 2017年08月15日
 * Author      : Kelvin范显
 * 
 */
package parseXML;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @author Kelvin范显
 * @createDate 2017年08月15日
 */
public class WfcBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder beanDefBuilder) {
        beanDefBuilder.getRawBeanDefinition()
                .setBeanClassName(element.getAttribute(WfcBeanNamespaceHandler.ATTRS.objectClass.name()));
    }
}
