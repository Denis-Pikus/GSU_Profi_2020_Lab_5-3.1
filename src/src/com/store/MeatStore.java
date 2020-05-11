package src.com.store;

import java.util.List;

public class MeatStore extends GroceryStore {

    public MeatStore() {}

    public MeatStore(List<Product> products, int squareStore) {
        super(products, squareStore);
    }

    @Override
    public void sale() {
        System.out.println("Hello, here sell meats!");
    }

}
