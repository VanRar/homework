package JavaBasics.homework451;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MissedCalls missedCalls = new MissedCalls();
        Contacts contacts = new Contacts();

        methodSelection(contacts, missedCalls);

    }

    public static void methodSelection(Contacts contacts, MissedCalls missedCalls) {
        while (true) {
            System.out.println("Меню:\n" +
                    "1. Добавить контакт\n" +
                    "1.1 Редактировать контакт\n" +
                    "1.2 Удалить контакт\n" +
                    "2. Добавить пропущенный вызов\n" +
                    "3. Вывести все пропущенные вызовы\n" +
                    "4. Очистить пропущенные вызовы\n" +
                    "5. Выход\n" +
                    "Выберите пункт из меню (1-4):");
            String input = scanner.nextLine();
            if ("5".equals(input)) break;

            switch (input) {
                case "1":
                    addContact(contacts);
                    break;
                case "1.1":
                    editContact(contacts);
                    break;
                case "1.2":
                    System.out.println("Введите номер телефона контакта для удаления");
                    String number = scanner.nextLine();
                    contacts.deleteContact(number);
                    break;
                case "2":
                    addMissedCalls(missedCalls);
                    break;
                case "3":
                    System.out.println(missedCalls.toPrint(contacts));
                    break;
                case "4":
                    missedCalls.clear();
                    break;
            }
        }
    }

    public static void addContact(Contacts contacts) {
        System.out.println("Введите через пробел Имя Фамилию Номер Группу  контакта");
        String[] input = scanner.nextLine().split(" ");
        Contact contact;
        if (input.length == 4) {
            contact = new Contact(input[0], input[1], input[2], input[3]);
        } else {
            contact = new Contact(input[0], input[1], input[2], "Общая");
        }
        contacts.addContact(contact);

    }

    public static void editContact(Contacts contacts) {
        System.out.println("Введите номер контакта, который хотите отредоактировать");
        String phone = scanner.nextLine();
        System.out.println("Введите новые параметры контакта Имя Фамилию Группу");
        //формально можно сделать выбор параметра для изменения, но уже хочется доделать ДЗ и тестить это придётся ещё дольше, считаем что номер у контакта изменять нельзя, так как тогда будут сложности, если у контакта новый номер, то это новый контакт
        String[] changeContact = scanner.nextLine().split(" ");
        contacts.getContacts().get(phone).setName(changeContact[0]);
        contacts.getContacts().get(phone).setSurname(changeContact[1]);
        contacts.getContacts().get(phone).setGroup(changeContact[2]);
    }

    public static void addMissedCalls(MissedCalls missedCalls) {
        System.out.println("Добавьте номер пропущенного вызова");
        missedCalls.add(LocalDateTime.now(), scanner.nextLine());

    }
}
