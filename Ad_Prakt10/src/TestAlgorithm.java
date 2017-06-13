import static org.junit.Assert.*;

import org.junit.Test;

public class TestAlgorithm {
	
	@Test
	public void testRSA() {
		RSA rsa = new RSA();
		rsa.createKeys();
		String msg = "test";
		long[] msgKrypt = rsa.chiffre(msg);
		assertTrue((long) msg.charAt(0) != msgKrypt[0]);
		String msgEnkrypt = rsa.dechiffre(msgKrypt);
		System.out.println(msgEnkrypt);
		assertEquals(msg, msgEnkrypt);
	}
	
	@Test
	public void testBlockChiffrier() {
		String msg = "test";
		BlockChiffrier bc=new BlockChiffrier(msg);
		int[] msgKrypt = bc.verschluesseln();
		assertTrue((long) msg.charAt(0) != msgKrypt[0]);
		String msgEnkrypt = bc.entschluesseln(msgKrypt);
		System.out.println(msgEnkrypt);
		assertEquals(msg, msgEnkrypt);
	}

}
