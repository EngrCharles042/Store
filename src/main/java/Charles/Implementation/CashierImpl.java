package Charles.Implementation;

import Charles.Domain.Cashier;
import Charles.Domain.ProductProperties;
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
    public boolean addProducts() {
        if(new Products().addProductsToStore()) {
            System.out.println("Products added successfully");
            return true;
        } else
            System.out.println("Error adding products");
        return false;
    }

    @Override
    public void issueReceipt(Customer customer) {
        int sum = 0;
        System.out.println("---------------------------------------");
        System.out.println("Items" + "                " + "Price");
        for(Map.Entry<String, ProductProperties> items : customer.getCart().entrySet()) {
            System.out.println(items.getKey() + "          " + items.getValue());
            sum += items.getValue().getPrice();
        }
        System.out.println("Bill: " + sum);
        System.out.println("Thank you for patronage. Come back next time.");
    }
}
