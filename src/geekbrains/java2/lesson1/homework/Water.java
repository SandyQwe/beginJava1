package geekbrains.java2.lesson1.homework;

public class Water extends Obstacle {
    private float distance;

    public Water(float distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Sportsman s) {
        s.swim(distance);
    }
}
