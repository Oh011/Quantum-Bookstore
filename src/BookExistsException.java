public class BookExistsException extends Exception{


    public  BookExistsException(String ispn){

        super("Book with ISpn : "+ ispn + " exists in inventory");
    }
}
