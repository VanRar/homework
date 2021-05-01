package JavaBasics.homework342;

import JavaBasics.homework342.Event.Event;
import JavaBasics.homework342.Event.Movie;
import JavaBasics.homework342.Event.Theatre;

public class Main {
    public static void main(String[] args) {
        for (Event event : getMovies(10)) {
            validEvent(event);
        }

        for (Event event : getTheatres(10)) {
            validEvent(event);
        }

        System.out.println("Все события корректны");

        Theatre theatre = new Theatre();
        System.out.println("now error");
        validEvent(theatre);

        System.out.println("А это было не корреткное, но до этой строки мы уже не дойдём");

    }

    public static Movie[] getMovies(int count) {
        Movie[] movies = new Movie[count];
        for (int i = 0; i < count; i++) {
            movies[i] = new Movie("Movie " + (i + 1), 2010 + i, 16 + i);
        }
        return movies;
    }

    public static Theatre[] getTheatres(int count) {
        Theatre[] theatres = new Theatre[count];
        for (int i = 0; i < count; i++) {
            theatres[i] = new Theatre("Theatre " + (i + 1), 2010 + i, 16 + i);
        }
        return theatres;
    }

    public static void validEvent(Event event) {
        if (event.getTitle().isEmpty() | event.getAge() == -1 | event.getReleaseYear() == 0)
            throw new RuntimeException();
    }
}