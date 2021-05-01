package JavaBasics.homework452;

import java.util.Comparator;

public class CandidateFullNameComparator implements Comparator<Candidate> {
    @Override
    public int compare(Candidate o1, Candidate o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
}
