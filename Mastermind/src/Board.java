import java.util.Arrays;

/**
 * This class holds the game board logic.
 * @author Jordy Meier - Groep 1
 */
public class Board {
    private Colour[][] board;
    public static final int ROWS = 12;
    public static final int COLUMNS = 4;
    private Colour[] code;

    /**
     * Initiates Board object. Creates code and board array. Fills board with empty Colour.
     */
    public Board(){
        board = new Colour[ROWS][COLUMNS];
        code = new Colour[COLUMNS];

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++){
                board[i][j] = Colour.EMPTY;
            }
        }
    }

    /**
     * Get the colour of a chosen location
     * @param row row where you want to know the colour
     * @param col column where you want to know the colour
     * @return Colour of the chosen location
     */
    public Colour getPlace(int row, int col){
        return board[row][col];
    }

    /**
     * Sets the code to the chosen code by computer or player
     * @param code the correct code that needs to be guessed
     */
    public void setCode(Colour[] code){
        this.code = code;
    }

    /**
     * Plays a guess.
     * @param row row to store the guess
     * @param input array of guessed colours (needs to be same size as COLUMNS)
     * @return true if guess was correct and game is done
     */
    public boolean playMove(int row, Colour[] input){
        board[row] = input;
        return checkWin(input);
    }

    private boolean checkWin(Colour[] input){
        boolean win = true;
        for(int i = 0; i < COLUMNS; i++){
            if(input[i] != code[i]){
                win = false;
                break;
            }
        }
        return win;
    }

    /**
     * How many white and red pins should be placed next to the guess
     * @param row the row the guess is on
     * @return int array of size 2 with the amount of white pins at 0 and red pins at 1
     */
    public int[] getFeedBack(int row){
        int white = 0;
        int red = 0;

        for(int i = 0; i < COLUMNS; i++){
            if(board[row][i] == code[i]){
                //System.out.println(board[row][i].toString() + code[i].toString());
                white++;
                continue;
            }
            if(Arrays.asList(code).contains(board[row][i])){
                red++;
            }
        }

        int[] arr = {white, red};
        return arr;
    }
}
