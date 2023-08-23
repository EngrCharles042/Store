package Charles.Domain;

public class Cashier extends Staff{
    private String tellerNumber;
    private boolean isEmployed;
    public Cashier(String name, byte age, String phoneNumber, String email, String tellerNumber) {
        super(name, age, phoneNumber, email);
    }

    public String getTellerNumber() {
        return tellerNumber;
    }

    public void setTellerNumber(String tellerNumber) {
        this.tellerNumber = tellerNumber;
    }

    public boolean getEmployed() {
        return isEmployed;
    }

    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }
}
