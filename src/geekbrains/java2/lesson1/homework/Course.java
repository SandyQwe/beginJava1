package geekbrains.java2.lesson1.homework;


class Course {
    private Obstacle[] obstacles;

    Course (Obstacle[] obstacles){
        this.obstacles = obstacles;
    }


    void setObstacles(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public Obstacle[] getObstacles() {
        return obstacles;
    }

    void doIt(Team t) {
        for (Sportsman s : t.getParticipants()) {
            for (Obstacle o : obstacles) {
                o.doIt(s);
                if (!s.isOnDistance()) break;
            }
        }
    }
}
