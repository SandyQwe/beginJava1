package geekbrains.java1.lesson5.homework.animals;

/**
 * Created by sadmin on 29.08.2016.
 */
abstract public class Animals {
    String name;
    String className;

    public Animals(String className, String name) {
        this.name = name;
        this.className = className;
    }

    public void run(int distance) {
        System.out.println(className + " " + name + " бежит на расстояние " + distance + " метров");
    }

    public void swim() {
        System.out.println(className + " " + name + " плывет");
    }

    public void jump(float height) {
        System.out.println(className + " " + name + " прыгает на высоту " + height + " метров");
    }
}
