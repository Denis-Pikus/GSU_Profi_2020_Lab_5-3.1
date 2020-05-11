package src.com.company;

import src.com.store.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewContainer extends MyContainer<GroceryStore> {

    //Метод записывает элементы контейнера в файл
    public void saveToFile(String file){
        try(FileWriter fw = new FileWriter(file)) {
            List<GroceryStore> list = super.getList();
            fw.write(Integer.toString(list.size()) + "\n");
            for (GroceryStore element: list) {
                fw.write(element.toString() + "\n");
//            for (GroceryStore element: list) {                  //перебираем список объектов
//                fw.write(element.getClass().getSimpleName() + "\n");
//                fw.write("Products:\n");
//                List<Product> products = element.getProducts(); //формируем список товаров
//                for (Product product: products) {           //записываем список товаров в файл
//                    fw.write(product.toString() + "\n");
//                }
//                fw.write("Square store:");
//                fw.write(Integer.toString(list.get(list.size() - 1).getSquareStore()));
//                fw.write("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Метод читает элементы контейнера из файла
    public List<GroceryStore> loadFromFile(String file){
        GenericFactory<GroceryStore> factory = null;
        List<GroceryStore> groceryStoreList = null;
        List<String> infoFromFileList = new ArrayList<>();

        try(FileInputStream fis = new FileInputStream(file);
            Scanner sc = new Scanner(fis))
        {
            //считываем файл построчно
            while (sc.hasNextLine()){
                infoFromFileList.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            for (int i = 1; i < infoFromFileList.size(); i++) {
                factory = new GenericFactory<GroceryStore>() {
                    @Override
                    public GroceryStore create() {
                        int index = 0;
                        GroceryStore result = null;
                        //создаем экземпляр объекта перебирая список с информацией
                        //загруженной из файла
                        String choice = infoFromFileList.get(i);
                        switch (choice) {
                            case "MeatStore":
                                result = new MeatStore();
                                index = i + 3;
                                break;
                            case "FishStore":
                                result = new FishStore();
                                index = i + 3;
                                break;
                            case "SweetStore":
                                result = new SweetStore();
                                index = i + 3;
                                break;
                            case "VegetableStore":
                                result = new VegetableStore();
                                index = i + 3;
                                break;
//                            default:
//                                throw new IllegalArgumentException("Wrong GroceryStore type:" + choice);
                        }
                        //достаем площать магазина из списока загруженного из файла
                        try {
                            String[] square = infoFromFileList.get(index - 2).split(":");
                            result.setSquareStore(Integer.parseInt(square[1]));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Enter square store:");
                        }
                        //формируем список продуктов, продоваемых в магазине
                        List<Product> products = new ArrayList<>();
                        addProduct(infoFromFileList, products, index);
                        result.setProducts(products);
                        return result;
                    }
                };
            }

        //добавляем объекты в список
        groceryStoreList.add(factory.create());
            //infoFromFileList.forEach(System.out::println);
        return groceryStoreList;
    }

    //метод, который формирует объект Product
    private void addProduct(List<String> list, List<Product> products, int index){
        while (list.get(index) != null){
            String[] productName = list.get(index).split(" ");
            String[] price = productName[1].split(":");
            products.add(new Product(productName[0], Integer.parseInt(price[1])));
            index++;
        }
    }
}
