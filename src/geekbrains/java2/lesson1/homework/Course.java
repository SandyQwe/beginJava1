package geekbrains.java2.lesson1.homework;


class Course {
    private Obstacle[] obstacles;

    void setObstacles(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public Obstacle[] getObstacles() {
        return obstacles;
    }

    void doIt(Team t) {
        for (Team.Sportsman s : t.getParticipants()) {
            for (Obstacle o : obstacles) {
                o.doIt(s);
                if (!s.isOnDistance()) break;
            }
        }
    }

    abstract class Obstacle {
        public abstract void doIt(Team.Sportsman s);
    }

    class Cross extends Obstacle {
        private float distance;

        Cross(float distance) {
            this.distance = distance;
        }

        @Override
        public void doIt(Team.Sportsman s) {
            s.run(distance);
        }
    }

    class Wall extends Obstacle {
        private float height;

        Wall(float height) {
            this.height = height;
        }

        @Override
        public void doIt(Team.Sportsman s) {
            s.jump(height);
        }
    }

    class Water extends Obstacle {
        private float distance;

        Water(float distance) {
            this.distance = distance;
        }

        @Override
        public void doIt(Team.Sportsman s) {
            s.swim(distance);
        }
    }


}
