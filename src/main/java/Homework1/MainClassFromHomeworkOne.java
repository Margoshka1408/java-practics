package Homework1;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class MainClassFromHomeworkOne {
    public static void main(String[] args) {
        getArrMaxMin();

        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int[] resArr = moveElementsToEnd(nums, val);
        System.out.println(Arrays.toString(resArr));

        inputNameAndPrintGreeting();
    }

    // 1: Задать одномерный массив и найти в нем минимальный и максимальный элементы.
    public static void getArrMaxMin() {
        int arr[] = new int[]{83, 29, 77, 10, 47, 90, 15};
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > min)
                min = arr[i];
            else if (arr[i] < max)
                max = arr[i];
        }
        System.out.println("Максимум: " + min);
        System.out.println("Минимум: " + max);
    }

    // 2: Дан массив nums = [3,2,2,3] и число val = 3.
    // Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
    // Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.

    private static int[] moveElementsToEnd(int[] arr, int value) {
        int leftVal = 0;
        int rightVal = arr.length - 1;
        int item;
        while (leftVal < rightVal) {
            if (arr[rightVal] == value) {
                rightVal--;
            }
            if (arr[leftVal] == value) {
                item = arr[leftVal];
                arr[leftVal] = arr[rightVal];
                arr[rightVal] = item;
            }
            leftVal++;
        }
        return arr;
    }

    // 3 *. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
    //"Доброе утро, <Имя>!", если время от 05:00 до 11:59
    //"Добрый день, <Имя>!", если время от 12:00 до 17:59;
    //"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
    //"Доброй ночи, <Имя>!", если время от 23:00 до 4:59

    private static void inputNameAndPrintGreeting() {
        Scanner in = new Scanner(System.in);
        System.out.printf("Введите имя: ");
        String name = in.nextLine();
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        if (hour >= 5 && hour < 12) {
            System.out.printf("Доброе утро, %s", name + "!");
        }
        if (hour >= 12 && hour < 18) {
            System.out.printf("Добрый день, %s", name + "!");
        }
        if (hour >= 18 && hour < 23) {
            System.out.printf("Добрый вечер, %s", name + "!");
        }
        if (hour == 23 || hour < 5) {
            System.out.printf("Доброй ночи, %s", name + "!");
        }
    }
}








