public abstract class PurchaseRequest {

    private String ispn;



    public PurchaseRequest(String ispn){

        this.ispn=ispn;
    }


    public String getIspn() {
        return ispn;
    }

    public void setIspn(String ispn) {
        this.ispn = ispn;
    }
}
