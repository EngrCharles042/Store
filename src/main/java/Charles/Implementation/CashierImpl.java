package Charles.Implementation;

import Charles.Domain.Cashier;
import Charles.Domain.CustomerModel;
import Charles.Domain.ProductProperties;
import Charles.Services.CashierServices;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CashierImpl implements CashierServices {
    private Cashier cashier;

    private static Queue<CustomerModel> customersFIFOQueue = new LinkedList<>();
    private static Queue<CustomerModel> customersPriorityQueue = new PriorityQueue<>();

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

    public void sellFIFO() {
        while (!customersFIFOQueue.isEmpty()) {
            CustomerModel currentCustomer = customersFIFOQueue.poll();
            Map<String, ProductProperties> myCart = currentCustomer.getCart();
            String fullName = currentCustomer.getFullName();
            issueReceipt(myCart, fullName);
        }
    }

    public void sellPriority() {
        while (!customersPriorityQueue.isEmpty()) {
            CustomerModel currentCustomer = customersPriorityQueue.poll();
            Map<String, ProductProperties> myCart = currentCustomer.getCart();
            String fullName = currentCustomer.getFullName();
            issueReceipt(myCart, fullName);
        }
    }
    private void issueReceipt(Map<String, ProductProperties> myCart, String fullName) {
        int sum = 0;

//        Iterator<CustomerModel> iterator = customersQueue.iterator();
//
//        while (iterator.hasNext()) {
//            CustomerModel currentCustomer = iterator.next();
//        }

//        while (!customersFIFOQueue.isEmpty()) {
//            CustomerModel currentCustomer = customersFIFOQueue.poll();
//            Map<String, ProductProperties> myCart = currentCustomer.getCart();

        System.out.println("---------------------------------------");
        System.out.println("Items" + "                " + "Price");
        for (Map.Entry<String, ProductProperties> items : myCart.entrySet()) {
            System.out.println(items.getKey() + "          " + items.getValue().getPrice());
            sum += items.getValue().getPrice();
        }
        System.out.println("Bill: " + sum);
        System.out.println("Thank you for patronage " + fullName + ". Come back next time.");
    }

    public Queue<CustomerModel> getCustomersFIFOQueue() {
        return customersFIFOQueue;
    }

    public Queue<CustomerModel> getCustomersPriorityQueue() {
        return customersPriorityQueue;
    }
}
