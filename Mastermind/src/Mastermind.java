/**
 * This class represents the game logic. It uses MastermindView for input and output to console.
 * @author Jordy Meier - Groep 1
 */

public class Mastermind {
    private MastermindView view;
    private Board board;
    private Computer computer;
    private int turn;

    /**
     * Initializes Mastermind object. Creates Board, MastermindView and Computer objects. Sets turn to 0.
     */
    public Mastermind() {
        turn = 0;
        board = new Board();
        view = new MastermindView(board);
        computer = new Computer();
    }

    /**
     * Starts game loop after asking for user input to divide the roles.
     */
    public void start() {
        if (view.breakerOrMaker()) {
            // player is breaker
            board.setCode(computer.playMaker());
            while (turn < Board.ROWS) {
                Colour[] input = view.getInput();
                if (board.playMove(turn, input)) {
                    view.gameIsWon();
                    break;
                }
                turn++;
                view.show();
            }
        } else {
            // player is maker
            board.setCode(view.getInput());
            while (turn < Board.ROWS) {
                Colour[] input = computer.playBreaker();
                if (board.playMove(turn, input)) {
                    view.gameIsWon();
                    break;
                }
                turn++;
            }
            view.show();
        }
    }
}
