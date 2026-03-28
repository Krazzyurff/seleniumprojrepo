package test;

public class HomePage {

	public static void main(String[] args) {

		// TODO Auto-generated method stub


   System.out.println("Ashish");

     System.out.println("hero");
     System.out.println("Don");
     System.out.println("Don");
     System.out.println("Don");
     System.out.println("Don");
     System.out.println("Ashish");

		HomePage d = new HomePage();
		int result = d.subtractNumbers(10, 4);
		System.out.println(result);
		HomePage b = new HomePage();
		int result1 = b.addTwoNumbers(5, 10);
		System.out.println(result1); 
		System.out.println(result);  // Output: 6
	       int a = 5;
	        int c = 4;

	        int result2 = a * c;

	        System.out.println("Multiplication: " + result);
	}
	  public int subtractNumbers(int a, int b) {
	        return a - b;
	    }

	  public int addTwoNumbers(int a, int b) {
	        return a + b;
	    }

}
