package JavaBasics.homework453;

public class User {
    private String id;
    private String fio;
    //немного не понял для чего нам надо отдельно ФИО, когда в БД просто ФИО
//    private String surname;
//    private String name;
//    private String patronymic;
    private String address;

    public User(String id, String fio, String address) {
        this.id = id;
        this.fio = fio;
        this.address = address;
    }

    @Override
    public String toString() {
        return fio + " " + address;
    }
}
