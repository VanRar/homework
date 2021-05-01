package JavaBasics.homework452;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ResumeBase resumeBase = new ResumeBase();
        //для проверки работы, сделаем автозаполнение
        autoFill(resumeBase);

        System.out.println(resumeBase);
        //дополним ручным вводом, для проверки возможности добавления с таким же рейтингом, да и в целом требовалось по заданию
        manualFill(resumeBase);

        System.out.println(resumeBase);
    }

    public static void autoFill(ResumeBase resumeBase) {
        int i = 0;
        for (int relevance = 0; relevance < 6; relevance++) {
            for (int rating = 0; rating < 6; rating++) {
                String fullName = "\"full name " + (i) + "\"";
                i++;
                String age = "" + relevance + rating;
                resumeBase.addCandidate(new Candidate(fullName, "gender", age, relevance, rating));

            }
        }
    }

    public static void manualFill(ResumeBase resumeBase) {
        while (true) {
            System.out.println("Введите через запятую информацию о кандидате (для завершения введите пустую строку):");
            System.out.println("\tФамилия Имя Отчество, пол, возраст, релевантность резюме, оценка на собеседовании:");
            String[] input = scanner.nextLine().split(",");
            if ("".equals(input[0])) break;
            resumeBase.addCandidate(new Candidate(input[0].trim(), input[1].trim(), input[2].trim(), Integer.parseInt(input[3].trim()), Integer.parseInt(input[4].trim())));
        }

    }
}
