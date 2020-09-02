package lesson_2_3.ex2;

//Задача 2
//Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
//телефонных номеров. В этот телефонный справочник с помощью метода add() можно
//добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
//учесть, что под одной фамилией может быть несколько телефонов (в случае
//однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
//Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
//взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода
//результатов проверки телефонного справочника.

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> phoneB = new HashMap<>();
        phoneB.put("896224564156", "Ivanov");
        phoneB.put("895324345345", "Petrov");
        phoneB.put("891973564154", "Sidorov");
        phoneB.put("896224564956", "Mishin");
        phoneB.put("836251114143", "Petrov");
        phoneB.put("892214864151", "Lukashenko");
        phoneB.put("899224165750", "Petuhov");
        phoneB.put("846212558150", "Sinitsin");
        phoneB.put("876224544487", "Gulyaev");
        phoneB.put("836225544159", "Lukashenko");
        phoneB.put("822354564153", "Golov");
        phoneB.put("834222233656", "Mazurenko");
        phoneB.put("872224561515", "Petrosyan");
        phoneB.put("866624569001", "Malysheva");
        phoneB.put("834553641564", "Ivanov");
        phoneB.put("896224545646", "Ivanov");

//        System.out.println(phoneB);                           // печать для проверки до метода добавления нового контакта

        add(phoneB);                                            // метод добавления новго контакта

//        System.out.println(phoneB);                             // печать после метода добавления нового контакта

        get(phoneB);                                            // метод поиска по фамилии

//        System.out.println(phoneB.containsValue("Ivanov"));

    }

    private static void add(HashMap<String, String> phoneB) {
        phoneB.put("89345276534", "Markoni");                   // ввод фамилии и номера телефона
    }

    private static void get (HashMap<String, String> phoneB) {
        String surname = "Ivanov";                              // ввод фамилии для поиска номера телефона
        phoneB.forEach((k, v) -> {
            if (surname.equals(v)) {
                System.out.println(surname);
                System.out.println(("phone number " + k));
            }
        });
    }



}
