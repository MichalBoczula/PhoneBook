package pl.telephon.book;

import com.google.common.primitives.Ints;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;


public class TeleBook {
    private final FileManagment fileManagment = FileManagment.getFileManagment();
    private final ContactVerifier contactVerifier = new ContactVerifier();
    private PropertiesLoader propertiesLoader = PropertiesLoader.getInstance();
    private File file = new File(propertiesLoader.getProperties().getProperty("file.location"));
    private List<Contact> contacts = setContacts();

    private List<Contact> setContacts() {
        try {
            contacts = fileManagment.readFromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }


    public boolean addContact(final Contact contact) {
        if (contactVerifier.nameVerify(contact.getName()) &&
                contactVerifier.numberVerifier(contact.getTelNumber())) {
            if (findByNameOrTelNummer(contact.getTelNumber()) != null) {
                System.out.println("This contact name exists in Library, pls input different one");
                return false;
            } else if (findByNameOrTelNummer(contact.getName()) != null) {
                System.out.println("This telNummer exists in Library, pls input different one");
                return false;
            } else {
                return contacts.add(contact);
            }
        } else {
            return false;
        }
    }

    public boolean removeContect(final Contact contact) {
        if (contact != null) {
            return contacts.remove(contact);
        } else {
            return false;
        }
    }

    public Contact findByNameOrTelNummer(String nameOrTelNumer) {
        Contact contact = null;
        try {
            if (Ints.tryParse(nameOrTelNumer) == null) {
                contact = contacts.stream()
                        .filter(c -> c.getName().equalsIgnoreCase(nameOrTelNumer))
                        .findAny()
                        .get();
            } else {
                contact = contacts.stream()
                        .filter(c -> c.getTelNumber().equalsIgnoreCase(nameOrTelNumer))
                        .findAny()
                        .get();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Contact is NOT in Library");
            return contact;
        }
        return contact;
    }

    public void writeContactsToFile() throws IOException {
        fileManagment.writeLineToFile(file, contacts);
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}


