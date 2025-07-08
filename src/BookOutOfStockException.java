public class BookOutOfStockException extends  Exception{


    public BookOutOfStockException(String ispn){

        super(" Book with Ispn : "+ispn +" is out of stock");
    }
}
