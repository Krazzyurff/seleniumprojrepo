package test;

public class HomePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HomePage d = new HomePage();
		int result = d.addTwoNumbers(5, 10);
		System.out.println(result);  // Output: 15
     
	}
   	
	  public int addTwoNumbers(int a, int b) {
	        return a + b;
	    }
}
