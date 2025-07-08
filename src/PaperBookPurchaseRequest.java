public class PaperBookPurchaseRequest extends PurchaseRequest {


  private    String address;
  private   int quantity;



  public PaperBookPurchaseRequest(String ispn, String address, int quantity) {

    super(ispn);

    this.address = address;
    this.quantity = quantity;
  }






  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }


}
