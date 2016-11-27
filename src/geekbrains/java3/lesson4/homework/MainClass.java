package geekbrains.java3.lesson4.homework;

import java.io.*;

public class MainClass {

//      1) Создать два потока, каждый из которых выводит определенную букву(A и B) 5 раз,
//          порядок должен быть именно ABABAB. Используйте wait/notify, пробуйте решить эту задачу не подглядывая в запись.

//      3) Написать класс МФУ на котором возможны одновременная печать и сканирование документов, при этом
//          нельзя одновременно печатать два документа или сканировать(при печати в консоль выводится
//          сообщения "отпечатано 1, 2, 3,... страницы", при сканировании то же самое только
//          "отсканировано...", вывод в консоль все также с периодом в 50 мс.)

    public static void main(String[] args) {
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("outt.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

//      2) Написать совсем небольшой метод, в котором несколько потоков построчно пишут данные
//          в файл(штук по 20 записей, с периодом в 50 мс)
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
