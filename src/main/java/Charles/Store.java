package Charles;

import Charles.Domain.Cashier;
import Charles.Domain.CustomerModel;
import Charles.Domain.Manager;
import Charles.Implementation.Products;
import Charles.Implementation.CashierImpl;
import Charles.Implementation.Customer;
import Charles.Implementation.ManagerImpl;

public class Store {
    public static void main(String[] args) {

        //Creating instances
        Manager manager = new Manager("Charles",(byte) 30,"08064659914","degame94@gmail.com");
        ManagerImpl managerImpl = new ManagerImpl(manager);

        Cashier cashier = new Cashier("Jennifer",(byte) 31,"08062118367","enuma.jennifer@decagon.dev","Table 2");

        CashierImpl cashierImpl = new CashierImpl(cashier);
        //CustomerModel customerModel = new CustomerModel("Mike");
        Customer customer1 = new Customer(new CustomerModel("Mike"));
        Customer customer2 = new Customer(new CustomerModel("John"));
        Customer customer3 = new Customer(new CustomerModel("Samuel"));
        //Customer customer = new Customer(new CustomerModel("Mike"));

        new Products().addProductsToStore();
        //new Products().viewItems(new Products().getFoods());
        System.out.println();
        //new Products().viewItems(new Products().getDrinks());
//        Customer customer = new Customer(new Products());
//        Customer customer1 = new Customer(new Products());

        //Customer making request
        customer3.enquire("Coke", 1);
        customer3.enquire("Pepper soup", 2);

        customer1.enquire("Coke", 3);
        customer1.enquire("Pepper soup", 3);

        customer2.enquire("Coke", 4);
        customer2.enquire("Pepper soup", 4);

        //Make purchase request
        customer3.purchase();
        customer1.purchase();
        customer2.purchase();

        //cashierImpl.issueReceipt();

        cashierImpl.sellFIFO();
        //cashierImpl.sellPriority();

        //Adding to stock
//        cashierImpl.addProducts("Pepper soup",1500);
//        cashierImpl.addProducts("Coke",250);
//        cashierImpl.addProducts("Rice",1000);

        //Customer making request
//        customer.enquire("Coke");
//        customer.enquire("Pepper soup");
//        customer.enquire("Rice");
//        customer1.enquire("Coke");
//        customer1.enquire("Pepper soup");


        //Make buy request
//        customer.purchase();
//        customer1.purchase();

        //Cashier should give receipt
//        cashierImpl.issueReceipt(customer);
//        cashierImpl.issueReceipt(customer1);
    }
}
