package lesson_2_1;

public class Cat implements Runnable, Jumpable {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void run(int l) {
        System.out.println("Cat " + name + " ran successfully!");
    }

    @Override
    public void jump(int h) {
        System.out.println("Cat " + name + " jumped high!");
    }
}
