import java.util.Scanner;

/**
 * Class to handle input and output to console
 *  @author Jordy Meier - Groep 1
 */
public class MastermindView {
    private Board board;
    private Scanner scanner;

    /**
     * Creates instance of Mastermindview. Creates scanner object for input.
     * @param board board to be displayed
     */
    public MastermindView(Board board) {
        this.board = board;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Shows the baord as characters in console
     * @pre board is fully filled with Colours
     */
    public void show(){
        for(int i = 0; i < Board.ROWS; i++){
            for(int j = 0; j< Board.COLUMNS; j++){
                System.out.print(board.getPlace(i, j).toChar());
            }
            System.out.print(" ");
            int[] feedback = board.getFeedBack(i);
            for(int j = 0; j < feedback[0]; j++){
                System.out.print("W");
            }
            for(int j = 0; j < feedback[1]; j++){
                System.out.print("R");
            }
            System.out.println();
        }
    }

    /**
     * Gets user input if they want to be the breaker or maker
     * @return true if breaker
     */
    public boolean breakerOrMaker(){
        System.out.println("Do you want to be maker or breaker? (M/B)");
        String input = scanner.nextLine().toUpperCase();

        if(input.equals("B")){
            return true;
        }
        if(input.equals("M")) {
            return false;
        }

        System.out.println("Invalid input!");
        return breakerOrMaker();
    }

    /**
     * Asks user for input for 1 row
     * @return the inputted colours
     */
    public Colour[] getInput(){
        Colour[] inputs = new Colour[Board.COLUMNS];

        printValidInputs();
        System.out.println("input:");

        String input = scanner.nextLine();

        try{
            if(input.length() != Board.COLUMNS) throw new InvalidInputException();
            for(int i = 0; i < Board.COLUMNS; i++){
                inputs[i] = Colour.fromChar(input.charAt(i));
            }
        } catch(InvalidInputException e){
            System.out.println("Invalid input!");
            inputs = getInput();
        }

        return inputs;
    }

    /**
     * shows possible input
     */
    public void printValidInputs(){
        Colour[] allcolours = Colour.values();
        System.out.print("(valid characters are: ");
        for (int i = 1; i < allcolours.length - 1; i++) {
            System.out.print(allcolours[i].toChar());
            System.out.print(", ");
        }
        System.out.println(allcolours[allcolours.length - 1] + ")");
    }

    /**
     * shows if game is won
     */
    public void gameIsWon(){
        System.out.println("The code has been guessed!");
    }
}

