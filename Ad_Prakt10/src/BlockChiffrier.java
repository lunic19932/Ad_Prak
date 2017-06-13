
public class BlockChiffrier {

	String string;
	public BlockChiffrier(String string ) {
		this.string=string;
	}
	
	public void setString(String string) {
		this.string = string;
	}
	
	public int[] verschluesseln(){
		char[] charArray=string.toCharArray();
		int[] intClearArray=new int[charArray.length];
		for(int i=0;i<charArray.length;i++){
			intClearArray[i]=(int)charArray[i]-32;
		}
		
		int[] intKryptArray=new int[charArray.length+8];;
		intKryptArray[0]=(int)(Math.random()*95);
		intKryptArray[1]=(int)(Math.random()*95);
		for(int i=0;i<intClearArray.length;i+=2){
			intKryptArray[i+8]=intClearArray[i]+intKryptArray[0]%95;
			intKryptArray[i+1+8]=intClearArray[i+1]+intKryptArray[1]%95;
		}
		return intKryptArray;
	}
	
	public String entschluesseln(int[] intKryptArray){
		int[] intClearArray=new int[intKryptArray.length-8];
		char[] intCharArray=new char[intClearArray.length];
		for(int i=0;i<intClearArray.length;i+=2){
			intClearArray[i]=intKryptArray[i+8]-intKryptArray[0]+32;
			intClearArray[i+1]=intKryptArray[i+8+1]-intKryptArray[1]+32;
		}
		for(int i=0;i<intClearArray.length;i++){
			intCharArray[i]=(char)intClearArray[i];
		}
		return String.valueOf(intCharArray);
	}
	
	public static void main(String[] args) {
		BlockChiffrier bc=new BlockChiffrier("Hallo Welt");
		int[] verschl=bc.verschluesseln();
		String entschl=bc.entschluesseln(verschl);
		for(int i=0;i<verschl.length;i++){
			System.out.println(verschl[i]);
		}
		System.out.print(entschl);
	}
	
}
