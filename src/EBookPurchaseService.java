public class EBookPurchaseService implements PurchaseService<EBookPurchaseRequest>{




    private final IBookRepository repository;

    private  final  EmailService emailService;


    public EBookPurchaseService(IBookRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService=emailService;
    }

    @Override
    public void buy(EBookPurchaseRequest request) throws BookNotFoundException, InvalidBookTypeException {


        String bookIspn= request.getIspn();
        Book book= repository.FindByIspn(bookIspn);


        if(book==null)
            throw new BookNotFoundException(bookIspn);

        if (!(book instanceof EBook Ebook))
            throw new InvalidBookTypeException("Ebook");


        this.emailService.SendEmail(request.getEmail());

        System.out.println("Book Price :"+Ebook.getPrice());

    }
}
