package Charles.Implementation;

import Charles.Domain.Products;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private  Map<String, Integer> cart = new HashMap<>();

    public Customer(Products products) {
        this.
    }

    public void enquire(String item){
        if(getProductList().containsKey(item)){
            cart.put(item, new Products().getProductList().get(item));
            System.out.println(item + " request made.");
            System.out.println();
        } else {
            System.out.println("We can't sell " + item + " here.");
            System.out.println();
        }
    }

    public void purchase() {
        //System.out.println(cart);

        System.out.println("-------------------------------");
        System.out.println("Item" + "              " + "Price");
        for(Map.Entry<String, Integer> items: cart.entrySet()){
            System.out.println(items.getKey() + "      |      " + items.getValue());
        }
        System.out.println("Proceed to the teller and make payment.");
        System.out.println();
    }
    public static Map<String, Integer> getCart() {
        return cart;
    }
}
