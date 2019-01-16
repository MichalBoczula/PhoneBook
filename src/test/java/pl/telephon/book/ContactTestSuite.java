package pl.telephon.book;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContactTestSuite {

    @Test
    public void testContact(){
        //given
        final Contact contact = new Contact("999888777", "Majk");
        //when & then
        assertEquals("Majk", contact.getName());
        assertEquals("999888777", contact.getTelNumber());
    }

    @Test
    public void testSetMethods(){
        //given
        final Contact contact = new Contact("999888777", "Majk");
        //when
        contact.setName("new name");
        contact.setTelNumber("111222333");
        //then
        assertEquals("new name", contact.getName());
        assertEquals("111222333", contact.getTelNumber());
    }

}
