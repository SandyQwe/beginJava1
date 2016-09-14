package geekbrains.java2.lesson2.homework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        // вводим одной строчкой
        // 1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 2 0\n8
        // или можно заменить переменной типа String
        try {
            Matrix matrix = new Matrix(sc.nextLine());
            matrix.ViewMatrix();
            System.out.println("Результат обработки матрицы (сумма всех чисел разделенная на 2) равен " + matrix.MatrixOperation());
        } catch (IllegalMatrixException e) {
            System.out.println(e.toString());
        }
    }
}
