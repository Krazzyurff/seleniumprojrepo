package test;

public class HomePage {
	public static void main(String[] args) {

		

		HomePage d = new HomePage();
		int result = d.subtractNumbers(10, 4);
		System.out.println(result);
		HomePage b = new HomePage();
		int result1 = b.addTwoNumbers(5, 10);
		System.out.println(result1); 
		HomePage c = new HomePage();
		int result3 = d.subtractNumbers(10, 4);
		
	}
	  public int subtractNumbers(int a, int b) {
	        return a - b;
	    }

	  public int addTwoNumbers(int a, int b) {
	        return a + b;
	    }
	  

}
