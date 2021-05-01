package JavaBasics.homework431;

import java.util.*;

public class PhoneContacts {
    private Map<String, Contact> contacts;

    public PhoneContacts() {
        this.contacts = new HashMap<>();
    }

    //создаем группу с безразмерным массивом для хранения данных
    public void addGroup(String groupName) {
        if (!contacts.containsKey(groupName)) {
            contacts.put(groupName, new Contact());

        }
    }

    public void addContact(String group, Contact contact) {

        contacts.put(group, contact);
    }

    //для вывода переопределяем toString, проще через StringBuilder
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        //       stringBuilder.append("Контакты:\n");
//        for (String key: contacts.keySet()) {
//            stringBuilder.append(key).append("\n");
//            for (Contact contact : contacts.values()) {
//                stringBuilder
//                        .append("\t")
//                        .append(contact.getName())
//                        .append(" ")
//                        .append(contact.getNumber())
//                        .append("\n");
//            }
//        }

        for (Map.Entry<String, Contact> group : contacts.entrySet()) {
            stringBuilder.append(group.getKey()).append("\n");

            Iterator<Map.Entry<String, Contact>> entries = contacts.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, Contact> entry = entries.next();
                stringBuilder
                        .append("\t")
                        .append(entry.getValue().getName())
                        .append(" ")
                        .append(entry.getValue().getNumber())
                        .append("\n");
            }
        }

        return stringBuilder.toString();
    }

}