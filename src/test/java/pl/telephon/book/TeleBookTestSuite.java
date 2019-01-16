package pl.telephon.book;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TeleBookTestSuite {

    @Test
    public void addContact() {
        //given
        final TeleBook teleBook = new TeleBook();
        final Contact testA = new Contact("111222333", "A");
        final Contact testB = new Contact("333222111", "B");
        //when
        boolean first =teleBook.addContact(testA);
        boolean second =teleBook.addContact(testB);
        //then
        assertTrue(first);
        assertTrue(second);
        assertEquals(2, teleBook.getContacts().size());
    }

    @Test
    public void removeContect() {
        //given
        final TeleBook teleBook = new TeleBook();
        final Contact testA = new Contact("111222333", "A");
        final Contact testB = new Contact("333222111", "B");
        teleBook.getContacts().add(testA);
        teleBook.getContacts().add(testB);
        //when
        boolean first = teleBook.removeContect(testA);
        boolean second = teleBook.removeContect(teleBook.findByNameOrTelNummer(testB.getName()));
        //then
        assertTrue(first);
        assertTrue(second);
        assertEquals(0, teleBook.getContacts().size());
    }

    @Test
    public void findBy() {
        //given
        final TeleBook teleBook = new TeleBook();
        final Contact testA = new Contact("111222333", "A");
        final Contact testB = new Contact("333222111", "B");
        teleBook.getContacts().add(testA);
        teleBook.getContacts().add(testB);
        //when
        final Contact a = teleBook.findByNameOrTelNummer(testA.getName());
        final Contact b = teleBook.findByNameOrTelNummer(testB.getTelNumber());
        //then
        assertEquals(testA.getName(), a.getName());
        assertEquals(testA.getTelNumber(), a.getTelNumber());
        assertEquals(testB.getName(), b.getName());
        assertEquals(testB.getTelNumber(), b.getTelNumber());
    }
}