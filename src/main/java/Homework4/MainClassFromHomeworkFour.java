package Homework4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainClassFromHomeworkFour {
    public static void main(String[] args) {
        getSavePrintRemoveString();
        LinkedList<String> lst = createList();
        System.out.println(lst);
        reverseList(lst);
        System.out.println(lst);
    }

    //1. Реализовать консольное приложение, которое:
//Принимает от пользователя и “запоминает” строки.
//Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//Если введено revert, удаляет предыдущую введенную строку из памяти.
    private static void getSavePrintRemoveString() {
        LinkedList<String> ll = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.printf("Введите текст: ");
            String text = in.nextLine();
            if (text.equalsIgnoreCase("stop")) {
                break;
            }
            if (text.equals("print")) {
                System.out.println(ll);
            } else if (text.equals("revert")) {
                ll.removeFirst();
            } else {
                ll.addFirst(text);
            }
        }
    }

//2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
private static LinkedList<String> createList() {
    LinkedList<String> list = new LinkedList<>();
    String[] array = {"home", "flat", "car", "map", "flower"};
    for (int i = 0; i < array.length; i++) {
        list.add(array[i]);
    }
    return list;
}

    private static LinkedList<String> reverseList(LinkedList<String> list) {
        for (int i = 0, middle = list.size() / 2, j = list.size() - 1; i < middle; i++, j--)
            list.set(i, list.set(j, list.get(i)));
        return list;
    }
}
