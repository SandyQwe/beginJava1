package geekbrains.java2.lesson1.homework;


class Team {
    private String name;
    private Sportsman[] participants;

    Team(String name, Sportsman[] s) {
        this.name = name;
        this.participants = s;
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
}
