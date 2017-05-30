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
    
    @Test
    public void testkomplexit�t() {
    	int size = 2000;
    	int value;
    	int r = 0;
    	int l = 0;
    	ArrayBinaerSuchbaum<Integer> test = new ArrayBinaerSuchbaum<Integer>();
    	LinkedBinaersuchbaum<Integer> test2 = new LinkedBinaersuchbaum<Integer>();
    	for (int i = 0; i < size; i++) {
    		value = (int) (Math.random() * size);
    		if (i == 0) r = value;
    		if (i == 1) l = value;
    		test.knotenEinf�gen(value);
    		test2.knotenEinf�gen(value);
    	}
    	if (l > r) {
    		int tmp = r;
    		r = l;
    		l = tmp;
    	}
    	System.out.println(test.summe(l, r));
    	System.out.println(test2.summe(l, r));
    }

}