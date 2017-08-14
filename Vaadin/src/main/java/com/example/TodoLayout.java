/*
 * Copyright  2017. qooco.com All Rights Reserved. 
 * Application : qoocoAPI 
 * Class Name  : TodoLayout.java
 * Date Created: 2017年08月14日
 * Author      : Kelvin范显
 * 
 */
package com.example;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Kelvin范显
 * @createDate 2017年08月14日
 */
@SpringComponent
public class TodoLayout extends VerticalLayout implements TodoChangeListener{

    @Autowired
    TodoRepository repo;
    
    @PostConstruct
    void init(){
        update();
    }

    private void update() {
        setTodos(repo.findAll());
    }

    private void setTodos(List<Todo> todos) {
        removeAllComponents();
        todos.forEach(todo->{
            System.out.println(todo.isDone()+ "--" +todo.getText());
            addComponent(new TodoItemLayout(todo,this));
        });
    }


    public void add(Todo todo) {
        repo.save(todo);
        update();
    }

    public void deleteComponent() {
        repo.deleteByDone(true);
        update();
    }

    @Override
    public void todoChanged(Todo todo) {
        addTodo(todo);
    }

    private void addTodo(Todo todo) {
        repo.save(todo);
        update();
    }
}
