package se.blinfo.regexp.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class ImprovedRolePlayingDieParserTest {
/*
    */
    @Test
    public void test_die_roll() {
        String input;
        input = "1D1+1";
        assertEquals("Result of " + input + " should be 2", 2l, ImprovedRolePlayingDieParser.roll(input).longValue());
        input = "1D1-1";
        assertEquals("Result of " + input + " should be 0", 0l, ImprovedRolePlayingDieParser.roll(input).longValue());
        input = "1D1";
        assertEquals("Result of " + input + " should be 1", 1l, ImprovedRolePlayingDieParser.roll(input).longValue());
        input = "2D10+2";
        Integer roll;
        roll = ImprovedRolePlayingDieParser.roll(input);
        assertTrue("Result of " + input + " should be between 4 and 22", roll <= 22 && roll >= 4);
        input = "Roll 1D100 for items from table 14.1";
        roll = ImprovedRolePlayingDieParser.roll(input);
        assertTrue("Result of " + input + " should be between 1 and 100", roll <= 100 && roll >= 1);
        input = null;
        assertNull("Result should be null", ImprovedRolePlayingDieParser.roll(input));
        input = "Roll a percentage die for result";
        assertNull("Result should be null", ImprovedRolePlayingDieParser.roll(input));
    }
}
