package wwae;

import java.util.Comparator;

public class RankByScoreDESC implements Comparator<Rank> {
    @Override
    public int compare(Rank r1, Rank r2) {
        int result;
        if (r2.getScore() - r1.getScore() < 0) {
            result = -1;
        } else if (r2.getScore() - r1.getScore() > 0) {
            result = 1;
        } else {
            result = 0;
        }

        return result;
    }
}