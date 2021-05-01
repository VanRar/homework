package JavaBasics.homework412List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Employee> accountingOfEmployees = new ArrayList<>();
        while (true) {
            System.out.println("Введите информацию о сотруднике (фамилия, имя, возраст, пол, образование, должность, отдел) или end  длля завершения:");
            System.out.print("фамилия, имя, возраст, пол, образование, должность, отдел >>");
            String[] inputEmployee = scanner.nextLine().split(" ");
            if ("end".equals(inputEmployee[0])) break;
            //по условию в бесконечном цикле каждый параметр, по примеру в одну строку было всё записано, в строку удобнее, так что:
            accountingOfEmployees.add(new Employee(inputEmployee[0], inputEmployee[1], Integer.parseInt(inputEmployee[2]), inputEmployee[3], inputEmployee[4], inputEmployee[5], inputEmployee[6]));
        }

        System.out.println("Список сотрудников: \nфамилия имя возраст пол образование должность отдел");
        for (Employee employee : accountingOfEmployees) {
            System.out.println(employee);
        }
//        по индексам как в задании:
//        System.out.println();
//        for (int i = 0; i < accountingOfEmployees.size(); i++) {
//            System.out.println(accountingOfEmployees.get(i));
//        }

        //дополнительное задание:
        while (true) {
            System.out.println("Если не хотите менять данные, введите end");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            System.out.println("Введите через Enter фамилию и имя работника, для которого хотите изменить данные");
            String surname = scanner.nextLine();
            String name = scanner.nextLine();

            int empIndex = searchBySurname(surname, name, accountingOfEmployees);
            if (empIndex != -1) {
                //как-то тут много cntrl+c cntrl+v но пока не знаю даже как можно по параметрам класса пробежаться без ручной подачи
                //System.out.println(Arrays.toString(Employee.class.getDeclaredFields())); думал в эту сторону, но это далеко закопаюсь
                //пусть пока будет топорно

                System.out.println("меняем фамилию?");
                if ("Да".equals(scanner.nextLine())) {
                    System.out.print("Введите новое значение >>");
                    accountingOfEmployees.get(empIndex).setSurname(scanner.nextLine());
                }

                System.out.println("меняем имя?");
                if ("Да".equals(scanner.nextLine())) {
                    System.out.print("Введите новое значение >>");
                    accountingOfEmployees.get(empIndex).setName(scanner.nextLine());
                }

                System.out.println("меняем возраст?");
                if ("Да".equals(scanner.nextLine())) {
                    System.out.print("Введите новое значение >>");
                    accountingOfEmployees.get(empIndex).setAge(Integer.parseInt(scanner.nextLine()));
                }

                System.out.println("меняем пол?");
                if ("Да".equals(scanner.nextLine())) {
                    System.out.print("Может не надо, мы ж не в европе >>");
                    accountingOfEmployees.get(empIndex).setGender(scanner.nextLine());
                }

                System.out.println("меняем образование?");
                if ("Да".equals(scanner.nextLine())) {
                    System.out.print("Введите новое значениее >>");
                    accountingOfEmployees.get(empIndex).setEducation(scanner.nextLine());
                }

                System.out.println("меняем должность?");
                if ("Да".equals(scanner.nextLine())) {
                    System.out.print("Введите новое значениее >>");
                    accountingOfEmployees.get(empIndex).setPosition(scanner.nextLine());
                }

                System.out.println("меняем отдел?");
                if ("Да".equals(scanner.nextLine())) {
                    System.out.print("Введите новое значениее >>");
                    accountingOfEmployees.get(empIndex).setDepartment(scanner.nextLine());
                }
            } else {
                System.out.println("Сотрудник не найден");
            }
        }
        System.out.println();
        System.out.println("Список сотрудников: \nфамилия имя возраст пол образование должность отдел");
        for (Employee employee : accountingOfEmployees) {
            System.out.println(employee);
        }
    }

    public static int searchBySurname(String surname, String name, List<Employee> list) {
        for (int i = 0; i < list.size(); i++) {
            if (surname.equals(list.get(i).getSurname()) & name.equals(list.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }
}
