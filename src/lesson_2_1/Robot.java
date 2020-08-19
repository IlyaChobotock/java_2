package lesson_2_1;

public class Robot implements Runnable, Jumpable {
    private  String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public void run(int l) {
        System.out.println("Robot " + name + " couldn't run!");
    }

    @Override
    public void jump(int h) {
        System.out.println("Robot " + name + " jumped!");
    }
}
