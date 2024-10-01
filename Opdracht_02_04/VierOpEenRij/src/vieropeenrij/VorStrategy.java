package vieropeenrij;

/**
 * this interface defines the method for the different "vs computer" stratgies.
 * Instead of using a Context object, the strategy method takes VorMatrix as
 * an input, and returns which column should be used next.
 * @author Kris Luyten
 */
public interface VorStrategy {


    /**
     * Calculates a column in which a disc should be dropped
     * @param vMatrix the datamodel based on which the calculations can be executed
     * @return the column that is selected for this move
     * @pre there is at least one column in which a new element can be dropped
     */
    public int doMove(VorMatrix vMatrix);

}
