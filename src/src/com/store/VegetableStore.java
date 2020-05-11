package src.com.store;

import java.util.List;

public class VegetableStore extends GroceryStore {

    public VegetableStore(){}

    public VegetableStore(List<Product> products, int squareStore) {
        super(products, squareStore);
    }

    @Override
    public void sale() {
        System.out.println("Hello, here sell vegetables!");
    }
}
