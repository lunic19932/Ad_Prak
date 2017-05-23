package aufgabe7;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuchbaumTest
{
    
    @Test
    public void testSummeVonHeap()
    {
        LinkedBinaersuchbaum<Integer> test = new LinkedBinaersuchbaum<Integer>();
        test.knotenEinf�gen(32);
        test.knotenEinf�gen(20);
        test.knotenEinf�gen(36);
        test.knotenEinf�gen(40);
        test.knotenEinf�gen(15);
        test.knotenEinf�gen(22);
        test.knotenEinf�gen(12);
        test.knotenEinf�gen(17);
        
        assertEquals(59, test.summe(16, 23));
    }
    
    @Test
    public void testSummeVonArray()
    {
        ArrayBinaerSuchbaum<Integer> test = new ArrayBinaerSuchbaum<Integer>();
        test.knotenEinf�gen(32);
        test.knotenEinf�gen(20);
        test.knotenEinf�gen(36);
        test.knotenEinf�gen(40);
        test.knotenEinf�gen(15);
        test.knotenEinf�gen(22);
        test.knotenEinf�gen(12);
        test.knotenEinf�gen(17);
        
        assertEquals(59, test.summe(16, 23));
    }

}