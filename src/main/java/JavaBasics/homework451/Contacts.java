package JavaBasics.homework451;

import java.util.HashMap;
import java.util.Map;

public class Contacts {

    private Map<String, Contact> contacts = new HashMap<>();

    public Contacts() {

    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getPhone(), contact);
    }

    public void deleteContact(String phone) {
        contacts.remove(phone);
    }

    public String searchContact(String phone) {
        if (contacts.get(phone) == null) {
            return phone;
        }
        return contacts.get(phone).getName() + " " + contacts.get(phone).getSurname();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Контакты:\n");
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            stringBuilder.append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }
}
