package geekbrains.java2.lesson3.homework;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

//        1. Создать массив с набором слов (20­30 слов, должны встречаться повторяющиеся):
//        а. Посчитать сколько раз встречается каждое слово;
//        б. Найти список слов, из которых состоит текст (дубликаты не считать);
        final String s = "Александр отказывался от всех переговоров потому что он лично чувствовал себя оскорбленным Барклай " +
                "де Толли старался наилучшим образом управлять армией для того чтобы исполнить свой долг и заслужить славу великого полководца" +
                " Ростов поскакал в атаку на французов потому что он не мог удержаться от желания проскакаться по ровному полю";
        String[] s1 = s.split(" ");
        ArrayList<String> arr = new ArrayList<>(s1.length);
        Collections.addAll(arr, s1);
        ArrayList<String> arrWord = new ArrayList<>(arr.size());
        ArrayList<Integer> arrNum = new ArrayList<>(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            arrWord.add(arr.get(i));
            arrNum.add(Collections.frequency(arr, arr.get(i)));
        }
        for (int i = 0; i < arrNum.size(); i++) {
            if (arrNum.get(i) > 1) {
                if (Collections.frequency(arrWord, arrWord.get(i)) > 1) {
                    arrWord.remove(i);
                    arrNum.remove(i);
                    i--;
                }
            }
        }
        for (int i = 0; i < arrNum.size(); i++) {
            System.out.println("слово \"" + arrWord.get(i) + "\" встречается " + arrNum.get(i) + " раз(а)");

        }

//        2. Написать простой класс ТелефонныйСправочник:
//        а. В каждой записи всего три поля: Фамилия, Телефон, email;
//        б. Отдельный метод для поиска номера телефона по фамилии
//         (ввели фамилию, получили телефон), и отдельный метод для поиска email по фамилии. Следует
//          учесть, что под одной фамилией может быть несколько записей.
//         Итого в п. 2 должно быть 3 класса МэинКласс, ТелефонныйСправочник, ТелефоннаяЗапись
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+7(922)7654321", "ivanov@company.name");
        phoneBook.add("Петров", "+7(495)1234567", "petrov@company.name");
        phoneBook.add("Сидоров", "+7(499)9876543", "sidorov@company.name");
        phoneBook.add("Иванов", "+7(495)1596247", "director@company.name");
        phoneBook.add("Васильев", "+7(800)2001400", "vasiliev@company.name");

        System.out.println("Телефоны Иванова: " + phoneBook.searchPhoneNumber("Иванов"));
        System.out.println("Email Иванова: " + phoneBook.searchEmail("Иванов"));


    }
}
