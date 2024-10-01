/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vieropeenrij;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vieropeenrij.VierOpEenRij.FILL;

/**
 *
 * @author krisluyten
 */
public class VorMatrixTest {

    public VorMatrixTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of reset method, of class VorMatrix.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        VorMatrix instance = new VorMatrix();
        instance.reset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dropItem method, of class VorMatrix.
     */
    @Test
    public void testDropItem() throws Exception {
        System.out.println("dropItem");
        FILL color = null;
        int column = 0;
        VorMatrix instance = new VorMatrix();
        instance.dropItem(color, column);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFill method, of class VorMatrix.
     */
    @Test
    public void testGetFill() {
        System.out.println("getFill");
        int column = 0;
        int row = 0;
        VorMatrix instance = new VorMatrix();
        FILL expResult = null;
        FILL result = instance.getFill(column, row);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fourAdjacent method, of class VorMatrix.
     */
    @Test
    public void testFourAdjacent() {
        System.out.println("fourAdjacent");
        FILL color = null;
        VorMatrix instance = new VorMatrix();
        boolean expResult = false;
        boolean result = instance.fourAdjacent(color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}