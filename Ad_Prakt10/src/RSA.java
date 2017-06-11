import java.security.ProtectionDomain;

public class RSA {

	public static final int[] primzahlenArray= {101, 103, 107, 109, 113,
							127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
							179, 181, 191, 193, 197, 199,211, 223, 227, 229,
							233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
							283, 293,307, 311, 313, 317, 331, 337, 347, 349, 
							353, 359, 367, 373, 379, 383, 389, 397, 401, 409,
							419, 421, 431, 433, 439, 443, 449, 457, 461, 463,
							467, 479, 487, 491, 499};
	
	
	private int e;
	private int d;
	
	public RSA(){
		int p=primzahlenArray[(int)(Math.random()*primzahlenArray.length)];
		int q=primzahlenArray[(int)(Math.random()*primzahlenArray.length)];
		while(p==q){
			q=primzahlenArray[(int)(Math.random()*primzahlenArray.length)];
		}
		int N=p*q;
		int phiN=(p-1)*(q-1);
		e=(int)(Math.random()*phiN/2);
		while(ggT(e,phiN)!=1){
			e++;
		}
		
		d=(int)(Math.random()*N/2);
		int product;
		do{
			d++;
			product=e*d;
		}while(product%N!=1);
		
		System.out.println("e="+e+" d="+d);
	}
	public static void main(String[] args) {
		RSA rsa=new RSA();
	}
	
	public int ggT(int zahl1,int zahl2){

		int tmp;
		
		do{
			if (zahl2>zahl1){
				tmp=zahl2;
				zahl2=zahl1;
				zahl1=tmp;
			}
			zahl1=zahl1%zahl2;

		}while(zahl1!=0);
		return zahl2;
	}
}
