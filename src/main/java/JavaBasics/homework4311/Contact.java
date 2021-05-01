package JavaBasics.homework4311;

public class Contact implements Comparable {
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    //сортировка по имени
    @Override
    public int compareTo(Object o) {
        //условно считаем, что нам явно передают класс Контакт
        //по факту надо написать проверку на null и соответствие класса
        Contact contact = (Contact) o;
        return this.name.compareTo(contact.getName());
    }
}
