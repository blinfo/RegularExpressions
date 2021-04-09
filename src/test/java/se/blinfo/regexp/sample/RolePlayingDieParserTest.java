package se.blinfo.regexp.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Håkan Lidén
 */
public class RolePlayingDieParserTest {
/*
        System.out.println(RolePlayingDieParser.roll("1D10+10"));
        System.out.println(RolePlayingDieParser.roll(null));

    
    */
    @Test
    public void test_die_roll() {
        String input;
        input = "1D1+1";
        assertEquals("Result of " + input + " should be 2", 2l, RolePlayingDieParser.roll(input).longValue());
        input = "1D1-1";
        assertEquals("Result of " + input + " should be 0", 0l, RolePlayingDieParser.roll(input).longValue());
        input = "1D1";
        assertEquals("Result of " + input + " should be 1", 1l, RolePlayingDieParser.roll(input).longValue());
        input = "2D10+2";
        Integer roll;
        roll = RolePlayingDieParser.roll(input);
        assertTrue("Result of " + input + " should be between 4 and 22", roll <= 22 && roll >= 4);
        input = "1D4+1";
        roll = RolePlayingDieParser.roll(input);
        assertTrue("Result of " + input + " should be between 2 and 5", roll <= 5 && roll >= 2);
        input = "3D4*3";
        assertNull("Result should be null", RolePlayingDieParser.roll(input));
        input = null;
        assertNull("Result should be null", RolePlayingDieParser.roll(input));
    }
}
