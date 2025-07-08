public class ShippingService {

    private final double ShippingCost=35.5;



    public double ProcessShipment(String address ){

        System.out.println("Book with Ispn  is Shipped to "+address );

        return ShippingCost;
    }
}
