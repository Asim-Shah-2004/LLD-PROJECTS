package models;

public class User{
    private String name;
    private String address;
    private int userId;
    private static int nextId = 0;
    private Cart cart;


    public User(String name,String address){
        this.name = name;
        this.address = address;
        this.userId = ++nextId;
        this.cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    

}