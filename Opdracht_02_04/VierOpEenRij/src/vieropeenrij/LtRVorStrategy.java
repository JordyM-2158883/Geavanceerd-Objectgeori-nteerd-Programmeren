package vieropeenrij;

import vieropeenrij.VierOpEenRij.FILL;

/**
 *
 * @author Kris Luyten
 */
class LtRVorStrategy implements VorStrategy {

    public LtRVorStrategy() {
    }

    public int doMove(VorMatrix vMatrix) {
        int column = 0;
        while(vMatrix.getFill(column, VierOpEenRij.ROWS-1) != FILL.EMPTY)
            column++;
        return column;
    }

}
