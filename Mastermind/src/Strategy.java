/**
 * Interface to implement solving strategy's
 * @author Jordy Meier - Groep 1
 */
public interface Strategy {
    /**
     * Guesses the correct code
     * @return array with the colours
     */
    public Colour[] chooseMove();
}
