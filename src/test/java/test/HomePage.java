package test;

public class HomePage {

	public static void main(String[] args) {

		HomePage d = new HomePage();
		int result = d.subtractNumbers(10, 4);
		System.out.println(result);  // Output: 6
	       int a = 5;
	        int b = 4;

	        int result2 = a * b;

	        System.out.println("Multiplication: " + result);
	    
	}
   	
	  public int subtractNumbers(int a, int b) {
	        return a - b;
	    }

}
