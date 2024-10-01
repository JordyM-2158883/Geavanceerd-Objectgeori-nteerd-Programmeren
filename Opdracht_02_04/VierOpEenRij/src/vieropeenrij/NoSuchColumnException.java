package vieropeenrij;

/**
 * Exception thrown when a bucket is used that is not part of a column. This indicates
 * there is something wrong with the initialization of the board
 * @author Kris Luyten
 */
public class NoSuchColumnException extends Exception{
    private VorBucket $bucket;

    public NoSuchColumnException(VorBucket bucket) {
        $bucket = bucket;
    }
    
    public VorBucket getBucket(){
        return $bucket;
    }

    @Override
    public String toString(){
        return "Undefined column has been specified,\n please consider submitting a bug report";
    }
    

}
