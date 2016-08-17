package geekbrains.java1.lesson1.homework;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/** ff
 * Created by Александр on 10.08.2016.
 */
class HomeWork {
    void doIt() {

        //объявление переменных
        byte varByte = 120;
        short varShort = -32000;
        int a = 200000000;
        long l = 9000000000L;
        float varFloat = 0.5f;
        double varDouble = 0.5;
        char c = 'f';
        boolean b = true;

        // для ввода цифр
        Scanner in = new Scanner(System.in);

        //вывод переменных
        System.out.println("Вывод объявленных переменных:");
        System.out.println("varByte = " + varByte);
        System.out.println("varShort = " + varShort);
        System.out.println("varInt = " + a);
        System.out.println("varLong = " + l);
        System.out.println("varFloat = " + varFloat);
        System.out.println("varDouble = " + varDouble);
        System.out.println("char = " + c);
        System.out.println("varBoolean = " + b);

        //Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        // где a,b,c,d – входные параметры этого метода.
        System.out.println("\nВведите четыре числа - a, b, c и d");
        float firstMethodResult;
        System.out.print("a = ");
        float a1 = in.nextFloat();
        System.out.print("b = ");
        float b1 = in.nextFloat();
        System.out.print("c = ");
        float c1 = in.nextFloat();
        System.out.print("d = ");
        float d1 = in.nextFloat();
        firstMethodResult = firstMethod(a1, b1, c1, d1);
        System.out.println("Результат операции над числами " + a1 + "*(" + b1 + "+(" + c1 + "/" + d1 + ")) составит " + firstMethodResult);

        // Написать метод, принимающий на вход два числа,
        // и проверяющий что их сумма лежит в пределах 10 до 20,
        // если да – вернуть true, в противном случае – false.
        System.out.println("\nВведите два числа (до 127), чтобы проверить, лежит ли их сумма между 10 и 20 включительно");
        System.out.print("Первое число: ");
        byte a2 = in.nextByte();
        System.out.print("Второе число: ");
        byte b2 = in.nextByte();
        boolean bool2 = isItTrue(a2, b2);
        System.out.print("\nПроверка, лежит ли сумма чисел " + a2 + " и " + b2 + " в пределах от 10 до 20 включительно: ");
        if (bool2) {
            System.out.println("ЛЕЖИТ");
        } else {
            System.out.println("НЕ ЛЕЖИТ");
        }

        // Написать метод, который определяет является ли год високосным.
        // Каждый 4й год является високосным, кроме каждого 100го, при
        // этом каждый 400й – високосный.
        int year;
        System.out.println("\nПроверка високосного года");
        do {
            System.out.print("Введите год (нашей эры): ");
            year = in.nextInt();
        } while (year <= 0);
        if (testLeapYear(year)) {
            System.out.println("Год високосный!");
        }
        else {
            System.out.println("Год не високосный!");
            System.out.printf("");
        }


    }


    private float firstMethod(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    private boolean isItTrue(byte a, byte b) {
        return a + b >= 10 && a + b <= 20;
    }

    private boolean testLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

}


