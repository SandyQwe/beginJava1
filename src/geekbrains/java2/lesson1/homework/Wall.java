package geekbrains.java2.lesson1.homework;

class Wall extends Obstacle {
    private float height;

    Wall(float height) {
        this.height = height;
    }

    @Override
    public void doIt(Sportsman s) {
        s.jump(height);
    }
}
