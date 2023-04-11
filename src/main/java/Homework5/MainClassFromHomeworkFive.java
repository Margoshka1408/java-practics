package Homework5;

import java.util.*;
import java.util.stream.Collectors;


public class MainClassFromHomeworkFive {
    public static void main(String[] args) {
        phoneBook();

        String[] employeesList = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова",
                "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};

        List<String> listName = getNameFromList(employeesList);
        Map<String, Integer> repeatNames = findAndPrintRepeatNames(listName);
        System.out.println(repeatNames);
        sortRepeatNames(repeatNames);
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите число: ");
        int number = sc.nextInt();
        String romanNumber = fromArabicToRoman(number);
        System.out.println(romanNumber);
    }

    // 1. Реализуйте структуру телефонной книги с помощью HashMap,
// учитывая, что 1 человек может иметь несколько телефонов.
    private static String createContactName() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите имя контакта: ");
        String contact = sc.next();
        return contact;
    }

    private static List<String> addPhoneNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите количество номеров телефона: ");
        int quantityNumbers = sc.nextInt();
        List<String> listPhoneNumbers = new ArrayList<>();
        for (int i = 0; i < quantityNumbers; i++) {
            System.out.printf("Введите номер телефона: ");
            String phoneNumber = sc.next();
            try {
                Integer.parseInt(phoneNumber);
                listPhoneNumbers.add(phoneNumber);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return listPhoneNumbers;
    }

    private static void phoneBook() {
        Map<String, List> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.printf("Введите команду: ");
            String command = sc.next();
            if ((command.equalsIgnoreCase("+"))) {
                String key = createContactName();
                List<String> value = addPhoneNumbers();
                if (map.containsKey(key)) {
                    map.get(key).add(value);
                    System.out.println(map);
                } else {
                    map.put(key, value);
                    System.out.println(map);
                }
            } else {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
    // 2. Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов
//
// Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

    private static List<String> getNameFromList(String[] list) {
        List<String> nameList = new ArrayList<>();
        for (String data: list) {
            String[] nameFromList = data.split(" ");
            nameList.add(nameFromList[0]);
        }
        return nameList;
    }

    private static Map<String, Integer> findAndPrintRepeatNames(List<String> list) {
        Map<String, Integer> mapNames = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    count++;
                }
            }
            if (mapNames.containsKey(list.get(i)) == false) {
                mapNames.put(list.get(i), count);
            }
        }
        return mapNames;
    }

    private static void sortRepeatNames(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> sortList = new ArrayList<>(map.entrySet());
        sortList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.println(sortList);
    }

// 3***. Написать метод, который переведёт данное целое число в римский формат.

    private static String fromArabicToRoman(int num) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        int n = map.floorKey(num);
        if (num == n) {
            return map.get(num);
        }
        return map.get(n) + fromArabicToRoman(num - n);
    }
}
