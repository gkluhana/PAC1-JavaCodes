import java.util.Scanner;
public class classex1 {
	public static void main(String args [] ) {
		
		//collect and store data 
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter first string");
		String string1=sc.next();
		
		System.out.println("Enter second string");
		String string2=sc.next();

		System.out.println("First String"+string1);
		System.out.println("Second String"+string2);
	}
}