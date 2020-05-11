package src.com.menu;

public interface IMenuItem<T> {
    int getOrder();
    String getTitle();
    void execute();
}
