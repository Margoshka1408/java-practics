package lesson1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainClassFromLessonOne {
    public static void main(String[] args) {
        // exOne();
        // getArrMaxCount();
        int n = getRandomArrMaxCount(1000);
        System.out.println(n);
    }

    private static void exOne() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.printf("Привет, %s", name);
        scanner.close();
    }

    private static void getArrMaxCount() {
        int[] arr = new int[]{1, 1, 0, 1, 1, 1};
        int k = 0;
        int kmax = 0;
        for (int num : arr) {
            if (num == 1) {
                k++;
                if (k > kmax) {
                    kmax = k;
                }
            } else {
                k = 0;
            }
            }
        System.out.printf("Большая последовательность %s", kmax);
        }


    private static int getRandomArrMaxCount(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(2);
        }
        int count = 0;
        int maxCount = 0;
        /*        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            System.out.println(num);
        }*/
        for (int num : arr) {
            if (num ==1){
                count ++;

                if (count>maxCount) {
                    maxCount = count;
                }
            } else {
                count=0;
            }
        }
        System.out.println(Arrays.toString(arr));
        return maxCount;
        }
    }
