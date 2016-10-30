package geekbrains.java3.lesson1.homework;

import java.util.ArrayList;

class Box {
    private ArrayList<Fruit> fruit;

    public Box(ArrayList<Fruit> fruit) {
        this.fruit = fruit;
    }

    public ArrayList<Fruit> getFruit() {
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

