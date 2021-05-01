package JavaBasics.Generics;

public class Main {
    public static void main(String[] args) {
        Cell<String> stringCell = new Cell<>();
        stringCell.setT("Hello");
        //раньше надо было приводить к типу, по факту теперь ява это делает сама
        String s = (String)stringCell.getT();

    }
}
