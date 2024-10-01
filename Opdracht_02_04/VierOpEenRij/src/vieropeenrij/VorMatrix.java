package vieropeenrij;

/**
 * This class is the model of the game.
 * @author Kris Luyten
 */
public class VorMatrix extends java.util.Observable{
    private VierOpEenRij.FILL $vorMatrix[][] = new VierOpEenRij.FILL[VierOpEenRij.COLS][VierOpEenRij.ROWS];

    /**
     * Creates an empty model for the board
     */
    public VorMatrix(){
        initMatrix();
    }

    /**
     * Initializes the datamodel with empty buckers
     */
    private void initMatrix(){
        for(int i=0; i<VierOpEenRij.COLS;i++)
            for(int j=0; j<VierOpEenRij.ROWS;j++){
                $vorMatrix[i][j]=VierOpEenRij.FILL.EMPTY;
            }
    }

    /**
     * reset the matrix to empty values
     * @post all columns and rows are FILL.EMPTY
     */
    public void reset(){
        initMatrix();
        this.setChanged();
        notifyObservers(null);
    }

    /**
     * Drop a colored item to a certain column
     * @param color the color of the dropped item
     * @param column the column where the item is dropped
     * @throws ColumnFullException when all items are already colored in this column
     * @pre color is not null, not Empty and in Fill
     * @pre column < vm.length
     * @pre there exists a $row where: vm[column][$row] = FILL.EMPTY
     * @post vm[column][$row] = color, where vm[column][$row+1] = FILL.EMPTY or $row = vm.height
     */
    public void dropItem(VierOpEenRij.FILL color, int column) throws ColumnFullException{
        try{
            int row = 0;
            while($vorMatrix[column][row] != VierOpEenRij.FILL.EMPTY && row < VierOpEenRij.ROWS)
                row++;
            if($vorMatrix[column][row] != VierOpEenRij.FILL.EMPTY)
                throw new ColumnFullException(column);
            $vorMatrix[column][row] = color;
            this.setChanged();
            notifyObservers(new java.awt.Point(column,row));
        }catch(ArrayIndexOutOfBoundsException aiobe){
            throw new ColumnFullException(column);
        }
    }

    /**
     * gives the color of a piece on a place of the board
     * @param column
     * @param row
     * @return
     * @pre column < vm.length
     * @pre row < vm.height
     * @post return value is in FILL and not null
     */
    public VierOpEenRij.FILL getFill(int column, int row){
        return $vorMatrix[column][row];
    }

    /**
     * This method checks whether there are four adjacent pieces present on the board
     * @param color the color for which we check whether there are four adjacent pieces
     * @return true if there are four adjacent pieces of the same color on the board, false otherwise
     * @pre color is in FILL and not null
     */
    public boolean fourAdjacent(VierOpEenRij.FILL color){
        //Strive for simplicity by breaking down the method in simple methods
        //that all do just one thing. The four sequential if tests makes sure
        //unnecessary testing is avoided (once found the method returns true after
        //the submethod returns).
        if(!checkRows(color))
          if(!checkColumns(color))
            if(!checkDownDiagonals(color))
                if(!checkUpDiagonals(color))
                return false;
        return true;
    }

    /**
     * Checks each row until four adjacent buckets containing the same color are detected
     * @param color search for four adjacent buckets of this color
     * @return true if there are four adjacent buckets of color found in one of the rows
     */
    private boolean checkRows(VierOpEenRij.FILL color){
        for(int i=0; i<VierOpEenRij.COLS-3;i++)
            for(int j=0; j<VierOpEenRij.ROWS;j++){
                if($vorMatrix[i][j]==color &&
                   $vorMatrix[i+1][j]==color &&
                   $vorMatrix[i+2][j]==color &&
                   $vorMatrix[i+3][j]==color)
                        return true;
            }
        return false;
    }

    /**
     * Checks each column until four adjacent buckets containing the same color are detected
     * @param color search for four adjacent buckets of this color
     * @return true if there are four adjacent buckets of color found in one of the columns
     */
    private boolean checkColumns(VierOpEenRij.FILL color){
         for(int i=0; i<VierOpEenRij.COLS;i++)
            for(int j=0; j<VierOpEenRij.ROWS-3;j++){
                if($vorMatrix[i][j]==color &&
                   $vorMatrix[i][j+1]==color &&
                   $vorMatrix[i][j+2]==color &&
                   $vorMatrix[i][j+3]==color)
                        return true;
            }
         return false;
    }

    /**
     * Checks each downward diagonal until four adjacent buckets containing the same color are detected
     * @param color search for four adjacent buckets of this color
     * @return true if there are four adjacent buckets of color found in one of the downward diagonals
     */
    private boolean checkDownDiagonals(VierOpEenRij.FILL color){
        for(int i=0; i<VierOpEenRij.COLS-3;i++)
            for(int j=0; j<VierOpEenRij.ROWS-3;j++){
                if($vorMatrix[i][j]==color &&
                   $vorMatrix[i+1][j+1]==color &&
                   $vorMatrix[i+2][j+2]==color &&
                   $vorMatrix[i+3][j+3]==color)
                        return true;
            }
        return false;
    }

 /**
     * Checks each upward diagonal until four adjacent buckets containing the same color are detected
     * @param color search for four adjacent buckets of this color
     * @return true if there are four adjacent buckets of color found in one of the upward diagonals
     */
    private boolean checkUpDiagonals(VierOpEenRij.FILL color){
        for(int i=3; i<VierOpEenRij.COLS;i++)
            for(int j=0; j<VierOpEenRij.ROWS-3;j++){
                if($vorMatrix[i][j]==color &&
                   $vorMatrix[i-1][j+1]==color &&
                   $vorMatrix[i-2][j+2]==color &&
                   $vorMatrix[i-3][j+3]==color)
                        return true;
            }
        return false;
    }


}
