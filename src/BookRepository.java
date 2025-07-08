import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository implements   IBookRepository{

    Map<String,Book> books;


    public  BookRepository(){

        books=new HashMap<>();
    }


    @Override
    public void AddBook(Book book) throws BookExistsException {

        String bookIspn=book.getIspn();


        if(this.Contains(bookIspn)){


      throw new BookExistsException(bookIspn);

        }


        books.put(bookIspn,book);

    }

    @Override
    public Book FindByIspn(String ispn) {

        return  books.get(ispn);
    }


    @Override
    public boolean Contains(String Ispn){


        return books.containsKey(Ispn);
    }

    @Override
    public void UpdateBook(Book book) throws BookNotFoundException {

        if(this.Contains(book.getIspn())){


            books.put(book.getIspn(),book);
            return;

        }

        throw  new BookNotFoundException(book.getIspn());
    }


    @Override
    public List<Book> RemoveOutdatedBooks(int years){

        List<Book> OutDatedBooks=new ArrayList<>();

        for(Book book: books.values()){

            int yearsPassed = Period.between(book.getPublishYear(), LocalDate.now()).getYears();
            if(yearsPassed>years){

                OutDatedBooks.add(book);
            }
        }

        return OutDatedBooks;
    }

    @Override
    public Book RemoveBook(String Ispn) throws BookNotFoundException {


        if(!this.Contains(Ispn)){

            throw  new BookNotFoundException(Ispn);
        }

        Book book=this.books.remove(Ispn);

        return book;
    }
}
