/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import assignment2.Assignment2;

/**
 *
 * @author Usman
 */

public class SnakeTester { //Unit testing

    @Test
    public void test()
    {
        assertEquals(true, Assignment2.sameTurn(6));
        assertNotEquals(false, Assignment2.sameTurn(6));
        assertEquals(true, Assignment2.outOfBoard(169));
        assertNotEquals(false, Assignment2.outOfBoard(169));
        assertEquals(true, Assignment2.isWinner(100));
        assertNotEquals(false, Assignment2.isWinner(100));
    }
}
