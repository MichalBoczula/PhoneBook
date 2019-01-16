package pl.telephon.book;

import java.util.NoSuchElementException;

public enum ControlOptions {
    AddContact(1, "Add Contact, first give telNummer, second get Name"),
    RemoveContact(2, "Remove Contact, pls input name or telNummer"),
    FindContact(3, "Find Contact, pls input name or telNummer"),
    GetAllContacts(4, "Get All Contact"),
    Exit(5, "Exit Program");

    private final int shortcut;
    private final String description;

    ControlOptions(int shortcut, String description) {
        this.shortcut = shortcut;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    static ControlOptions converToControlOption(int i) {
        try {
            if (i > values().length) {
                throw new NoSuchElementException();
            } else if (i <= 0) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                return values()[i - 1];
            }
        } catch (NoSuchElementException n) {
            System.out.println("pls input number from 1 to 5");
            return  null;
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("number can NOT be equal 0 or below");
            return null;
        }
    }

    @Override
    public String toString() {
        return "ControlOptions{" +
                "shortcut=" + shortcut +
                ", description='" + description + '\'' +
                '}';
    }
}