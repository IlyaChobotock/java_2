package lesson_2_1;

public class Human implements Runnable, Jumpable{
    private String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public void run(int l) {
        System.out.println("Human " + name + " ran slowly ...");
    }

    @Override
    public void jump(int h) {
        System.out.println("Human " + name + " jumped low ...");
    }
}
