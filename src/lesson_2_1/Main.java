package lesson_2_1;

public class Main {
    public static void main(String[] args) {
//        Runnable cat = new Cat ("Pushok");
//        cat.run();
//        Runnable human = new Human("Vasya");
//        human.run();
//        Runnable robot = new Robot("WALL-E");
//        robot.run();

//        Runnable[] runnables = {
//                new Cat("Pushok"),
//                new Human("Vasya"),
//                new Robot("WALL-E")
//        };
//
//        for (Runnable rnbl : runnables) {
//            rnbl.run();
//        }

        Cat cat = new Cat ("Pushok");
        Human human = new Human("Vasya");
        Robot robot = new Robot("WALL-E");

        Wall wall = new Wall(2);
        Treadmill treadmill = new Treadmill(200);

        runP(cat);
        jumpP(cat);
        runP(human);
        jumpP(human);
        runP(robot);
        jumpP(robot);

    }

    public static void runP (Runnable rnbl) {
        rnbl.run(2);
    }

    public static void jumpP (Jumpable jmpbl) {
        jmpbl.jump(1);
    }

}
