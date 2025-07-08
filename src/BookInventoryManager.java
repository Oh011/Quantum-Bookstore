import java.util.List;

public  class BookInventoryManager {


    private final IBookRepository bookRepository;


    public  BookInventoryManager(IBookRepository bookRepository){

        this.bookRepository=bookRepository;
    }



    public IBookRepository GetRepository(){

        return this.bookRepository;
    }


    boolean CheckIfBookIsPurchasable(String ispn) throws BookNotPurchasableException {

      Book book =  bookRepository.FindByIspn(ispn);


      if(!book.IPurchasable()){

          throw new BookNotPurchasableException();
      }

      return book.IPurchasable();

    }

    void Add(Book book) throws BookExistsException {


       bookRepository.AddBook(book);
        System.out.println("Books added successfully.");
    }

    void AddBooks(List<Book> books) throws BookExistsException {


        for(Book book :books){

            bookRepository.AddBook(book);
        }
    }

    void RemoveBook(String Ispn) throws BookNotFoundException {

        bookRepository.RemoveBook(Ispn);
    }


    void RemoveOutDatedBooks(int years){

      List<Book> books=  bookRepository.RemoveOutdatedBooks(years);


      System.out.println("OutDated Books Removed :");


      for(Book book : books){

          System.out.println("Ispn : "+book.getIspn() +" Title:"+book.getTitle());
      }
    }




    }

