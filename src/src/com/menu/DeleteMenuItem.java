package src.com.menu;

import src.com.company.MyContainer;
import src.com.company.ScannerWrapper;

public class DeleteMenuItem<T extends Comparable<T>> implements IMenuItem<T> {
    private MyContainer<T> container;
    ScannerWrapper sc = new ScannerWrapper();

    public DeleteMenuItem(MyContainer<T> container) {
        this.container = container;
    }

    @Override
    public int getOrder() {
        return 3;
    }

    @Override
    public String getTitle() {
        return "Delete element";
    }

    @Override
    public void execute() {
        System.out.println("Input index");
        int choice = sc.nextInt(0, container.size());
        container.delete(choice - 1);
    }
}
