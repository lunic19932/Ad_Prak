
public class Hybrid {
	
	private BlockChiffrier bc;
	private RSA rsa;
	
	public Hybrid() {
		bc = new BlockChiffrier("");
		rsa = new RSA();
	}
	
	public int[] chiffre(String msg) {
		bc.setString(msg);
		int[] result = bc.verschluesseln();
		char[] tmpArray = {(char) result[0], (char) result[1]};
		String tmpString = String.valueOf(tmpArray);
		rsa.createKeys();
		long[] krypSK = rsa.chiffre(tmpString);
		split(0, (int) krypSK[0], result);
		split(4, (int) krypSK[1], result);
		//result[0] = (int) krypSK[0];
		//result[1] = (int) krypSK[1];
		return result;
	}
	
	public String dechiffre(int[] msg) {
		unSplit(0, 0,msg);
		unSplit(4, 1,msg);
		long[] tmpArray = {(long) msg[0], (long) msg[1]};
		String tmpString = rsa.dechiffre(tmpArray);
		msg[0] = tmpString.charAt(0);
		msg[1] = tmpString.charAt(1);
		return bc.entschluesseln(msg);
	}
	
	private void split(int startIndex, int value, int[] msg) {
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				msg[startIndex] = (int) (value / Math.pow(95, 3 - i));
			} else {
				msg[i + startIndex] = (int) ((value % Math.pow(95, 4 - i)) / Math.pow(95, 3 - i));
			}
		}
	}
	
	private void unSplit(int startIndex, int index, int[] msg) {
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				msg[index] = (int) (msg[startIndex] * Math.pow(95, 3 - i));
			} else {
				msg[index] += (int) (msg[i + startIndex] * Math.pow(95, 3 - i));
			}
		}
	}

}
