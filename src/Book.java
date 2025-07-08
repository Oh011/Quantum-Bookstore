import java.time.LocalDate;

public abstract class Book {


    private  String ispn ;
    private  String title;

    private LocalDate publishYear;





    public Book(String ispn, String title, LocalDate publishYear) {

        this.ispn = ispn;
        this.title = title;
        this.publishYear = publishYear;

    }



    public String getIspn() {
        return ispn;
    }

    public void setIspn(String ispn) {
        this.ispn = ispn;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {

        this.title = title;
    }

    public LocalDate getPublishYear() {
        return publishYear;
    }


    public void setPublishYear(LocalDate publishYear) {


        if(publishYear.isAfter( LocalDate.now())){

            System.out.println("Data can not be in future");
            return;
        }

        this.publishYear=publishYear;

    }


     public abstract boolean IPurchasable();






}
