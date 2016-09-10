package geekbrains.java2.lesson1.homework;

public class MainClass {
    public static void main(String[] args) {

        Course c = new Course(); // Создаем полосу препятствий
        Course.Obstacle[] o = {c.new Cross(100.0f), c.new Wall(1.5f), c.new Water(20.0f), c.new Cross(500.0f)};
        c.setObstacles(o);

        Team t1 = new Team("Team 1");//  Создаем первую команду
        Team.Sportsman[] s1 = {t1.new Human("Vassiliy Alibabaevitch"), t1.new Cat("Dormidont"), t1.new Dog("Barboskin"), t1.new Horse("Anyuta")};
        t1.setParticipants(s1);

        Team t2  = new Team ("Team 2"); // Создаем вторую команду
        Team.Sportsman[] s2 = {t2.new Dog("Lord"), t2.new Horse("Notchka"), t2.new Cat("Matroskin"), t2.new Cat("Murka")};
        t2.setParticipants(s2);

        c.doIt(t1); // Просим первую команду пройти полосу
        c.doIt(t2); // Просим вторую команду пройти полосу
        t1.showResults(); // Показываем результаты первой команды
        t2.showResults(); // Показываем результаты второй команды

    }
}
