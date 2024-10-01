package vieropeenrij;

import vieropeenrij.VierOpEenRij.FILL;

/**
 *
 * @author Kris Luyten
 */
class RandomVorStrategy implements VorStrategy{

    public RandomVorStrategy() {
    }

   /**
     * Calculates a column in which a disc should be dropped
     * @param vMatrix the datamodel based on which the calculations can be executed
     * @return the column that is selected for this move
     * @pre there is at least one column in which a new element can be dropped
     */
    public int doMove(VorMatrix vMatrix) {
       int column = 0;
       do{
            column = (int)(10 * Math.random()) % VierOpEenRij.COLS;
       }while(vMatrix.getFill(column,VierOpEenRij.ROWS-1) != FILL.EMPTY);
       return column;
    }

}
