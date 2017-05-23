package aufgabe7;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuchbaumTest
{
    
    @Test
    public void testSummeVonHeap()
    {
        LinkedBinaersuchbaum<Integer> test = new LinkedBinaersuchbaum<Integer>();
        test.knotenEinfügen(32);
        test.knotenEinfügen(20);
        test.knotenEinfügen(36);
        test.knotenEinfügen(40);
        test.knotenEinfügen(15);
        test.knotenEinfügen(22);
        test.knotenEinfügen(12);
        test.knotenEinfügen(17);
        
        assertEquals(59, test.summe(16, 23));
    }
    
    @Test
    public void testSummeVonArray()
    {
        ArrayBinaerSuchbaum<Integer> test = new ArrayBinaerSuchbaum<Integer>();
        test.knotenEinfügen(32);
        test.knotenEinfügen(20);
        test.knotenEinfügen(36);
        test.knotenEinfügen(40);
        test.knotenEinfügen(15);
        test.knotenEinfügen(22);
        test.knotenEinfügen(12);
        test.knotenEinfügen(17);
        
        assertEquals(59, test.summe(16, 23));
    }

}