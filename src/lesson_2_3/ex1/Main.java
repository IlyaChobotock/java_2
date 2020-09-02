package lesson_2_3.ex1;

// Задача 1
// Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать, сколько раз встречается каждое слово.

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Cat");
        list.add("Dog");
        list.add("Nut");
        list.add("Cup");
        list.add("Ball");
        list.add("Girl");
        list.add("Men");
        list.add("Cup");
        list.add("Cat");
        list.add("Table");
        list.add("Cat");
        list.add("Cat");
        list.add("Dog");
        list.add("Number");
        list.add("Flower");
        list.add("Ball");
        list.add("Cup");
        list.add("Pig");
        list.add("Pig");
        list.add("Cat");

//        System.out.println(list.get(14));
//        System.out.println(list);

        HashMap<String, Integer> map = new HashMap<>();
        Integer num = 0;

        for (int i = 0; i < list.size(); i++) {
            Integer value = map.getOrDefault(list.get(i), 0);
            map.put(list.get(i), value + 1);
        }
        System.out.println(map);


    }


}
