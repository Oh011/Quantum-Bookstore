import java.time.LocalDate;

public class EBook extends Purchasable {

    private String fileType;
    private  double price;

    public EBook(String ispn, String title, LocalDate publishYear, double price,String fileType) {
        super(ispn, title, publishYear,price);
        this.fileType=fileType;
    }

    public String getFileType(){

        return  this.fileType;

    }





    public void setFileType(String fileType){

        this.fileType=fileType;
    }
}
