package Charles;

import Charles.Domain.Cashier;
import Charles.Domain.Manager;
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
        Customer customer = new Customer();
        Customer customer1 = new Customer();

        //Adding to stock
        cashierImpl.addProducts("Pepper soup",1500);
        cashierImpl.addProducts("Coke",250);
        cashierImpl.addProducts("Rice",1000);

        //Customer making request
        customer.enquire("Coke");
        customer.enquire("Pepper soup");
        customer.enquire("Rice");
        customer1.enquire("Coke");
        customer1.enquire("Pepper soup");


        //Make buy request
        customer.purchase();
        customer1.purchase();

        //Cashier should give receipt
        cashierImpl.issueReceipt(customer);
        cashierImpl.issueReceipt(customer1);
    }
}
