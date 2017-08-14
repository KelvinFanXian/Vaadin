/*
 * Copyright  2017. qooco.com All Rights Reserved. 
 * Application : qoocoAPI 
 * Class Name  : TodoItemLayout.java
 * Date Created: 2017年08月14日
 * Author      : Kelvin范显
 * 
 */
package com.example;

import com.vaadin.data.Binder;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Kelvin范显
 * @createDate 2017年08月14日
 */
public class TodoItemLayout extends HorizontalLayout {


    private final CheckBox done;
    private final TextField text;

    public TodoItemLayout(Todo todo,TodoChangeListener changeListener) {
        done = new CheckBox();
        text = new TextField();
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);

        addComponents(done,text);
        addComponentsAndExpand(text);
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Binder<Todo> binder = new Binder<>(Todo.class);
        binder.bindInstanceFields(this);
        binder.setBean(todo);

        addComponent(done);
        addComponentsAndExpand(text);
        binder.addValueChangeListener(event -> changeListener.todoChanged(todo));
    }


}

