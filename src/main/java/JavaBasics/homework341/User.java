package JavaBasics.homework341;

public class User {
    //без модификаторов, а то тут ещё конструкторы надо будет прописывать, по хорошему всё должно быть private
    String login;
    String password;
    int age;
    String email;

    public User(String login, String password, int age) {
        this.login = login;
        this.password = password;
        this.age = age;
        this.email = login + "@" + "email.com";
    }

    @Override
    public String toString() {
        return "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
