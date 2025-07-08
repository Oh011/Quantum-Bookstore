import java.time.LocalDate;

public class DemoBook extends Book {


    public DemoBook(String ispn, String title, LocalDate publishYear) {
        super(ispn, title, publishYear);
    }

    @Override
    public boolean IPurchasable() {
        return false;
    }
}
