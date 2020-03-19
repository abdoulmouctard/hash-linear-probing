package fr.upec.app;

import static org.junit.Assert.assertEquals;

import org.junit.*;

/**
 * Unit test for simple App.
 * 
 * @author Abdoul Mouctar DIALLO
 */
public class AppTest {
    private HashLinearProbing hasher;

    @Before
    public void initialize() {
        this.hasher = new HashLinearProbing();
    }

    @Test
    public void testPutAndGetMethods() {
        this.hasher.put("A", "A");
        this.hasher.put("B", "B");
        this.hasher.put("C", "C");

        assertEquals("A", this.hasher.get("A"));
        assertEquals("B", this.hasher.get("B"));
        assertEquals("C", this.hasher.get("C"));
    }

    @Test
    public void testRemoveMethod() {
        this.hasher.put("A", "A");
        this.hasher.put("A", "AA");
        this.hasher.put("B", "B");

        assertEquals("A", this.hasher.get("A"));

        hasher.remove("A");
        assertEquals("AA", this.hasher.get("A"));

        hasher.remove("A");
        assertEquals(null, this.hasher.get("A"));

        hasher.remove("B");
        assertEquals(null, this.hasher.get("B"));

    }

}
