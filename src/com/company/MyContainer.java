package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyContainer<T extends Comparable<T>> {
    private List<T> list = new ArrayList<>();
    ScannerWrapper sc = new ScannerWrapper();

    //Метод добавляет элемент в контейнер
    public void add(T element){
        list.add(element);
    }

    //Метод обновляет элемент в контейнере
    public void update(int index, T element){
        if (list.size() == 0){
            System.out.println("List is empty!");
            return;
        }
        list.set(index, element);
    }

    //Метод удаляет элемент из контейнера
    public void delete(int element){
        if (list.size() == 0){
            System.out.println("List is empty!");
            return;
        }
        list.remove(element);
    }

    //Метод возвращает список элементов контейнера
    public List<T> getList() {return list;}
    public void setList(List<T> list) {this.list = list;}

    //Метод возвращает размер контейнера
    public int size() {return list.size();}

    //Метод выводит на экран элементы контейнера
    public void printAll() {
        list.stream().forEach(System.out::println);
    }

    //Метод сортирует элементы контейнера
    public void sort(){
        Collections.sort(list);
    }


}
