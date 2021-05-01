package JavaBasics.homework432;

import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Set<Student> studentsBook = new HashSet<>();
        fillTheBook(studentsBook);
        printBook(studentsBook);
    }

    public static void fillTheBook(Set<Student> studentsBook) {
        System.out.println("Введите информацию о студенте: \"ФИО, номер группы, номер студенческого билета\"");
        while (true) {
            String[] constStudent = scanner.nextLine().split(",");
            if ("end".equals(constStudent[0].trim())) break;
            if (!studentsBook.add(new Student(constStudent[0].trim(), constStudent[1].trim(), constStudent[2].trim()))) {
                System.out.println("Студент с таким номером билета уже есть в системе");
            }
            System.out.println("Введите информацию о студенте (для завершения работы программы введите \"end\")");
        }
    }

    public static void printBook(Set<Student> book) {
        System.out.println("Фамилия Имя Отчество номер группы номер студенческого билета");
        Iterator iterator = book.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
