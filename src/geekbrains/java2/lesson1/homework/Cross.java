package geekbrains.java2.lesson1.homework;

public class Cross extends Obstacle {
    private float distance;

    public Cross(float distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Sportsman s) {
        s.run(distance);
    }
}
