import java.util.Scanner;
public class gkCalc {
	public static void main(String args [] ) {
		
		//declaring variables
		double num1, num2;
		String op;

		//First Input
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter First operand  ");
		num1=sc.nextDouble();


		op="init"; //dummy value for operator

		//Main Calculator Loop
		

		while(!op.equals("x")){
			//Operator Input	
			
			System.out.print("\nEnter operator (+ - * /)  ");
			op=sc.next();

			//Valid Operator
			if(op.equals("+")||op.equals("-")||op.equals("*")||op.equals("/")) {
				//Second Input	
				System.out.print("\nEnter second operand  ");
				num2=sc.nextDouble();
				
				//Calculation of First Input (op) Second Input
				switch(op){
					case "+":
					num1=num1+num2;
					System.out.println(num1);
					break;

					case "-":
					num1=num1-num2;
					System.out.println(num1);
					break;

					case "*":
					num1=num1*num2;
					System.out.println(num1);
					break;

					case "/":
					//Check for Division by Zero
					if (num2==0){
						System.out.println("\nPlease don't try to break Math, we insist."+
							"\nLet's try again, shall we?\n\n"+num1);
						break;
					}
					//Valid Division
					else {
					num1=num1/num2;
					System.out.println(num1);
					break;
					}

				}
			}
			//Special Operators

			else if (op.equals("x")){
				System.out.println("\nIt was nice being your arithmetic slave for a while. Bye\n");
				break;
				}
			
			else if (op.equals("c")){
				num1=0;	
				System.out.println("\nMemory Cleared\n\n"+num1);
				}
			//Illegal Operator
			else {
				System.out.println("\nIllegal operator please try again");
				}
			}		
		}
	}
