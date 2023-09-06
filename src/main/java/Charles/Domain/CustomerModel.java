package Charles.Domain;

import java.util.Map;

public class CustomerModel implements Comparable<CustomerModel> {

    private  String fullName;
    private  int ID;
    private Map<String, ProductProperties> cart;
    private static int count = 0;

    private int quantity;

    public CustomerModel(String fullName, Map<String, ProductProperties> cart) {
        this.fullName = fullName;
        this.cart = cart;
        //this.ID = count++;
    }

    public CustomerModel(String fullName) {
        this.fullName = fullName;
        this.ID = count++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getID() {
        return ID;
    }

    public void setCart(Map<String, ProductProperties> cart) {
        this.cart = cart;
    }

    public Map<String, ProductProperties> getCart() {
        return cart;
    }

    private int getCartQuantity() {
        for(var item: cart.values()){
            quantity += item.getQuantity();
        } return quantity;
    }

    @Override
    public int compareTo(CustomerModel o) {
        if(this.getCartQuantity() > o.getCartQuantity()) {
            return 1;
        } else if (this.getCartQuantity() < o.getCartQuantity()) {
            return -1;
        } else
            return 0;
    }
}
