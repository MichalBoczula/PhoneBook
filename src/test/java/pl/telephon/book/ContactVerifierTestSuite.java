package pl.telephon.book;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContactVerifierTestSuite {
    private final ContactVerifier contactVerifier = new ContactVerifier();

    @Test
    public void numberVerifier() {
        //given
        final String badTelNummer = "111";
        final String goodTelNummer = "111222333";
        final String nullTelNummer = null;
        //when
        boolean testA = contactVerifier.numberVerifier(badTelNummer);
        boolean testB = contactVerifier.numberVerifier(goodTelNummer);
        boolean testC = contactVerifier.numberVerifier(nullTelNummer);
        //then
        assertEquals(false, testA);
        assertEquals(true, testB);
        assertEquals(false, testC);
    }

    @Test
    public void nameVerify() {
        //given
        final String nullName = null;
        final String name = "Majk";
        //when
        boolean testA = contactVerifier.nameVerify(nullName);
        boolean testB = contactVerifier.nameVerify(name);
        //then
        assertEquals(false, testA);
        assertEquals(true, testB);
    }
}