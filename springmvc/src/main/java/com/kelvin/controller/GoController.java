/*
 * Copyright  2017. qooco.com All Rights Reserved. 
 * Application : qoocoAPI 
 * Class Name  : GoController.java
 * Date Created: 2017年08月10日
 * Author      : Kelvin范显
 * 
 */
package com.kelvin.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Kelvin范显
 * @createDate 2017年08月10日
 */
@Controller
public class GoController implements EnvironmentAware{
    private final Log logger = LogFactory.getLog(getClass());
    //HEAD
    @RequestMapping(value={"/"},method = {RequestMethod.HEAD})
    public String head(){
        return "go.jsp";
    }
    //GET
    @RequestMapping(value = {"/index","/"},method = {RequestMethod.GET})
    public String index(Model model) throws Exception{
        logger.info("======processed by index======");
        //return msg parameter
        model.addAttribute("msg", "Go Go Go");
        return "go.jsp";
    }

    private Environment environment;
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
