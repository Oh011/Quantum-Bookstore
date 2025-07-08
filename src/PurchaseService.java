public interface PurchaseService<T extends PurchaseRequest> {

    void buy(T request) throws BookNotFoundException, InvalidBookTypeException, BookOutOfStockException, InsufficientStockException;

}
