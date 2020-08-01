import java.util.Scanner;

public class gkCarA {
	public static void main(String [] args) {
	
	//Initializing Variables for 10 cars
	
	int NUMBEROFCARS=10;
	int[] xPosition=new int[NUMBEROFCARS];
	int[] yPosition=new int[NUMBEROFCARS];
	char[] clr=new char[NUMBEROFCARS];
	boolean[] ignition = new boolean[NUMBEROFCARS];
	for(int i=0;i<NUMBEROFCARS;i++){
		xPosition[i] = randPosition();
		yPosition[i] = randPosition();
		clr[i]= randomColor(); 
		ignition[i]=false;
		}
		;
	 
	String userinput;
	userinput="init";
	System.out.println("Select a Car [1-10]");
	Scanner sc=new Scanner(System.in);
	int c=sc.nextInt();
	nextDisplay();
	//Main Program
		while(!userinput.equals("x")){
			//Display Car State
			reportstate(xPosition[c-1],yPosition[c-1],ignition[c-1],clr[c-1],c);

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
					if(xPosition[c-1]==j&&yPosition[c-1]==i)
					System.out.print(" "+clr[c-1]+" ");
					else
					System.out.print(" - ");
				}			
			System.out.println("");
			}
			
			//User Menu and Input
			System.out.println("What is your command?"+
								"\n\tChange Car\t[c]"+
								"\n\tSwitch Ignition\t[i]"+
								"\n\tMove Car\t[m]"+
								"\n\tExit Program\t[x]");
			
			userinput=sc.next();
			//Illegal Input
			if(!userinput.equals("x")&&!userinput.equals("i")&&!userinput.equals("m")&&!userinput.equals("c")){ 
				nextDisplay();
				System.out.println("Invalid input, please try again\n");
			}
			//Valid Input
			else
				switch(userinput){
					//Change Ignition
					case("i"):
					nextDisplay();
					ignition[c-1]=ignitionswitch(ignition[c-1]);
					break;	
			 		//Move Car
			 		case("m"):
					if(ignition[c-1]==false){
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
								xPosition[c-1]=moveX(xPosition[c-1],distance,ignition[c-1]);
								break;
								case("v"):
								nextDisplay();
								yPosition[c-1]=moveY(yPosition[c-1],distance,ignition[c-1]);
								break;
							}
						}
					}
					break;
					case("c"):
					System.out.println("Which car do you want?[1-10]?");
						c=sc.nextInt();
						nextDisplay();		
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
	public static void reportstate(int x,int y, boolean ignition,char clr,int c){
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
		System.out.println("Car Number:\t"+c);
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
		
		}
	}
}

