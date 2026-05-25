package models;

public class DeliveryOrder extends Order{

    private String userAddress;

    public DeliveryOrder() {
        userAddress = "";
    }

    @Override
    public String getType() {
        return "Delivery Order";
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

}