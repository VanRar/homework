package JavaBasics.homework451;

public enum Group {
    WORK("Работа"), FRIENDS("Друзья"), FAMILY("Семья"), GENERAL("Общая");

    String name;

    Group(String name) {

        this.name = name;
    }

    public static Group getName(String name) {
        Group[] allGroup = Group.values();
        for (Group group : allGroup) {
            if (group.name.equals(name)) return group;
        }
        return GENERAL;
    }

    @Override
    public String toString() {
        return name;
    }
}
