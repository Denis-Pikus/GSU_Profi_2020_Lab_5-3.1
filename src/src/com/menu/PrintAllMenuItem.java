package src.com.menu;


import src.com.company.NewContainer;
import src.com.store.GroceryStore;

import java.util.List;

public class PrintAllMenuItem<T extends Comparable<T>> implements IMenuItem<T> {
    private NewContainer container;

    public PrintAllMenuItem(NewContainer container) {
        this.container = container;
    }

    @Override
    public int getOrder() {
        return 4;
    }

    @Override
    public String getTitle() {
        return "Print all";
    }

    @Override
    public void execute() {
       List<GroceryStore> list = container.getList();
        list.stream().forEach(System.out::println);
    }
}
