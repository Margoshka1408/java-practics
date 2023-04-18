package lesson6;

import java.lang.reflect.Array;
import java.util.*;

public class MainClassFromLessonSix {
    public static void main(String[] args) {
        int n = 1000;
        Integer[] arr = fillArray(n);
        System.out.println(Arrays.toString(arr));
        double uniqueValue = uniqueValuesInArray(arr);
        System.out.println(uniqueValue);
    }

    private static Integer[] fillArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    private static double uniqueValuesInArray(Integer[] array) {
        Set<Integer> set = new HashSet<>(Arrays.asList(array));
        return 1.0 * set.size() * 100 / array.length;
    }
}
