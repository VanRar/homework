package JavaBasics.homework452;


import java.util.Objects;

public class Candidate {

    private String fullName;
    private String gender;
    private String age;
    private int relevance;
    private int rating;


    public Candidate(String fullName, String gender, String age, int relevance, int rating) {
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.relevance = relevance;
        this.rating = rating;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return fullName + " " + relevance + " " + rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(fullName, candidate.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }
}
