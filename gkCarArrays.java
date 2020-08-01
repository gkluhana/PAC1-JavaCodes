import java.util.Scanner;

public class gkCarArrays {
	public static void main(String [] args) {
	/*nextDisplay();*/
	//Initializing Variables for 10 cars

	int[] xPosition[10];
	/*char clr;	
	boolean ignition = false;
	String userinput;

	xPosition = randPosition();
	yPosition = randPosition();

	clr=randomColor();

	userinput="init";

	//Main Program
		while(!userinput.equals("x")){
			//Display Car State
			reportstate(xPosition,yPosition,ignition,clr);

			//Generate Grid and Car
			
				
			for(int i=1;i<=20;i++){
				//X title
				if(i==1){
					System.out.print("\t ");	
					for(int j=1;j<10;j++){
						System.out.print(" "+j+" ");
					}
					for(int j=10;j<=20;j++){
						System.out.print(j+" ");
					}
					System.out.print("\n");
				}
				//Y title
				System.out.print(i+"\t|");
				//Grid Points
				for(int j=1;j<=20;j++){
					if(xPosition==j&&yPosition==i)
					System.out.print(" "+clr+" ");
					else
					System.out.print(" - ");
				}			
			System.out.println("");
			}
			
			//User Menu and Input
			System.out.println("What is your command?"+
								"\n\tSwitch Ignition\t[i]"+
								"\n\tMove Car\t[m]"+
								"\n\tExit Program\t[x]");
			
			Scanner sc=new Scanner(System.in);
			userinput=sc.next();
			//Illegal Input
			if(!userinput.equals("x")&&!userinput.equals("i")&&!userinput.equals("m")){ 
				nextDisplay();
				System.out.println("Invalid input, please try again\n");
			}
			//Valid Input
			else
				switch(userinput){
					//Change Ignition
					case("i"):
					nextDisplay();
					ignition=ignitionswitch(ignition);
					break;	
			 		//Move Car
			 		case("m"):
					if(ignition==false){
						nextDisplay();
						System.out.println("Are you planning to push the car with your hands?"+
							"\nTurn it on first!\n");
					}
					else{
						//Ask Direction
						System.out.println("Which Direction would you like to move the car?"+
							"\nHorizontal\t[h]"+
							"\nVertical\t[v]");
						String direction=sc.next();
						//Invalid Inpit
						if(!direction.equals("h")&&!direction.equals("v")){
							nextDisplay(); 
							System.out.println("\n\nInvalid input, please try again\n");
						}
						//Valid Input
						else{	
							System.out.println("How far do you wanna go?");
							int distance=sc.nextInt();
							switch(direction){
								case("h"):
								nextDisplay();
								xPosition=moveX(xPosition,distance,ignition);
								break;
								case("v"):
								nextDisplay();
								yPosition=moveY(yPosition,distance,ignition);
								break;
							}
						}
					}
					break;
					//Exit Program
					case("x"):
					System.out.println("\nYou are going already? Aw man.");
					break;
				}
		}	
		
	}


	//Initial Position Method
	public static int randPosition(){
		int random = (int)(Math.random() * 20 + 1);
		return random;
	}
	//Car Color Method
	public static char randomColor(){
		char clr='i';
		int randomNumber=(int)(Math.random() * 5 + 1);
		switch(randomNumber){
			case(1):
			 clr='R';
			break;
			case(2):
			 clr='G';
			break;
			case(3):
			 clr='B';
			break;
			case(4):
			 clr='W';
			break;
			case(5):
			 clr='S';
			break;
		}
		return clr;
	}
	//Ignition Switch Method
	public static boolean ignitionswitch(boolean ignition){
		ignition = !ignition;
		if(ignition==true){
			System.out.println("VRRROOOOOOOMMM\n"+
					"Alright! Let's get moving!\n");
		}
		else{
			System.out.println("I suppose we are taking a break. Okay.\n");
		}

		return ignition;
	}
	//Move Car in X Direction
	public static int moveX(int xPosition,int distance,boolean ignition){
		if((xPosition+distance)>20||xPosition+distance<1){
			System.out.println("Dude! You wanna drive us off the edge of the world? Really? No. Try Again.\n");
		}
		else{
			xPosition=xPosition+distance;
		}
		return xPosition;

	}
	//Move Car in Y Direction
	public static int moveY(int yPosition,int distance,boolean ignition){
		if((yPosition+distance)>20||(yPosition+distance)<1){
			System.out.println("Dude! You wanna drive us off the edge of the world? Really? No. Try Again.\n");
		}
		else {
			yPosition=yPosition+distance;
		}
		return yPosition;

	}
	//Display Car State Method
	public static void reportstate(int x,int y, boolean ignition,char clr){
		String ig,color="init";
		if(ignition==true)
			ig="On";
		else 
			ig="Off";
		switch(clr){
		
			case('R'):
			color="Red";
			break;
			case('G'):
			color="Green";
			break;
			case('B'):
			color="Black";
			break;
			case('W'):
			color="White";
			break;
			case('S'):
			color="Silver";
			break;
		}
		System.out.println("Car Color:\t"+color);
		System.out.println("Ignition:\t"+ig);
		System.out.println("Position:\t"+"("+x+","+y+")");
	}
	//Display formatting
	public static void nextDisplay(){
		for(int i=1;i<=20;i++){
			System.out.print("=");
		}
		for(int i=1;i<=20;i++){
			System.out.println("");
		
		}*/
	}

}

