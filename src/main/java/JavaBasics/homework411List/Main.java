package JavaBasics.homework411List;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> notebook = new ArrayList<>();

        while (true) {
            //странный пример  в условии, в процессе реализации написано что выход по вводу end
            System.out.println("Выберите действие:\n1. добавить задачу\n2. Вывести список задач\n3. Удалить задачу\n0. Выход");
            String input = scanner.nextLine();
            if ("0".equals(input)) break;
            switch (input) {
                case "1":
                    System.out.print("Введите задачу >>");
                    notebook.add(scanner.nextLine());
                    break;
                case "2":
                    printNotebook(notebook);

                    break;
                case "3":
                    printNotebook(notebook);
                    //не вижу смысла оборачивать в отдельно цикле, если это имеет смысл то дополню, на мой взгляд такая реализация более удобная.
                    System.out.print("Введите номер задачи, которую хотите удалить >>");
                    notebook.remove(Integer.parseInt(scanner.nextLine()) - 1);
                    System.out.println("Новый список задач:");
                    printNotebook(notebook);
                    break;
            }
        }
    }

    public static void printNotebook(ArrayList<String> notebook) {
        System.out.println("Список задач");
        for (int i = 0; i < notebook.size(); i++) {
            System.out.println((i + 1) + ". " + notebook.get(i));
        }
    }
}