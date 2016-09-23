package geekbrains.java1.lesson6.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        int n;
        final String PATH = "d:\\Java\\_Projects\\beginJava1\\";
        try {

            // 1. Создать 2 текстовых файла, примерно по 100-150 символов в каждом;
            FileOutputStream file1 = new FileOutputStream(PATH + "file1.txt");
            n = 100 + rnd.nextInt(50);
            for (int i = 0; i < n; i++) file1.write(32 + rnd.nextInt(95));
            file1.flush();
            file1.close();
            FileOutputStream file2 = new FileOutputStream(PATH + "file2.txt");
            n = 100 + rnd.nextInt(50);
            for (int i = 0; i < n; i++) file2.write(32 + rnd.nextInt(95));
            file2.flush();
            file2.close();

            //2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
            FileOutputStream file3 = new FileOutputStream(PATH + "file3.txt", true);
            FileInputStream input = new FileInputStream(PATH + "file1.txt");
            n = input.read();
            while (n != -1) {
                file3.write(n);
                n = input.read();
            }
            input.close();
            input = new FileInputStream(PATH + "file2.txt");
            n = input.read();
            while (n != -1) {
                file3.write(n);
                n = input.read();
            }
            input.close();
            file3.flush();
            file3.close();

            // 3. * Написать программу, которая составляет список файлов, в которых присутствует слово, указанное пользователем.
            // Для проверки работы программы необходимо создать ~10 текстовых файлов
            // В данном случае предполагается что файлы уже созданы, потому что если не созданы то будет exception
            String[] files = new String[10];
            for (int i = 0; i < files.length; i++) files[i] = PATH + i + ".txt";
            final String SEARCH_STRING = "search";
            for (int i = 0; i < files.length; i++) {
                boolean searchOK = false;
                input = new FileInputStream(files[i]);
                n = input.read();
                StringBuilder s = new StringBuilder();
                while (n != -1) {
                    s.append((char) n);
                    n = input.read();
                }
                char[] arr = s.toString().toCharArray();
                for (int j = 0; j <= arr.length - SEARCH_STRING.length(); j++) {
                    if (arr[j] == SEARCH_STRING.charAt(0) & !searchOK) {
                        for (int k = 1; k < SEARCH_STRING.length(); k++) {
                            if (arr[j + k] != SEARCH_STRING.charAt(k)) break;
                            if (k == SEARCH_STRING.length() - 1) searchOK = true;
                            }
                    if (searchOK) break;
                    }
                }
            if (searchOK) System.out.println(files[i]);
            input.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
