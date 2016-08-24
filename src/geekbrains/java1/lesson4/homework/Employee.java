package geekbrains.java1.lesson4.homework;

/**
 * Created by Александр on 24.08.2016.
 */
public class Employee {
    private String name;            // ФИО
    private String appoinment;      //должность
    private String email;           //email
    private String phoneNumber;     //номер телефона
    private int payGrade;           //зарплата
    private int age;                //возраст

    public Employee() {
    }

    public Employee(String name, String appoinment, String email, String phoneNumber, int payGrade, int age) {
        this.name = name;
        this.appoinment = appoinment;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.payGrade = payGrade;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void print() {
        System.out.println("Данные сотрудника");
        System.out.println("ФИО: " + name + "\nДолжность: " + appoinment + "\nE-mail: " + email + "\nНомер телефона: " + phoneNumber + "\nОклад: " + payGrade + " рублей\nВозраст: " + age);
        System.out.println("-----------------------------------------");
    }


}
