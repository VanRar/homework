package JavaBasics.HashMapAndHashSet;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Integer, DriverLicense> allLicenses = new HashMap<>();

    public static void main(String[] args) {

        addLicenses();
        printAll();
        //берем по индексу
        System.out.println(allLicenses.get(3));

    }

    private static void printAll() {
        for (Map.Entry<Integer, DriverLicense> entry : allLicenses.entrySet()) {
            System.out.println("key " + entry.getKey() + " value " + entry.getValue());
        }
    }

    private static void addLicenses() {
        addLicense(new DriverLicense(1, "Vasiliy"));
        addLicense(new DriverLicense(2, "Max"));
        addLicense(new DriverLicense(3, "Alex"));
    }

    private static void addLicense(DriverLicense lisense) {
        allLicenses.put(lisense.getId(), lisense);
    }
}
