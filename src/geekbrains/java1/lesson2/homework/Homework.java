package geekbrains.java1.lesson2.homework;

import java.util.Random;

/** dd
 * Created by sadmin on 17.08.2016.
 */
class Homework {
    void doIt (){

        // Создать массив состоящий из элементов 0 и 1, например int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        int[] arr = new int[10];
        Random rnd = new Random();
        System.out.println("массив состоящий из элементов 0 и 1");
        for (int i = 0; i < arr.length; i++) {
            if (rnd.nextBoolean()) arr[i] = 1;
            else arr[i] = 0;
            System.out.print(arr[i]+" ");
        }
        System.out.println();



    }
}
