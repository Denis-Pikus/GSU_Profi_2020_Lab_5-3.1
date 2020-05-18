package com.menu;

import com.company.NewContainer;
import com.company.ScannerWrapper;


public class LoadFromFileMenuItem<T extends Comparable<T>> implements IMenuItem<T> {
    private NewContainer container;
    ScannerWrapper sc = new ScannerWrapper();

    public LoadFromFileMenuItem(NewContainer container) {
        this.container = container;
    }

    @Override
    public int getOrder() {
        return 7;
    }

    @Override
    public String getTitle() {
        return "Load from file";
    }

    @Override
    public void execute() {
        System.out.println("Enter file name");
        container.setList(container.loadFromFile(sc.nextLine()));
    }
}