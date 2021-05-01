package JavaBasics.homework452;

import java.util.Comparator;

public class CandidateRelevanceComparator implements Comparator<Candidate> {

    @Override
    public int compare(Candidate o1, Candidate o2) {
        return o2.getRelevance() - o1.getRelevance();
    }
}
