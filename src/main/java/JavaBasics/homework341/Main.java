package JavaBasics.homework341;

import JavaBasics.homework341.Exceptions.AccessDeniedException;
import JavaBasics.homework341.Exceptions.UserNotFoundException;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws UserNotFoundException {

        System.out.println("Enter login");
        System.out.print("Login>>");
        String login = scanner.nextLine();

        System.out.println("Enter password");
        System.out.print("Pass>>");
        String password = scanner.nextLine();

        scanner.close();

        User user = getUserByLoginAndPassword(login, password);
        try {
            validateUser(user);
        } catch (AccessDeniedException e) {
            System.out.println(e);
        }
    }

    public static User[] getUsers(int lenght) {
        User[] users = new User[lenght];
        for (int i = 0; i < lenght; i++) {
            users[i] = new User("User " + (i + 1), "qwerty1234", 16 + i);
            System.out.println(users[i]);
        }
        return users;
    }

    //если как по заданию
    public static User[] getUsers2() {
        User user1 = new User("jhon", "jhon.com", 24);
        User user2 = new User("Smit", "Andersen", 17);
        User user3 = new User("Tomas", "pass", 18);
        User user4 = new User("Alex", "key", 115);
        return new User[]{user1, user2, user3, user4};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers(10);
        for (User user : users) {
            if (user.login.equals(login) & user.password.equals(password)) return user;
        }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.age < 18) throw new AccessDeniedException("go away children");
    }
}
