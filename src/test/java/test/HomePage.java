package test;

public class HomePage {

	public static void main(String[] args) {

		HomePage d = new HomePage();
		int result = d.subtractNumbers(10, 4);
		System.out.println(result);  // Output: 6
	}
   	
	  public int subtractNumbers(int a, int b) {
	        return a - b;
	    }

}
