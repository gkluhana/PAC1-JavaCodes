import java.util.Scanner;
public class TestSmallInt{

	public static void main(String[] args){
	
		System.out.println("Input a number between 0 and "+GkSmallInt.MAXVALUE+" inclusive");
		Scanner sc = new Scanner(System.in);
		int userinput = sc.nextInt();
		
		GkSmallInt number= new GkSmallInt(userinput);
		
		String numberAsString = number.getDec ();
		System.out.println ("Decimal Representation is\t:"+numberAsString);
		
		String bin = number.getBin ();
		System.out.println ("Binary Representation is\t:"+bin);
		
		String hex = number.getHex ();
		System.out.println ("Hexadecimal Representation is\t:"+hex);
		System.out.println("dummy value is"+GkSmallInt.dummy);

		//Same Value Implementation
		boolean check = number.sameValue(bin,hex.substring(2));
		System.out.println(check);
		check = GkSmallInt.sameValue("101","6");
		System.out.println(check);
		
	}

}