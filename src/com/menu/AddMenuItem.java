package com.menu;

import com.company.GenericFactory;
import com.company.MyContainer;

public class AddMenuItem<T extends Comparable<T>> implements IMenuItem<T> {
    private MyContainer<T> container;
    private GenericFactory<T> factory;

    public AddMenuItem(MyContainer<T> container, GenericFactory<T> factory) {
        this.container = container;
        this.factory = factory;
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public String getTitle() {
        return "Add element";
    }

    @Override
    public void execute() {
        container.add(factory.create());
    }
}
