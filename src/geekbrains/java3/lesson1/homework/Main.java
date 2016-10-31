package geekbrains.java3.lesson1.homework;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

class Box<T extends Fruit> {
    private ArrayList<T> fruit;

    public Box(ArrayList<T> fruit) {
        this.fruit = fruit;
    }

    //Сделать метод getWeight() который высчитывает вес коробки, зная кол-во фруктов и вес одного фрукта
    //(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
    public float getWeight() {
        float sumWeight = 0.0f;
        for (int i = 0; i < this.fruit.size(); i++) {
            sumWeight += fruit.get(i).getWeight();
        }
        return sumWeight;
    }

    public ArrayList<T> getFruit() {
        return fruit;
    }

}

public class Main {
    public static void main(String[] args) {

        //1) Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        Object[] objects = new Object[]{new Object(), new Object(), new Object(), new Object()};
        changeObjects(objects, 1, 2);


        //2) Написать метод, который преобразует массив в ArrayList;
        ArrayList<Object> array = new ArrayList<>();
        convertToArrayList(array, objects);

        //3) Большая задача:


    }

    private static void changeObjects(Object[] objects, int index1, int index2) {
        Object obj = objects[index2];
        objects[index2] = objects[index1];
        objects[index1] = obj;
    }

    private static void convertToArrayList(ArrayList<Object> array, Object[] objects) {
        for (Object o : objects) {
            array.add(o);
        }
    }
}

