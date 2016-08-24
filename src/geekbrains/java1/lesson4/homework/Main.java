package geekbrains.java1.lesson4.homework;

/**
 * Created by Александр on 24.08.2016.
 */
public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Иванов Иван Иванович", "директор", "ivanoff@company.ru", "+7(495)123-45-67", 100000, 45);
        employees[1] = new Employee("Петров Петр Петрович", "главный инженер", "petroff@company.ru", "+7(495)123-45-68", 80000, 38);
        employees[2] = new Employee("Сидоров Сидор Сидорович", "дворник", "sidoroff@company.ru", "+7(495)123-45-69", 20000, 58);
        employees[3] = new Employee("Васильев Василий Васильевич", "проектировщик", "sidoroff@company.ru", "+7(495)123-45-70", 500000, 41);
        employees[4] = new Employee("Сергеев Сергей Сергеевич", "космонавт", "sergeyeff@company.ru", "+7(495)123-45-71", 150000, 35);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) employees[i].print();
        }


    }
}
