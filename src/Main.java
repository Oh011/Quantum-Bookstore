import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws BookExistsException, BookNotPurchasableException, InsufficientStockException, BookNotFoundException, InvalidBookTypeException, BookOutOfStockException {



        IBookRepository repository = new BookRepository();
        BookInventoryManager manager = new BookInventoryManager(repository);


        //--> uses manger to add , remove , buy
        TestClass test=new TestClass(manager);



        test.TestAdding();

        test.TestRemoving();

        test.TestRemovingOutDatedBooks();


        test.BuyPaperBook();

        test.BuyExcessQuantityPaperBook();

        test.BuyOutOfStockPaperBook();


        test.BuyNotFoundBook();


        test.BuyEBook();

        test.TryBuyDemoBook();

        

    }
}