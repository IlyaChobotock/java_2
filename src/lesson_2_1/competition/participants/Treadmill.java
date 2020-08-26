package lesson_2_1.competition.participants;

import lesson_2_1.competition.obstacles.Obstacle;

public class Treadmill implements Obstacle {
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Participant p) {
        p.run(distance);
    }
}
