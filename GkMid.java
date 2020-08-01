import java.util.Scanner;
public class GkMid{
	public static void main(String [] args){
		//Demonstrate Possible Conversions
		/*
		byte b =1 ;
		short s =2;
		int i =3;
		long l =4;

		float f =5;
		double d =6;
		System.out.println(""+b+"\n"+s+"\n"+i+"\n"+l+"\n"+f+"\n"+d);
		
		System.out.println(""+d);
		d=f;
		System.out.println(""+f);
		f=l;
		System.out.println(""+f);
		l=i;
		System.out.println(""+f);
		f=s;
		System.out.println(""+f);
		f=b;
		System.out.println(""+f);
		*/

		//Demonstrate primitive type modification vs object reference modification
		/*
		int a= 1;
		int b= a;
		a=b;
		System.out.println(""+a+b);
		b=3;
		System.out.println(""+a+b);

		int[] a1 = new int[1];
		a1[0] = 1;
		int[] b1 = a1;
		System.out.println(""+a1[0]+b1[0]);
		b1[0] = 2;
		System.out.println(""+a1[0]+b1[0]);
		
		int[] a2 = new int[1];
		a2[0] = 1;
		int[] b2 = new int[1];
		
		System.out.println(""+a2[0]+b2[0]);
		b2[0]=a2[0];
		System.out.println(""+a2[0]+b2[0]);
		b2[0]=2;
		System.out.println(""+a2[0]+b2[0]);
		b2 = a2;
		b2[0] = 3;
		System.out.println(""+a2[0]+b2[0]);
		*/
		//Demonstrate Operators
		/*
		byte b =(byte)(127+1) ;
		short s =2;
		int i =3;
		long l =4;

		float f =5;
		double d =6;
		d= d+f;
		System.out.println(b);
		d=i+s;
		System.out.println(d);
		i=b%s;
		System.out.println(i);
		i=5%2;
		System.out.println(i);
		f=5.0f;
		System.out.println(f);
		*/
		
		//FLoating points are imprecise
		/*d=1.0/2;
		System .out.println(d);
		d=1-0.1-0.1-0.1-0.1-0.1;
		System .out.println(d);
		*/

		//5.0 is consided double, float f=5.0 will return an error
		// 1 is int but byte b = 1 is fine though



		//Demonstrate Casting
		/*
		byte b =1 ;
		short s =2;
		int i =3;
		long l =4;

		float f =5;
		double d =6;
		System.out.println(""+b+"\n"+s+"\n"+i+"\n"+l+"\n"+f+"\n"+d);
		*/
		//Stacks: methods pushed onto stacks

		//&& and oeprator, || or, ^ exclusive or

		// & and | oeprators will check both conditions, && and || may not if one is sufficient
		/*int x=1;
		boolean a=(1==x)||(10>x++);
		System.out.println(x);
		*/

		//Demonstrate break in cases
		/*
		int a= 5;
		switch(a){
			case 5:
			
			case 2:
			a=6;
		}
		System.out.println(a);
		*/

		//Conditional Operators ? 
		/*
		byte x=24;
		int y=2;
		System.out.println((x<y)?"x is smaller":"nope");
		*/

		//Unary operators, compound operators, fucking weird stuff
		/*
		int x=127;
		x=((byte)++x);
		System.out.println(x);
		int y = (byte)128;
		System.out.println(y);
		
		x=127;
		x-=(byte)x++;
		System.out.println(x);
		
		x=127;
		x-=(byte)(x++);
		System.out.println(x);
		x=127;
		x-=(byte)(x);
		System.out.println(x);
		
		x=127;
		x+=(byte)++x;
		System.out.println(x);
		
		x=127;
		++x;
		System.out.println(x);
		x-=x;
		System.out.println(x);
		
		x=127;
		x-=++x;
		System.out.println(x);
		x=127;
		x-=x++;
		System.out.println(x);
		*/

		//Math class
		/*int x=10;
		x=(int)Math.pow(x,2);
		System.out.println(x);
		*/

		//Characters, more weird fucking stuff
		/*Character c=new Character('a');
		char e=65535;
		char f='\uffff';
		char g=0;
		int d= c;
		boolean isLetter('c');		
		System.out.println(""+c+d+"\""+g);
		*/

		//Strings and Scanners
		/*
		String s="         I am tired of this        ";
		System.out.println(s);
		System.out.println(s.trim());
		*/
		/*
		//Scanners
		Scanner myInputs= new Scanner(System.in);
		String input1 = myInputs.next();
		int input3 = myInputs.nextInt();
		String input2 = myInputs.nextLine();

		System.out.println(input1+input2+input3);
		System.out.println(input1.indexOf("sdf"));
		*/
		//More Strings
		/*String s = "59";
		int i= 2;
		double i2=Double.parseDouble(s);
		System.out.println(i2);
		System.out.printf("The String %s converted to dobule is %e and that, my friend is %b\n",s,i2,true);
		*/

		//Returning Arrays
		/*int[] ia = new int[10];
		int i;
		char[] ca = new char[10];
		char c;
		String s;
		System.out.println(ia[0]);
		int[] ib=changevalue(ia);
		System.out.println(ia[0]);
		

		String[] sa= new String[10];
		*/
		//System.out.println(args[1]);

		//Boolean array test
		boolean[] b = new boolean[10];
		System.out.println(b[10]);

	}

	public static int[] changevalue(int i []){
		return i;

	}
}