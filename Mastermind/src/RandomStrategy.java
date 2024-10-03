/**
 * Strategy to randomly guess the correct colours
 * @author Jordy Meier - Groep 1
 */
public class RandomStrategy implements Strategy {

    /**
     * Creates instance of RandomStrategy.
     */
    public RandomStrategy() {}

    /**
     * Makes a guess of random colours
     * @return array with the guessed colours
     */
    public Colour[] chooseMove() {
        java.util.Random rand = new java.util.Random();

        Colour[] returnColours = new Colour[Board.COLUMNS];
        Colour[] allColours = Colour.values();
        for(int i = 0; i < Board.COLUMNS; i++){
            returnColours[i] = allColours[rand.nextInt(1, allColours.length)];
        }

        return returnColours;
    }
}
