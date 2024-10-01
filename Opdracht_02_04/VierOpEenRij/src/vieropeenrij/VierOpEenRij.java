package vieropeenrij;

import java.awt.event.MouseEvent;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 * This class presents the game logic. It uses the VorMatrix as a model for the
 * game board and VierOpEenRijVenster as the user interface for the model.
 * @author Kris Luyten
 */
public class VierOpEenRij implements java.awt.event.MouseListener {

    private static VierOpEenRij $main;
    private VierOpEenRijVenster $vorVenster;
    private VorMatrix $vorMatrix;
    public static int ROWS = 6;
    public static int COLS = 7;
    public static enum FILL { RED , YELLOW , EMPTY };
    private FILL $turn;
    private VorStrategy $vsStrategy;



    /**
     * The main method -- the programm starts here
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
           VierOpEenRij.getInstance().start();
        }catch(Exception e){
            //code om alle onverwachte exceptions op te vangen en elegant af te handelen
        }
    }


    /**
     * Initialized the VierOpEenRij object. It sets FILL.RED as the starting color.
     */
    private VierOpEenRij(){
        $turn = FILL.RED;
    }

    /**
     * Part of the Singelton pattern to have only one VierOpEenRij object at all time and
     * that makes it universally accessible
     * @return the singleton VierOpEenRij object
     */
    public static VierOpEenRij getInstance(){
        if($main == null)
            $main = new VierOpEenRij();
        return $main;
    }

    /**
     * Starts the main thread of this programm. Standard Java stuff.
     */
    public void start(){
          java.awt.EventQueue.invokeLater(new RunnableImpl());
    }



    /**
     * Switches turns.
     */
    private void switchTurn(){
        if($turn == FILL.RED)
            $turn = FILL.YELLOW;
        else
            $turn = FILL.RED;
    }

    /**
     * Starts a new Game.
     */
    public void newGame(){
        //Only need to reset datamodel. The Observer pattern takes care of the rest
        $vorMatrix.reset();
    }

    /**
     * Sets the strategy of the opponent. This can be a "computer player" strategy
     * @param strat the strategy which is used by the opponent
     */
    public void setAgainst(VorStrategy strat){
        $vsStrategy = strat;
    }


    /**
     * Executes a move when the user selects a column
     * @param column the selected column in which the disc is dropped
     * @throws ColumnFullException when there is no room left in a column, this exception is thrown
     */
    public void doMove(int column) throws ColumnFullException{
        $vorMatrix.dropItem($turn, column);
        if($vorMatrix.fourAdjacent($turn))
            JOptionPane.showMessageDialog($vorVenster, "Congratulations! " + $turn + " hase won!", "We have a winner", JOptionPane.PLAIN_MESSAGE);
        else
            switchTurn();
    }

    /**
     * Method executes when a mouseclick event is detected
     * @param e the mouse event
     */
    @SuppressWarnings("static-access")
    public void mouseClicked(MouseEvent e) {
        try{
            doMove($vorVenster.getColumn((VorBucket) e.getComponent()));
            if($vsStrategy != null){
                try {
                     Thread.currentThread().sleep(300);
                    doMove($vsStrategy.doMove($vorMatrix));
                } catch (InterruptedException ex) {

                }
            }
        } catch (ColumnFullException cfex) {
           //just clicked on a full column,same user can try again
        } catch (NoSuchColumnException nscex) {
             JOptionPane.showMessageDialog($vorVenster, nscex, "Unexpected error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }

    private class RunnableImpl implements Runnable {

        public RunnableImpl() {
        }

        public void run() {
            $vorVenster = new VierOpEenRijVenster();
            $vorMatrix = new VorMatrix();
            //vorMatrix observes vorBucket...
            //changes in vorMatrix are send to the related  vorBucket
            $vorVenster.addMouseListener(VierOpEenRij.getInstance());
            $vorMatrix.addObserver((Observer) $vorVenster);
            $vorVenster.setVisible(true);
        }
    }
}
