package TennisDatabase;

import TennisDatabase.TennisDatabaseRuntimeException;

public class TennisMatchesContainer implements TennisMatchesContainerInterface {

    private TennisMatch[] tma;
    private int sizeLogical;
    private int sizePhysical;

    public TennisMatchesContainer() {
        sizePhysical = 2;
        sizeLogical = 0;
        tma = new TennisMatch[sizePhysical];
    }

    public void insertMatch(TennisMatch m) {
        
    }

    public void printAllMatches() throws TennisDatabaseRuntimeException {
        if (tma.length == 0) {
            throw new TennisDatabaseRuntimeException("No Tennis Matches Available");
        } else {
            for (int i = 0; i < sizeLogical; i++) {
                tma[i].print();
            }
        }
    }
}