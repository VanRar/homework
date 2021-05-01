package JavaBasics.homework422;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите математическую формулу:");
        String input = scanner.nextLine();

        Stack<String> sign = new Stack<>();
        Queue<Integer> numbers = new ArrayDeque<>();

        String[] inputParse = input.split(" ");

        for (int i = 0; i < inputParse.length; i++) {
            String value = inputParse[i];
            //думал без регекса, но нарна не очень правильно в трайкетч такое оборачивать, хоть и работает)))
//            try {
//                numbers.add(Integer.parseInt(value));
//            } catch (NumberFormatException e) {
//                sign.add(value);
//            }
            //в целом норм, если без скобок вводить)
            if (Pattern.matches("\\d+", value)){
                numbers.add(Integer.parseInt(value));
            } else{
                sign.add(value);
            }
        }

        while (!numbers.isEmpty()) {
            System.out.print(numbers.poll() + " ");
        }

        while (!sign.isEmpty()) {
            System.out.print(sign.pop() + " ");
        }
    }
}
