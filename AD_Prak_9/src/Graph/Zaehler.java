package Graph;

public class Zaehler {
	
		private static long opCount = 0;
		private static boolean count=true;
		public static long getOpCount() {
			return opCount;
		}

		public  static void count() {
			if(count){
				opCount++;
			}
		}
		
		public static void countOn(){
			count=true;
		}
		
		public static void countOff(){
			count=false;
		}

		public static void reset() {
			opCount = 0;
		}
	}
