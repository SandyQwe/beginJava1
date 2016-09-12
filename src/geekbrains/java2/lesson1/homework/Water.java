package geekbrains.java2.lesson1.homework;

class Water extends Obstacle {
    private float distance;

    Water(float distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Sportsman s) {
        s.swim(distance);
    }
}