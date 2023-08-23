package Charles.Implementation;

import Charles.Domain.Cashier;
import Charles.Domain.Manager;
import Charles.Services.ManagerialServices;

public class ManagerImpl implements ManagerialServices {
    private Manager manager;

    public ManagerImpl(Manager manager) {
        this.manager = manager;
    }
    @Override
    public void hire(Cashier cashier) {
        cashier.setEmployed(true);
        System.out.println(cashier.getName() + " is employed!" + '\n');
    }

    @Override
    public void fire(Cashier cashier) {
        if(cashier.getEmployed()) {
            cashier.setEmployed(false);
            System.out.println(cashier.getName() + ", it's unfortunate to bring this to your notice, but you have been fired!" + '\n');
        } else {
            System.out.println(cashier.getName() + " this cashier was never hired...");
        }
    }
}
