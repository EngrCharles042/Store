package Charles.Services;

import Charles.Implementation.Customer;

public interface CashierServices {
    boolean addProducts(String productName, int price);
    void issueReceipt(Customer customer);
}
