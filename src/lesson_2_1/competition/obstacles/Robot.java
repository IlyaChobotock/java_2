package lesson_2_1.competition.obstacles;

import lesson_2_1.competition.participants.Participant;

public class Robot implements Participant {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;
    private boolean doIt;

    public Robot(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.doIt = true;
    }

    public Robot(String name) {this(name, 5000, 5);};

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance){
            System.out.printf("%s без устали пробежал %d метров!\n", name, distance);
        } else {
            System.out.printf("%s не смог пробежать %d метров, нужна промежуточная зарядка ...\n", name, distance);
            doIt = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.printf("%s мощно прыгнул на %d метров!\n", name, height);
        } else {
            System.out.printf("%s не смог прыгнуть на %d метров, мощности приводов не достаточно для данного препятствия\n", name, height);
            doIt = false;
        }
    }

    @Override
    public boolean canDoIt() {
        return doIt;
    }

    @Override
    public void info() {
        System.out.printf("%s %b\n", name, doIt);
    }
}
