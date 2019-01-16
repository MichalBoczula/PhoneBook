package pl.telephon.book;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControlOptionsTestSuite {

    @Test
    public void converToControlOption() {
        //given
        final int zero = 0;
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        //when
        final ControlOptions test0 = ControlOptions.converToControlOption(zero);
        final ControlOptions test1 = ControlOptions.converToControlOption(one);
        final ControlOptions test2 = ControlOptions.converToControlOption(two);
        final ControlOptions test3 = ControlOptions.converToControlOption(three);
        final ControlOptions test4 = ControlOptions.converToControlOption(four);
        final ControlOptions test5 = ControlOptions.converToControlOption(five);
        final ControlOptions test6 = ControlOptions.converToControlOption(six);
        //then
        assertEquals(null, test0);
        assertEquals(ControlOptions.AddContact, test1);
        assertEquals(ControlOptions.RemoveContact, test2);
        assertEquals(ControlOptions.FindContact, test3);
        assertEquals(ControlOptions.GetAllContacts, test4);
        assertEquals(ControlOptions.Exit, test5);
        assertEquals(null, test6);
    }
}