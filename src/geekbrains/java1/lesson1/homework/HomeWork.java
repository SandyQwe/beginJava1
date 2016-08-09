package geekbrains.java1.lesson1.homework;

/**
 * Created by Александр on 10.08.2016.
 */
public class HomeWork {
    public void doIt() {
        byte varByte = 120;
        short varShort = -32000;
        int r = 200000000;
        long l = 9000000000L;
        float varFloat = 0.5f;
        double varDouble = 0.5;
        char c = 'f';
        boolean b = true;

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


