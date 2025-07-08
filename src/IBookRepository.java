import java.util.List;

public interface IBookRepository {


    void AddBook(Book book) throws BookExistsException;

    Book FindByIspn(String ispn);
     boolean Contains(String Ispn);


     List<Book> RemoveOutdatedBooks(int years);

     Book RemoveBook(String Ispn) throws BookNotFoundException;


    void UpdateBook(Book book) throws BookNotFoundException;

}
