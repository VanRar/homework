package JavaBasics.homework451;

public class Contact {
    private String name;
    private String surname;
    private String phone;
    private Enum group;

    public Contact() {
    }

    public Contact(String name, String surname, String phone, String group) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.group = Group.getName(group);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setGroup(String group) {

        this.group = Group.getName(group);
    }

    @Override
    public String toString() {
        return group.name() + " " + name + " " + surname + " " + phone;

    }
}
