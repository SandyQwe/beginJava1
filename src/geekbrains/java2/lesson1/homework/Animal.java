package geekbrains.java2.lesson1.homework;

abstract class Animal implements Sportsman {
    protected String name;
    protected String type;

    protected float maxRunDistance;
    protected float maxJumpHeight;
    protected float maxSwimDistance;

    protected boolean onDistance;

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void run(float dist) {
        if (dist <= maxRunDistance) {
            System.out.println(type + " " + name + " - run ok");
        } else {
            System.out.println(type + " " + name + " - run failed");
            onDistance = false;
        }
    }

    @Override
    public void jump(float height) {
        if (height <= maxJumpHeight) {
            System.out.println(type + " " + name + " - jump ok");
        } else {
            System.out.println(type + " " + name + " - jump failed");
            onDistance = false;
        }
    }

    @Override
    public void swim(float dist) {
        if (maxSwimDistance == 0.0f) {
            System.out.println(type + " " + name + " can't swim");
            onDistance = false;
            return;
        }
        if (dist <= maxSwimDistance) {
            System.out.println(type + " " + name + " - swim ok");
        } else {
            System.out.println(type + " " + name + " - swim failed");
            onDistance = false;
        }
    }

    @Override
    public void showResults() {
        if (onDistance)
            System.out.println(type + " " + name + " - ok");
        else
            System.out.println(type + " " + name + " - failed");
    }

}