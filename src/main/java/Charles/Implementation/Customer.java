package Charles.Implementation;

import Charles.Domain.ProductProperties;
import Charles.Services.CATEGORY;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private Map<String, ProductProperties> cart = new HashMap<>();

    public Customer() {

    }

    public void enquire(String item, int quantity){
        if(new Products().getDrinks().containsKey(item)){
            if((new Products().getDrinks().get(item).getQuantity() - quantity) >= 0) {
                if(cart.containsKey(item)) {
                    cart.get(item).setQuantity(cart.get(item).getQuantity() + quantity);
                } else {
                    ProductProperties newProduct = new ProductProperties();
                    newProduct.setName(item);
                    newProduct.setCAT(CATEGORY.DRINKS);
                    newProduct.setPrice(new Products().getDrinks().get(item).getPrice());
                    newProduct.setQuantity(quantity);

                    cart.put(item, newProduct);
                }
                new Products().getDrinks().get(item).setQuantity(new Products().getDrinks().get(item).getQuantity() - quantity);
                System.out.println(item + " request made.");
                System.out.println();
            }

        } else if(new Products().getFoods().containsKey(item)){
            if((new Products().getFoods().get(item).getQuantity() - quantity) >= 0) {
                if(cart.containsKey(item)) {
                    cart.get(item).setQuantity(cart.get(item).getQuantity() + quantity);
                } else {
                    ProductProperties newProduct = new ProductProperties();
                    newProduct.setName(item);
                    newProduct.setCAT(CATEGORY.FOOD);
                    newProduct.setPrice(new Products().getFoods().get(item).getPrice());
                    newProduct.setQuantity(quantity);

                    cart.put(item, newProduct);
                }
                new Products().getFoods().get(item).setQuantity(new Products().getFoods().get(item).getQuantity() - quantity);
                System.out.println(item + " request made.");
                System.out.println();
            }

        } else {
            System.out.println("We can't sell " + item + " here.");
            System.out.println();
        }
    }

    public void purchase() {
        //System.out.println(cart);

        System.out.println("-------------------------------");
        System.out.println("Item" + "              " + "Price");
        for(Map.Entry<String, ProductProperties> items: cart.entrySet()){
            System.out.println(items.getKey() + "      |      " + items.getValue());
        }
        System.out.println("Proceed to the teller and make payment.");
        System.out.println();
    }
    public Map<String, ProductProperties> getCart() {
        return cart;
    }
}
