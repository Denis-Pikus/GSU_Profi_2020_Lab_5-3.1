package src.com.menu;

import src.com.company.GenericFactory;
import src.com.company.NewContainer;
import src.com.company.ScannerWrapper;


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
        container.saveToFile(sc.nextLine());
    }
}