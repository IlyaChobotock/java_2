package lesson_2_1.competition.participants;

public interface Participant {
    void run (int distance);
    void jump (int height);
    boolean canDoIt ();
    void info ();
}
