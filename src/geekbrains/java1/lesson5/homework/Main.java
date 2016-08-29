package geekbrains.java1.lesson5.homework;

import geekbrains.java1.lesson5.homework.animals.Animals;
import geekbrains.java1.lesson5.homework.animals.Cat;
import geekbrains.java1.lesson5.homework.animals.Dog;
import geekbrains.java1.lesson5.homework.animals.Horse;

import java.util.Scanner;

/**
 * Created by sadmin on 29.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        Animals[] animal = new Animals[3];
        animal[0] = new Cat("кот", "Барсик");
        animal[1] = new Dog("пёс", "Шарик");
        animal[2] = new Horse("конь", "Буян");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите высоту прыжка в метрах: ");
        float height = scanner.nextFloat();
        System.out.print("Введите дальность забега в метрах: ");
        int distance = scanner.nextInt();
        System.out.println("---------------------------------");

        for (int i = 0; i < animal.length; i++) {
            animal[i].swim();
            animal[i].run(distance);
            animal[i].jump(height);
            System.out.println("---------------------------------");
        }

        scanner.close();


    }
}
