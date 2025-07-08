public class InsufficientStockException extends Exception {


    public InsufficientStockException(String isbn, int available) {
        super("Not enough stock for book with ISBN " + isbn +
                ". Available: " + available );
    }

}
