/**
 * Class for the players opponent
 * @author Jordy Meier - Groep 1
 */
public class Computer {
    private Strategy strategy;

    /**
     * Initiates the Computer object. Chooses a solve strategy.
     */
    public Computer(){

        strategy = new RandomStrategy();
    }

    /**
     * if the computer is the maker it randomly chooses colours as the code
     * @return array with the chosen colours
     */
    public Colour[] playMaker(){
        java.util.Random rand = new java.util.Random();

        Colour[] returnColours = new Colour[Board.COLUMNS];
        Colour[] allColours = Colour.values();
        for(int i = 0; i < Board.COLUMNS; i++){
            returnColours[i] = allColours[rand.nextInt(1, allColours.length)];
        }

        return returnColours;
    }

    /**
     * Utilizes the chosen strategy to make a move
     * @pre the correct strategy is selected in the constructor
     * @return array with the colours chosen by the strategy
     */
    public Colour[] playBreaker(){
        return strategy.chooseMove();
    }
}
