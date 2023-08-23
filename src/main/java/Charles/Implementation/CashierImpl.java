package Charles.Implementation;

import Charles.Domain.Cashier;
import Charles.Domain.Products;
import Charles.Services.CashierServices;

import java.util.Map;

public class CashierImpl implements CashierServices {
    private Cashier cashier;

    public CashierImpl(Cashier cashier) {
        this.cashier = cashier;
    }

    public CashierImpl() {

    }

    @Override
    public boolean addProducts(String productName, int price) {
        if(!new Products().getProductList().containsKey(productName)){
            new Products().getProductList().put(productName, price);
            return true;
        } else
            System.out.println(productName + " already in stock.");
        return false;
    }

    @Override
    public void issueReceipt(Customer customer) {
        int sum = 0;
        System.out.println("---------------------------------------");
        System.out.println("Items" + "                " + "Price");
        for(Map.Entry<String, Integer> items : new Customer().getCart().entrySet()) {
            System.out.println(items.getKey() + "          " + items.getValue());
            sum += items.getValue();
        }
        System.out.println("Bill: " + sum);
        System.out.println("Thank you for patronage. Come back next time.");
    }
}
