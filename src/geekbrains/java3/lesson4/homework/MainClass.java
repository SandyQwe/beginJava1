package geekbrains.java3.lesson4.homework;

import java.io.*;

public class MainClass {

    public static void main(String[] args) {
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("outt.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

    void writeToFile(BufferedOutputStream out) {
        Object lock = new Object();
        for (int i = 0; i < 5; i++ ) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        for (int j = 0; j < 20; j++) {
                            try {
                                out.write(j);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }).start();
        }
    }

    static class MFU {
        Object print = new Object();
        Object scan = new Object();

        void scanning(int pages) {
            new Thread(() -> {
                synchronized (scan) {
                    for (int i = 0; i < pages; i++) {
                        System.out.println("Отсканировано " + (i + 1) + "  страниц");
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        void printing(int pages) {
            new Thread(() -> {
                synchronized (print) {
                    for (int i = 0; i < pages; i++) {
                        System.out.println("Напечатано " + (i + 1) + "  страниц");
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }


}
