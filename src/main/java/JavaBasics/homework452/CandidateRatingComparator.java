package JavaBasics.homework452;

import java.util.Comparator;

public class CandidateRatingComparator implements Comparator<Candidate> {

    @Override
    public int compare(Candidate o1, Candidate o2) {
        return o2.getRating() - o1.getRating();
    }
}
