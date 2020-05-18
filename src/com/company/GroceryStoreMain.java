package com.company;

import com.menu.*;
import com.store.GroceryStore;

import java.util.ArrayList;

public class GroceryStoreMain {
    public static void main(String[] args) {

        NewContainer container = new NewContainer();
        GenericFactory<GroceryStore> factory = new GroceryStoreFactory();
        ArrayList<IMenuItem> list = new ArrayList<>();
        list.add(new AddMenuItem<>(container, factory));
        list.add(new UpdateMenuItem<>(container, factory));
        list.add(new DeleteMenuItem<>(container));
        list.add(new PrintAllMenuItem<>(container));
        list.add(new SortMenuItem<>(container));
        list.add(new SaveToFileMenuItem<>(container));
        list.add(new LoadFromFileMenuItem<>(container));
        new MyMenu(list, "Super menu", 0).run();
    }
}
