package geekbrains.java1.lesson1.homework;

import java.util.Scanner;

/**
 * Created by Александр on 10.08.2016.
 */
public class HomeWork {
    public void doIt() {

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
        System.out.println("Введите четыре числа - a, b, c и d");
        float firstMethodResult;
        System.out.print("a = ");
        float a1 = in.nextFloat();
        System.out.print("\nb = ");
        float b1 = in.nextFloat();
        System.out.print("\nc = ");
        float c1 = in.nextFloat();
        System.out.print("\nd = ");
        float d1 = in.nextFloat();
        firstMethodResult = firstMethod(a1, b1, c1, d1);
        System.out.println("\n\nРезультат операции над числами " + a1 + "*(" + b1 + "+(" + c1 + "/" + d1 + ")) составит " + firstMethodResult);

        // Написать метод, принимающий на вход два числа,
        // и проверяющий что их сумма лежит в пределах 10 до 20,
        // если да – вернуть true, в противном случае – false.

        byte a2 = 8;
        byte b2 = 10;
        boolean bool2 = isItTrue(a2, b2);
        System.out.print("\n\nПроверка, лежит ли сумма чисел "+a2 +" и "+b2+" в пределах от 10 до 20 включительно: ");
        if (bool2) {
            System.out.println("ЛЕЖИТ");
        }
        else {
            System.out.println("НЕ ЛЕЖИТ");
        }

    }


    private float firstMethod(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    private boolean isItTrue(byte a, byte b) {
        return ((a + b) >= 10 && (a + b) <= 20);
    }

}


