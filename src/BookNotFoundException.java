public class BookNotFoundException extends Exception{


    public  BookNotFoundException(String ispn){

        super("Book with Ispn : "+ispn + " is not found");
    }
}
