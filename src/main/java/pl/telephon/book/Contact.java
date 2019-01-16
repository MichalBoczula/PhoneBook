package pl.telephon.book;

public class Contact {
    private String telNumber;
    private String name;

    public Contact(String telNumber, String name) {
        this.telNumber = telNumber;
        this.name = name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "telNumber='" + telNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
