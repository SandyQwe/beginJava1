package geekbrains.java2.lesson5.homework;


public class Main {
    private static final int size = 1000000;
    private static final int h = size / 2;

    public static void main(String[] args) {
        method1();
        method2();
    }


    private static void method1() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) arr[i]++;
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        System.out.println("Первый метод " + (System.currentTimeMillis() - a));
    }

    private static void method2() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) arr[i]++;
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++)
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; i++)
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h - 1, h);
        System.out.println("Второй метод " + (System.currentTimeMillis() - a));
    }

}
