import java.time.LocalDate;

public class PaperBook extends Purchasable {

    private int quantity;
    private double price;

    public PaperBook(String ispn, String title, LocalDate publishYear, double price,int quantity) {
        super(ispn, title, publishYear , price);
        this.quantity=quantity;
        this.price=price;
    }


    public int getQuantity(){

        return this.quantity;
    }




    public void setQuantity(int quantity){

        if(quantity<0){

            System.out.println("quantity can not be below zero");
            return;
        }

        this.quantity=quantity;

    }



}
