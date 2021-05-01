package JavaBasics.homework453;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static Scanner scanner;

    public static void main(String[] args) {
        Map<String, User> users = new TreeMap<>();
        Map<String, List<String>> idAndIp = new HashMap<>();
        Map<String, Integer> numberOfUserEntries = new HashMap<>();

        readDB(scanner, "C:\\java\\netology\\homework1.6.1\\src\\main\\java\\JavaBasics.homework453\\users.db", users, idAndIp);
        readServerLog(scanner, "C:\\java\\netology\\homework1.6.1\\src\\main\\java\\JavaBasics.homework453\\server.log", numberOfUserEntries);

        System.out.println(searchVillainId(idAndIp, numberOfUserEntries, users));
    }

    public static void readDB(Scanner scanner, String pathname, Map<String, User> users, Map<String, List<String>> idAndIp) {
        //Создаем объект файл
        File usersDB = new File(pathname);

//Создаем scanner для чтения из файла
        try {
            scanner = new Scanner(usersDB);
        } catch (FileNotFoundException e) {
            System.out.println("Не верно указан путь");
            e.printStackTrace();
        }

//Построчно читаем файл в цикле, пока файл не закончится
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(";");
            users.put(line[1], new User(line[1], line[2], line[3]));
            idAndIp.put(line[1], Collections.singletonList(line[0]));
        }

//Закрываем scanner после чтения, для освобождения файла и ресурсов
        scanner.close();
    }

    public static void readServerLog(Scanner scanner, String pathname, Map<String, Integer> numberOfUserEntries) {
        File serverLog = new File(pathname);

//Создаем scanner для чтения из файла
        try {
            scanner = new Scanner(serverLog);
        } catch (FileNotFoundException e) {
            System.out.println("Не верно указан путь");
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(":");
            if (numberOfUserEntries.containsKey(line[0])) {
                numberOfUserEntries.put(line[0], numberOfUserEntries.get(line[0]) + 1);
            } else {
                numberOfUserEntries.put(line[0], 1);
            }

        }
        scanner.close();
    }

    public static String searchVillainId(Map<String, List<String>> idAndIp, Map<String, Integer> numberOfUserEntries, Map<String, User> users) {
        int maxValue = Integer.MIN_VALUE;
        String villainIp = "";
        for (int value : numberOfUserEntries.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        for (Map.Entry<String, Integer> entry : numberOfUserEntries.entrySet()) {
            if (maxValue == entry.getValue()) {
                villainIp = entry.getKey();
            }
        }
        //находим id пользователя.
        String villainId = "";
        for (Map.Entry<String, List<String>> entry : idAndIp.entrySet()) {
            for (String ip : entry.getValue()) {
                if (ip.equals(villainIp)) {
                    villainId = entry.getKey();
                    break;
                }
            }
        }
        return users.get(villainId) + " кол-во входов " + maxValue;
    }
}
