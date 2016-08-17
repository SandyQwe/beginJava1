package geekbrains.java1.lesson2.homework;

import java.util.Random;

/**
 * dd
 * Created by sadmin on 17.08.2016.
 */
class Homework {
    void doIt() {

        // Создать массив состоящий из элементов 0 и 1, например int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        int[] arr = new int[10];
        Random rnd = new Random();
        System.out.println("массив состоящий из элементов 0 и 1");
        for (int i = 0; i < arr.length; i++) {
            if (rnd.nextBoolean()) arr[i] = 1;
            else arr[i] = 0;
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //В массиве из предыдущего пункта, с помощью цикла заменить 0 на 1, 1 на 0;
        System.out.println("инвертированный массив");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) arr[i]--;
            else arr[i]++;
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //Создать массив из 8 целых чисел. С помощью цикла заполнить его значениями 1 4 7 10 13 16 19 22;
        int[] arr2 = new int[8];
        arr2[0] = 1;
        System.out.println("массив из 8 чисел:");
        System.out.print(arr2[0] + " ");
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = arr[i-1]+3;
            System.out.print(arr[i] + " ");
        }
        System.out.println();



    }
}
