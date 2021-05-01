package JavaBasics.homework452;

import java.util.Comparator;
import java.util.TreeSet;

public class ResumeBase {
    private TreeSet resumeBase;
    private Comparator<Candidate> candidateComparator = new CandidateRelevanceComparator().thenComparing(new CandidateRatingComparator()).thenComparing(new CandidateFullNameComparator());

    public ResumeBase() {
        this.resumeBase = new TreeSet(candidateComparator);
    }

    public void addCandidate(Candidate candidate) {

        resumeBase.add(candidate);

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Список кандидатов:")
                .append("ФИО, Релевантность резюме, Оценка на собеседовании");
        for (Object candidate : resumeBase) {
            Candidate candidate1 = (Candidate) candidate;
            stringBuilder
                    .append(candidate1.getFullName())
                    .append(" ")
                    .append(candidate1.getRelevance())
                    .append(" ")
                    .append(candidate1.getRating())
                    .append("\n");

        }
        return stringBuilder.toString();
    }
}
