package src.com.menu;

import src.com.company.NewContainer;
import src.com.company.ScannerWrapper;

public class SaveToFileMenuItem<T extends Comparable<T>> implements IMenuItem<T>  {
    private NewContainer container;
    private ScannerWrapper sc = new ScannerWrapper();

    public SaveToFileMenuItem(NewContainer container) {
        this.container = container;
    }

    @Override
    public int getOrder() {
        return 6;
    }

    @Override
    public String getTitle() {
        return "Save info to file";
    }

    @Override
    public void execute() {
        System.out.println("Enter file name");
        String file = sc.nextLine();
        container.saveToFile(file);
    }
}
