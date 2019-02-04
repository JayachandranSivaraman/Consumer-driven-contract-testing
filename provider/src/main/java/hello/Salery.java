package hello;

public class Salery {

    private final String basicPay;
    private final String allowances;

    public Salery(String basicPay,String allowances) {
        this.basicPay = basicPay;
        this.allowances = allowances;

    }

    public String getBasicPay() {
        return basicPay;
    }

    public String getAllowances() {
        return allowances;
    }


}