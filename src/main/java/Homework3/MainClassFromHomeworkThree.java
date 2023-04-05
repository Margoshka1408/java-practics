package Homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.FileNotFoundException;
import java.util.*;


public class MainClassFromHomeworkThree {
    public static void main(String[] args) {
        generateRandomIntegerNumbersList();
        findMinMaxAverage();
        RemoveDuplicateElements();


        List<String> lst1 = List.of("a", "5", "7", "^^", "7", "3", "Hi!");
        System.out.println(lst1);
        findAndRemoveIntegers(lst1);

    }


    //1. Пусть дан произвольный список целых чисел, удалить из него четные числа (в языке уже есть что-то готовое для этого)

    private static void generateRandomIntegerNumbersList() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            list.add(random.nextInt(20));
        }
        System.out.println(list);
        list.removeIf(num -> num % 2 == 0);
        System.out.println(list);
    }


    //2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
    private static void findMinMaxAverage() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            list.add(random.nextInt(10));
        }
        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        int min = list.get(0);
        int max = list.get(0);
        int sum = 0;

        for (Integer item : list) {
            if (item > max) {
                max = item;
            }
            if (item < min) {
                min = item;
            }
            sum += item;
        }
        double average = (double) sum / list.size();
        sb.append("Минимальное значение: ").append(min).append("; ")
                .append("Максимальное значение: ").append(max).append("; ")
                .append("Среднее арифметическое: ").append(average).append(". ");
        System.out.println(sb);
    }

    //3. Доделать начатое на семинаре. Пройтись по списку из задания 2 и удалить повторяющиеся элементы.
    private static void RemoveDuplicateElements() {
        List<String> planetNames = List
                .of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptun", "Pluto");
        Random random = new Random();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(planetNames.get(random.nextInt(9)));
        }
        System.out.println(list);

        list.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        System.out.println(list);
        int count = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                count++;
            } else {
                sb.append(list.get(i))
                        .append(": ")
                        .append(count)
                        .append("; ");
                count = 1;
            }
        }
        sb.append(list.get(list.size() - 1))
                .append(": ")
                .append(count)
                .append(".");
        System.out.println(sb);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }

    //4.4*. Создать список типа ArrayList<String>.
// Поместить в него как строки, так и целые числа. Пройти по списку, найти и удалить целые числа.
    private static void findAndRemoveIntegers(List<String> list) {
        List<String> listOfIntegers = new ArrayList<>(list);
        for (int i = 0; i < listOfIntegers.size(); i++) {
            String item = listOfIntegers.get(i);
            try {
                Integer.parseInt(item);
                listOfIntegers.remove(item);
                i--;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        System.out.println(listOfIntegers);
    }
}




