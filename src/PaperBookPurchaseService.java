public class PaperBookPurchaseService implements PurchaseService<PaperBookPurchaseRequest>{


    private final IBookRepository repository;

    private final  ShippingService shippingService;




    public PaperBookPurchaseService(IBookRepository repository,ShippingService shippingService){

        this.shippingService=shippingService;
        this.repository=repository;
    }


    @Override
    public void buy(PaperBookPurchaseRequest request) throws BookNotFoundException, InvalidBookTypeException, BookOutOfStockException, InsufficientStockException {

        String bookIspn= request.getIspn();
        Book book= repository.FindByIspn(bookIspn);


        if(book==null)
            throw new BookNotFoundException(bookIspn);

        if (!(book instanceof PaperBook paperBook))
            throw new InvalidBookTypeException("paper Book");

        int orderedQuantity= request.getQuantity();
        int availableQuantity= paperBook.getQuantity();

        if(availableQuantity<=0)
            throw new BookOutOfStockException(bookIspn);


        if(orderedQuantity>availableQuantity )
            throw  new InsufficientStockException(bookIspn,availableQuantity);


        double shippingCost= this.shippingService.ProcessShipment( request.getAddress());

        double subTotal=paperBook.getPrice() * request.getQuantity();

        System.out.println("P:"+paperBook.getPrice());

        double total=shippingCost+subTotal;

        paperBook.setQuantity(availableQuantity-orderedQuantity);


        //reduced quantity
        repository.UpdateBook(book);


        System.out.println(orderedQuantity + " "+book.getTitle() +" quantity : "+orderedQuantity);
        System.out.println("Subtotal : "+subTotal);
        System.out.println("Total : "+  total);

    }
}
