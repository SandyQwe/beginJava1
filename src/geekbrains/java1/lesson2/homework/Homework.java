package geekbrains.java1.lesson2.homework;

import java.util.Random;
import java.util.StringJoiner;

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
            arr[i] = rnd.nextInt(2);
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
        System.out.println("\n--------------------------\n");

        //Создать массив из 8 целых чисел. С помощью цикла заполнить его значениями 1 4 7 10 13 16 19 22;
        int[] newArr2 = new int[8];
        newArr2[0] = 1;
        System.out.println("массив из 8 чисел:");
        System.out.print(newArr2[0] + " ");
        for (int i = 1; i < newArr2.length; i++) {
            newArr2[i] = newArr2[i-1]+3;
            System.out.print(newArr2[i] + " ");
        }
        System.out.println("\n--------------------------\n");

        //Задать массив int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        // пройти по нему циклом, и числа которые меньше 6 умножить на 2.
        int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        String oldMas = "";
        String newMas = "";
        for (int i = 0; i < mas.length; i++) {
            oldMas = oldMas + mas[i] + " ";
            if (mas[i] <6) mas[i] = mas[i] * 2;
            newMas = newMas + mas[i] + " ";
        }
        System.out.println("изначальный массив: \n" + oldMas + "\n" +
                "изменённый массив (числа которые меньше 6 умножены на 2):\n" + newMas + "\n--------------------------\n");

        //* Задать одномерный массив и найти в нем минимальный и максимальный элементы;
        int[] array = new int[rnd.nextInt(15)+5];
        array[0] = rnd.nextInt(99);
        int arrMin = array[0];
        int arrMax = array[0];
        System.out.print("Дано: массив из " + array.length +
                " целых чисел, необходимо найти минимальное и максимальное число в массиве\nМассив: ");
        String arrayS = array[0] + " ";
        for (int i = 1; i < array.length; i++) {
            array[i] = rnd.nextInt(99);
            arrayS = arrayS + array[i] + " ";
            if (arrMin > array[i]) arrMin = array[i];
            if (arrMax < array[i]) arrMax = array[i];
        }
        System.out.println(arrayS + "\nМинимальное число: " + arrMin + "\nМаксимальное число: " + arrMax);
        System.out.println("--------------------------\n");






    }
}
