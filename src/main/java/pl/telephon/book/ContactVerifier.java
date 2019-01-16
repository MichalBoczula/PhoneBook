package pl.telephon.book;

public class ContactVerifier {

    public boolean numberVerifier(String telNumber) {
        try {
            if (telNumber == null) {
                throw new NullPointerException();
            }
            if (telNumber.length() != 9) {
                throw new IllegalArgumentException();
            }
        } catch (NullPointerException n) {
            System.out.println("tel number can NOT be null");
            return false;
        } catch (IllegalArgumentException i) {
            System.out.println("tel must be 9 numbers, format is 111222333 watch out " +
                    "on white marks between numbers");
            return false;
        }
        return true;
    }

    public boolean nameVerify(String name) {
        try {
            if (name == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException n){
            System.out.println("name can NOT be null");
            return false;
        }
        return true;
    }
}
