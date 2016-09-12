package geekbrains.java2.lesson1.homework;

class Human implements Sportsman {
    private String name;

    private float maxRunDistance;
    private float maxJumpHeight;
    private float maxSwimDistance;

    private boolean isActive;
    private Transport tr;

    Human(String name) {
        this.name = name;
        this.maxSwimDistance = 500.0f;
        this.maxJumpHeight = 2.0f;
        this.maxRunDistance = 5000.0f;
        isActive = true;
    }

    public void getOn(Transport transport) {
        this.tr = transport;
    }

    public void getOff() {
        this.tr = null;
    }

    @Override
    public boolean isOnDistance() {
        return isActive;
    }

    @Override
    public void run(float dist) {
        float m = maxRunDistance;
        if (tr != null) m = tr.getMaxDriveDist();
        if (dist <= m) {
            System.out.println(name + " - run ok");
        } else {
            System.out.println(name + " - run failed");
            isActive = false;
        }
    }

    @Override
    public void jump(float height) {
        float h = maxJumpHeight;
        if (tr != null) h = tr.getMaxJumpHeight();
        if (height <= h) {
            System.out.println(name + " - jump ok");
        } else {
            System.out.println(name + " - jump failed");
            isActive = false;
        }
    }

    @Override
    public void swim(float dist) {
        float m = maxSwimDistance;
        if (tr != null) m = tr.getMaxSwimDistance();
        if (m == 0.0f) {
            System.out.println(name + " can't swim");
            isActive = false;
            return;
        }
        if (dist <= m) {
            System.out.println(name + " - swim ok");
        } else {
            System.out.println(name + " - swim failed");
            isActive = false;
        }
    }

    @Override
    public void showResults() {
        if (isActive)
            System.out.println(name + " - ok");
        else
            System.out.println(name + " - failed");
    }
}
