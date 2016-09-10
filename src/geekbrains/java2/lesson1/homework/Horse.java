package geekbrains.java2.lesson1.homework;

public class Horse extends Animal implements Transport {
    @Override
    public float getMaxDriveDist() {
        return maxRunDistance * 0.8f;
    }

    @Override
    public float getMaxJumpHeight() {
        return maxJumpHeight * 0.8f;
    }

    @Override
    public float getMaxSwimDistance() {
        return maxSwimDistance * 0.8f;
    }

    public Horse(String name) {
        this.name = name;
        this.type = "Horse";
        this.maxSwimDistance = 20.0f;
        this.maxJumpHeight = 2.0f;
        this.maxRunDistance = 10000.0f;
        onDistance = true;
    }
}
