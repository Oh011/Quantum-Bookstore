import java.time.LocalDate;

public abstract class Purchasable extends Book {


    private  double price;


    public Purchasable(String ispn, String title, LocalDate publishYear,double price) {
        super(ispn, title, publishYear);
        this.price=price;
    }




    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {



        if(price<0){
            System.out.println("Price can not be below zero");
            return;
        }

        this.price=price;

    }


    @Override
    public boolean IPurchasable() {
        return true;
    }
}
