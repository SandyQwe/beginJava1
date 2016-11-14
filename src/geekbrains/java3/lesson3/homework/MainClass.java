package geekbrains.java3.lesson3.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
    public static void main(String[] args) {

//        1) Прочитать файл(около 50 байт) в байтовый массив и вывести этот массив в консоль;
        DataInputStream input = null;
        byte[] byteArray = null;
        try {
            input = new DataInputStream(new BufferedInputStream(new FileInputStream("1.txt")));
            ArrayList<Byte> tempArray = new ArrayList<>();
            try {
                while (true) tempArray.add(input.readByte());
            } catch (EOFException e) {
            }     //при достижении конца файла просто ничего не выводит
            byteArray = new byte[tempArray.size()];
            for (int i = 0; i < byteArray.length; i++) byteArray[i] = tempArray.get(i);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < byteArray.length - 1; i++) System.out.print(byteArray[i] + ", ");
        System.out.println(byteArray[byteArray.length - 1] + ".");


//        2) Последовательно сшить 10 файлов в один(файлы также ~100 байт).
//        Может пригодиться следующая конструкция:
//        ArrayList<FileInputStream> al = new ArrayList<>();
//        ...
//        Enumeration<FileInputStream> e = Collections.enumeration(al);
        FilenameFilter ff = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                Pattern p = Pattern.compile("^[0-9]*\\.txt$");
                Matcher m = p.matcher(name);
                return m.matches();
            }
        };
        File f = new File(".\\");
        File[] ff2 = f.listFiles(ff);
        ArrayList<BufferedInputStream> ff3 = new ArrayList<>();
        try {
            for (int i = 0; i < ff2.length; i++) {
                ff3.add(new BufferedInputStream(new FileInputStream(ff2[i])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Enumeration<BufferedInputStream> e = Collections.enumeration(ff3);
        SequenceInputStream input2 = new SequenceInputStream(e);
        BufferedOutputStream outputFile = null;
        try {
            outputFile = new BufferedOutputStream(new FileOutputStream(".\\output.txt"));
            int n = input2.read();
            while (n != -1) {
                outputFile.write(n);
                n = input2.read();
            }
            outputFile.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                outputFile.close();
                input2.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }


//3) Написать консольное приложение, которое умеет постранично читать текстовые файлы(размером > 10 mb),
// вводим страницу, программа выводит ее в консоль(за страницу можно принимаем 1800 символов). Время чтения файла
// должно находится в разумных пределах(программа не должна загружаться дольше 10 секунд),
// ну и чтение тоже не должно занимать >5 секунд.
    }
}
