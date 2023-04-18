package Homework6;

import java.util.*;
// 1.Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// 2.Создать множество ноутбуков (ArrayList).
// 3.Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
// Например, спросить у пользователя минимальный размер оперативной памяти или конкретный цвет.
// Выводить только те ноутбуки, что соответствуют условию

public class MainClassFromHomeworkSix {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("Lenovo", "IdeaPad3", 15.6, "Серый", 4, 256, "Windows10", 12345
        );
        Laptop laptop2 = new Laptop("ASUS", "VivoBookPRO15", 15.6, "Синий", 8, 512,
                "withoutOS", 22115
        );
        Laptop laptop3 = new Laptop("Acer", "Aspire3", 15.6, "Черный", 12, 512,
                "withoutOS", 35679);

        Laptop laptop4 = new Laptop("MSI", "Modern15", 15.6, "Черный", 16, 512,
                "Windows11", 865719);
        Laptop laptop5 = new Laptop("Infinix", "InBookX2", 14, "Серый", 16, 512,
                " Windows11", 135846);

        Set<Laptop> laptops = new HashSet<>(Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5));

        HashSet<Laptop> searchRes = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Задайте параметр фильтра:\n" +
                "1 - минимальный объем ОЗУ\n" +
                "2 - цвет");
        int userAnswer = sc.nextInt();

        if (userAnswer == 1) {
            System.out.println("Введите объем ОЗУ");
            int userChoice = sc.nextInt();
            sc.nextLine();
            for (Laptop lap : laptops) {
                if (lap.getRam() >= userChoice) {
                    searchRes.add(lap);
                }
            }
            System.out.println(searchRes);
        } else if (userAnswer == 2) {
            System.out.println("Введите цвет");
            String userChoice = sc.next();
            sc.nextLine();
            for (Laptop lap : laptops) {
                if (lap.getColor().equalsIgnoreCase(userChoice)) {
                    searchRes.add(lap);
                }
            }
            System.out.println(searchRes);
        } else {
            System.out.println("Наш ассортимент:" + laptops);
        }
    }
}
