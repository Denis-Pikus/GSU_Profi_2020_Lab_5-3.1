package com.menu;

import com.company.ScannerWrapper;

import java.util.ArrayList;
import java.util.Collections;

public class MyMenu implements IMenuItem {
    private ArrayList<IMenuItem> items;
    private ScannerWrapper sc = new ScannerWrapper();
    private String title;
    private int order;

    public MyMenu(ArrayList<IMenuItem> items, String title, int order) {
        Collections.sort(items,
                (o1, o2) -> Integer.compare(o1.getOrder(), o2.getOrder()));
        this.items = items;
        this.title = title;
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void execute() {
        run();
    }

    public void run() {
        while (true){
            printHelp();
            int choice = sc.nextInt();
            if (choice == 0){
                return;
            }
            for (IMenuItem item: items) {
                if (item.getOrder() == choice){
                    item.execute();
                    break;
                }
            }
        }
    }

    private void printHelp(){
        for (IMenuItem item: items) {
            System.out.println(item.getOrder() + " - " + item.getTitle());
        }
        System.out.println("0 - exit");
    }
}
