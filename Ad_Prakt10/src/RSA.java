import java.math.BigInteger;

import org.apache.commons.math3.primes.Primes;

public class RSA {
	
	private int d;
	private int e;
	private int hauptmodul;
	private int nebenmodul;
	
	public long[] chiffre(String msg) {
		long[] msgArray = new long[msg.length()];
		for (int i = 0; i < msg.length(); i++) {
			msgArray[i] = BigInteger.valueOf(msg.charAt(i)).pow(e).mod(BigInteger.valueOf(hauptmodul)).longValue();
		}
		return msgArray;
	}
	
	public String dechiffre(long[] msg) {
		char[] msgArray = new char[msg.length];
		for (int i = 0; i < msg.length; i++) {
			msgArray[i] = (char) BigInteger.valueOf(msg[i]).pow(d).mod(BigInteger.valueOf(hauptmodul)).longValue();
		}
		return String.copyValueOf(msgArray);
	}
	
	public void createKeys() {
		int p = getPrime();
		int q;
		while ((q = getPrime()) == p);
		hauptmodul = p * q;
		nebenmodul = (p - 1) * (q - 1);
		do {
			e=(int)(Math.random()*nebenmodul/2);
			while(getKgt(e,nebenmodul)!=1){
				e++;
			}
		} while ((d = extendEuclid(e, nebenmodul)) < 1);
		System.out.println("e: " + e + " d: " + d + " N: " + hauptmodul);
	}
	
	public int getPublicKey() {
		return e;
	}
	
	public int getHauptmodul() {
		return hauptmodul;
	}
	
	public void setPublicKey(int e) {
		this.e = e;
	}
	
	public void setHauptmodul(int hauptmodul) {
		this.hauptmodul = hauptmodul;
	}
	
	/*
	 * @return Primzahl zwischen 100 und 500
	 */
	private int getPrime() {
		return Primes.nextPrime((int) (Math.random() * 400 + 102));
	}
	
	private int getKgt(int a, int b) {
		//while (euclid(a, b) != 1) b++;
		//return b;
		int tmp;
		
		do{
			if (b>a){
				tmp=b;
				b=a;
				a=tmp;
			}
			a=a%b;

		}while(a!=0);
		return b;
	}
	
	private long powMod (long a, int b, int mod)
	{
		long result = 1;
		for (int i = 1; i <= b; i++) {
		   result *= a;
		   result %= mod;
		}
		return result;
	}
	
	private int extendEuclid(int a, int b)
    {
        int x = 0, y = 1, lastx = 1, lasty = 0, temp;
        while (b != 0)
        {
            int q = a / b;
            int r = a % b;
            a = b;
            b = r;
            temp = x;
            x = lastx - q * x;
            lastx = temp;
            temp = y;
            y = lasty - q * y;
            lasty = temp;            
        }
        return lastx;
    }

}
