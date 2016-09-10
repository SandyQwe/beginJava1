package geekbrains.java2.lesson1.homework;

public class Wall extends Obstacle {
    private float height;

    public Wall(float height) {
        this.height = height;
    }

    @Override
    public void doIt(Sportsman s) {
        s.jump(height);
    }
}
