package JavaBasics.homework421;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //вообще если как реальный лифт то нарна лучше будет PriorityQueue, но по заданию вывод должен был быть в порядке ввода
        Queue<Integer> elevator = new LinkedList<>();

        while (true) {
            System.out.println("Ожидаю ввода этажа: (0 - для завершения)");
            int floor = Integer.parseInt(scanner.nextLine());
            if (floor == 0) {
                elevator.add(floor);
                break;
            }
            if (floor > 0 & floor < 26) {
                elevator.add(floor);
            } else {
                System.out.println("Такого этажа в дома нет");
            }
        }
        //рассчитаем время движения лифта
        //Скорость движения лифта между парой этажей равна 5 секунд
        //время остановки на открытие и закрытие дверей лифта 10 секунд
        //Вывести информацию, сколько времени потребовалось лифту, чтобы пройти ранее введенные этажи

        int waitDoorsInSeconds = 10;
        int waitMoveInSeconds = 5;
        int totalSeconds = 0;
        int previousFloor = -1;

        while (true) {
            Integer out = elevator.poll();
            if (out == null) break;
            System.out.print("этаж " + out + " -> ");

            if (previousFloor != -1) {
                totalSeconds += Math.abs(out - previousFloor) * waitMoveInSeconds + waitDoorsInSeconds;
            } else {
                //если это этаж, с которого начинается движение, то считаем время открытия и закрытия дверей
                totalSeconds += waitDoorsInSeconds;
            }
            previousFloor = out;
        }
        System.out.println("время движения лифта составило " + totalSeconds + " секунд");
    }
}
