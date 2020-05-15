package com.company;

import com.store.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewContainer extends MyContainer<GroceryStore> {

    //Метод записывает элементы контейнера в файл
    public void saveToFile(String file) {
        try (FileWriter fw = new FileWriter(file)) {
            List<GroceryStore> list = super.getList();
           // fw.write(Integer.toString(list.size()) + "\n");
            for (GroceryStore element : list) {
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
    public List<GroceryStore> loadFromFile(String file) {
        TextFactory textFactory = new TextFactory();
        List<GroceryStore> groceryStoreList = new ArrayList<>();
        GroceryStore store = null;
        try (FileInputStream fis = new FileInputStream(file);
             Scanner sc = new Scanner(fis)) {
            //считываем файл построчно
            while (sc.hasNextLine()) {
                String[] arr = textFactory.create(sc.nextLine());
                if (arr[0].equalsIgnoreCase("store")){
                    store = create(arr[1]);     //Создаем объект магазин
                    groceryStoreList.add(store);
                    store.setSquareStore(Integer.parseInt(arr[2]));
                }
                else {
                    if (arr[0].equals("") == false){ //пока не встретиться пустая строка заполняем список продуктов
 //в этом месте почему-то все поля объекта продукт пишутся со значением NULL???
                        store.addProduct(new Product(arr[0], Integer.parseInt(arr[1])));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        groceryStoreList.forEach(System.out::println);
        return groceryStoreList;
    }

    //Метод который формирует объекты магазинов из списка прочитанного из файла
    private GroceryStore create(String storeName) {
        //создаем экземпляр объекта перебирая список с информацией
        //загруженной из файла
        GroceryStore result = null;
        switch (storeName) {
            case "MeatStore":
                result = new MeatStore();
                break;
            case "FishStore":
                result = new FishStore();
                break;
            case "SweetStore":
                result = new SweetStore();
                break;
            case "VegetableStore":
                result = new VegetableStore();
                break;
//            default:
//                throw new IllegalArgumentException();
        }
        return result;
    }
}
