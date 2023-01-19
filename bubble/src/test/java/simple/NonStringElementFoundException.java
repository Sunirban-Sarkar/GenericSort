package simple;

public class NonStringElementFoundException extends RuntimeException{
    public NonStringElementFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
