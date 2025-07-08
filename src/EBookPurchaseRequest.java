public class EBookPurchaseRequest extends PurchaseRequest {


    private String email;


    public EBookPurchaseRequest(String ispn, String email) {

        super(ispn);
        this.email = email;
    }




    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
}
