package geekbrains.java2.lesson1.homework;

public class MainClass {
    public static void main(String[] args) {

        Course c = new Course(new Obstacle[] {new Cross(100.0f), new Wall(1.5f), new Water(20.0f), new Cross(500.0f)}); // Создаем полосу препятствий

        Team t1 = new Team("Team 1", new Sportsman[]{new Human("Vassiliy Alibabaevitch"),
                                                     new Cat("Dormidont"),
                                                     new Dog("Barboskin"),
                                                     new Horse("Anyuta")});//  Создаем первую команду

        Team t2 = new Team("Team 2", new Sportsman[] {new Dog("Lord"),
                                                      new Horse("Notchka"),
                                                      new Cat("Matroskin"),
                                                      new Cat("Murka")}); // Создаем вторую команду

        c.doIt(t1); // Просим первую команду пройти полосу
        c.doIt(t2); // Просим вторую команду пройти полосу
        t1.showResults(); // Показываем результаты первой команды
        t2.showResults(); // Показываем результаты второй команды
    }
}
