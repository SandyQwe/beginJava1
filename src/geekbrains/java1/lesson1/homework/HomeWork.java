package geekbrains.java1.lesson1.homework;

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

        //вывод переменных
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
        float firstMethodResult;
        float a1 = 10f;
        float b1 = 13f;
        float c1 = 16f;
        float d1 = 28f;
        firstMethodResult = firstMethod(a1, b1, c1, d1);
        System.out.println("Результат операции над числами " + a1 + "*(" + b1 + "+(" + c1 + "/" + d1 + ")) составит " + firstMethodResult);

    }


    private float firstMethod(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

}


