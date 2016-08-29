package geekbrains.java1.lesson5.homework.animals;

/**
 * Created by sadmin on 29.08.2016.
 */
public class Cat extends Animals {

    public Cat(String className, String name) {
        super(className, name);
    }

    @Override
    public void swim() {
        System.out.println(className + " " + name + " не хочет плавать!");
    }

    @Override
    public void jump(float height) {
        if (height > 2)
            System.out.println(className + " " + name + " не может прыгать на высоту " + height + " метров");
        else super.jump(height);
    }

    @Override
    public void run(int distance) {
        if (distance > 100)
            System.out.println(className + " " + name + " не хочет бежать на расстояние " + distance + " метров!");
        else super.run(distance);
    }
}
