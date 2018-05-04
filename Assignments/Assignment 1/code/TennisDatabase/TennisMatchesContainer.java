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
        if (sizeLogical == sizePhysical) {
            TennisMatch[] tmn = new TennisMatch[tma.length + 1];
            for (int index = 0; index < tma.length; index++) {
                tmn[index] = tma[index];
            }
            tma = tmn;
            sizePhysical++;
        }
        int index;
        for (index = 0; (index < sizeLogical) && (m.compareTo(tma[index]) < 0); index++) {
        }
        int insert = index;
        if (insert == sizeLogical) {
            tma[sizeLogical] = m;
            sizeLogical++;
        } else {
            for (int i = sizeLogical - 1; i >= insert; i--) {
                tma[i + 1] = tma[i];
            }
            tma[insert] = m;
            sizeLogical++;
        }
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