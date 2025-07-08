public class InvalidBookTypeException extends Exception{


    public  InvalidBookTypeException(String type){

        super("Book is not a "+ type);
    }
}
