package src.com.store;

import java.util.List;

public class SweetStore extends GroceryStore {

    public SweetStore() {
    }

    public SweetStore(List<Product> products, int squareStore) {
        super(products, squareStore);
    }

    @Override
    public void sale() {
        System.out.println("Hello, here sell sweets!");
    }

}
