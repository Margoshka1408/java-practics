package Lesson2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class MainClassFromLessonTwo {
    public static void main(String[] args) {
        test();
        returnLengthN();
        stringCompression();
        ex5("C:\\Users\\Margosha\\java-practics");

    }

    private static void test() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 345; i++) {
            sb.append("i:").append(i).append(" ->").append((char) i);
        }
        System.out.println(sb.toString());
    }

    private static void returnLengthN() {
        int n = 7;
        String a = "a";
        String b = "B";
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                c.append(a);
            } else {
                c.append(b);
            }
        }
        System.out.println(c);
    }

    // напишите метод,кот сжимает строку
    private static void stringCompression() {
//        String str = "aaaabbbcdd";
//        StringBuilder res = new StringBuilder();
//        int count = 1;
//        for (int i = 0; i < str.length() - 1; i++) {
//            if (str.charAt(i) == str.charAt(i + 1)) {
//                count++;
//            } else {
//                if (count > 1) {
//                    res.append(str.charAt(i)).append(count);
//                } else {
//                    res.append(str.charAt(i));
//                }
//                count = 1;
//            }
//        }
//        if (count > 1) {
//            res.append(str.charAt(str.length() - 1)).append(count);
//        } else {
//            res.append(str.charAt(str.length() - 1));
//        }
//        System.out.println(res);
//    }

        String str = "aaaabbbcdd";
        StringBuilder res = new StringBuilder();
        int count = 1;
        for (
                int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                res.append(str.charAt(i));
                if (count > 1) ;
                {
                    res.append(count);
                }
                count = 0;
            }
            count++;
        }
        res.append(str.charAt(str.length() - 1)).append(count > 1 ? count : "");
        System.out.println(res);
    }

    // напишите метод,кот вернет содержимое текущей папки в виде массива строк
    // напишите метод,кот запишет массив ,возвращенный предыдущим методом в файл
    // обработайте ошибки с помощью try-catch конструкции.в случае возн-я искл-я,оно должно запис в лог-файл

    private static void ex5(String pathDir){
        File file = new File(pathDir);
        if (!file.isDirectory()){
            return;
        }
        String[] dirListNames = file.list();
        StringBuilder sb = new StringBuilder();
        for (String fileName : dirListNames){
            sb.append(fileName).append(System.lineSeparator());//lineSeparator для переноса строк
        }
        //System.out.println(sb); 1
//        PrintWriter pw = null; 2
//        try {
//            pw = new PrintWriter("src/main/resources/file2");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        pw.print(sb);
//        pw.close();

        try(PrintWriter pw = new PrintWriter("src/main/resources/file2")){
            pw.print(sb);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
