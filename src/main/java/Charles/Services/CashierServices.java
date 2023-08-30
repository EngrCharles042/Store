package Charles.Services;

import Charles.Implementation.Customer;

public interface CashierServices {
    boolean addProducts();
    void issueReceipt(Customer customer);
}
