package com.menu;

import com.company.MyContainer;

import java.util.List;

public class SortMenuItem<T extends Comparable<T>> implements IMenuItem<T> {
    MyContainer<T> container;

    public SortMenuItem(MyContainer<T> container) {
        this.container = container;
    }

    @Override
    public int getOrder() {
        return 5;
    }

    @Override
    public String getTitle() {
        return "Sort list";
    }

    @Override
    public void execute() {
        List<T> list = container.getList();
        container.sort();
        list.stream().forEach(System.out::println);
    }
}
