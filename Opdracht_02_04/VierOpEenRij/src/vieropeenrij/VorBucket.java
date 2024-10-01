package vieropeenrij;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * Presents the GUI for one bucket on the board.
 * @author Kris Luyten
 */
public class VorBucket extends JLabel{


    private static ImageIcon red = VorBucket.createImageIcon("red.png");
    private static ImageIcon yellow = VorBucket.createImageIcon("yellow.png");
    private static ImageIcon empty = VorBucket.createImageIcon("empty.png");

    private VierOpEenRij.FILL $state;

    /**
     * Creates a bucket with an "empty" presentation
     */
    public VorBucket(){
        setOpaque(true);
        setIcon(empty);
        invalidate();
    }

    /**
     * This functions sets the specific representation for a bucket: empty, yellow or red
     * @param the color of this item
     * @pre item is not null
     * @post bucket.icon.color = item
     */
    public void setFill(VierOpEenRij.FILL item){
        $state = item;
        //update label with appropriate representation
        switch($state){
            case YELLOW :
                setIcon(yellow);
                break;
            case RED :
                setIcon(red);
                break;
            case EMPTY :
                setIcon(empty);
        }
        invalidate();
    }

    /**
     * Gets the color of this bucket
     * @return the color of this bucket
     */
    public VierOpEenRij.FILL getFill(){
        return $state;
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = VorBucket.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}
