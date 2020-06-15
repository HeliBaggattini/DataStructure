/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetClasses;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void addTest() {
        System.out.println("add");

        SimpleSet s = new SimpleSet();
        assertEquals(s.toString(), "[]");

        s.add("C");
        assertEquals(s.toString(), "[C]");

        s.add("A");
        assertEquals(s.toString(), "[A, C]");

        s.add("B");
        assertEquals(s.toString(), "[A, B, C]");
    }

    @Test
    public void sizeTest() {
        System.out.println("size");

        SimpleSet s = new SimpleSet();
        assertEquals(s.size(), 0);

        s.add("C");
        assertEquals(s.size(), 1);

        s.add("A");
        s.add("B");
        s.remove("C");
        assertEquals(s.size(), 2);
    }
    
    @Test
    public void containsTest() {
        System.out.println("contains");

        SimpleSet s = new SimpleSet();
        s.add("A");
        s.add("B");
        s.add("C");
        assertTrue(s.contains("B"));
        assertFalse(s.contains("X"));
    }
}


