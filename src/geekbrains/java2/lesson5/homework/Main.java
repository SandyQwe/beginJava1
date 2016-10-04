package geekbrains.java2.lesson5.homework;


public class Main {
    static final int size = 1000000;
    static final int h = size / 2;


    public static void main(String[] args) {
        method1();
        method2();


    }


    public static void method1() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) arr[i]++;
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Первый метод " + (System.currentTimeMillis() - a));

    }

    public static void method2() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) arr[i]++;
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++)
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).run();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; i++)
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).run();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h - 1, h);
        System.out.println("Второй метод " + (System.currentTimeMillis() - a));

    }

}
