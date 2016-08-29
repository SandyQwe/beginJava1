package geekbrains.java1.lesson5.homework.animals;

/**
 * Created by sadmin on 29.08.2016.
 */
abstract public class Animals {
    String name;


    void run() {
        System.out.println(name + "бежит");
    }

    void swim() {
        System.out.println(name + " плывет");
    }

    void jump() {
        System.out.println(name + "прыгает");
    }
}
