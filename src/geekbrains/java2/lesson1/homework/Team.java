package geekbrains.java2.lesson1.homework;


class Team {
    private String name;
    private Sportsman[] participants;

    Team(String name) {
        this.name = name;
    }

    void setParticipants(Sportsman[] participants) {
        this.participants = participants;
    }

    Sportsman[] getParticipants() {
        return participants;
    }

    void showResults() {
        System.out.println("====================");
        System.out.println("Results for team " + name);
        for (Sportsman o : participants) {
            o.showResults();
        }
        System.out.println("====================");
    }

    interface Sportsman {
        void run(float dist);
        void jump(float height);
        void swim(float dist);
        boolean isOnDistance();
        void showResults();
    }

    interface Transport {
        float getMaxDriveDist();
        float getMaxJumpHeight();
        float getMaxSwimDistance();
    }

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

    class Cat extends Animal {
        public Cat(String name) {
            this.name = name;
            this.type = "Cat";
            this.maxSwimDistance = 0.0f;
            this.maxJumpHeight = 3.0f;
            this.maxRunDistance = 500.0f;
            onDistance = true;
        }
    }

    class Dog extends Animal {
        public Dog(String name) {
            this.name = name;
            this.type = "Dog";
            this.maxSwimDistance = 20.0f;
            this.maxJumpHeight = 1.5f;
            this.maxRunDistance = 1500.0f;
            onDistance = true;
        }
    }

    class Horse extends Animal implements Transport {
        public Horse(String name) {
            this.name = name;
            this.type = "Horse";
            this.maxSwimDistance = 20.0f;
            this.maxJumpHeight = 2.0f;
            this.maxRunDistance = 10000.0f;
            onDistance = true;
        }

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
    }

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

    class Moto implements Transport {
        @Override
        public float getMaxDriveDist() {
            return 20000.0f;
        }

        @Override
        public float getMaxJumpHeight() {
            return 0.0f;
        }

        @Override
        public float getMaxSwimDistance() {
            return 5.0f;
        }
    }

}
