package Homework2;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MainClassFromHomeworkTwo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        boolean resIsPalindrome = isPalindrome(str);
        System.out.println(resIsPalindrome);
        String strRepetition = stringRepetition();
        System.out.println(strRepetition);
        stringWriter(strRepetition);
        getFileExtension("C:\\Users\\Margosha\\java-practics\\src\\main\\resources\\file2");

    }

    //1. Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом
    // (возвращает boolean значение).
    private static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }

    //2. Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
    // который запишет эту строку в простой текстовый файл, обработайте исключения.
    private static String stringRepetition() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("TEST");
        }
        return sb.toString();
    }

    private static void stringWriter(String string) {
        try (PrintWriter pw = new PrintWriter("src/main/resources/file2");) {
            pw.print(string);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //3*.Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида:
    //        1 Расширение файла: txt
    //        2 Расширение файла: pdf
    //        3 Расширение файла:
    //        4 Расширение файла: jpg
    private static void getFileExtension(String pathDir){
        File folder = new File(pathDir);
        if (!folder.isDirectory()){
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (File file : folder.listFiles()){
            if (file.isFile()) {
                sb.append("Расширение файла ")
                        .append(file.getName())
                        .append(": ")
                        .append(file.getName()
                                .substring(file.getName()
                                        .lastIndexOf(".") + 1))
                        .append(System.lineSeparator());
            }
        }
        System.out.println(sb);
    }
}
