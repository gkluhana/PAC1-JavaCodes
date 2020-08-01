import java.util.Scanner;
public class gkCarOop{
	public static void main(String [] args){
		car[] mycars = new car[10];

		//Initialize all my Cars

		for(int n=0;n<mycars.length;n++){
			mycars[n]= new car();
		}

		//First Menu, Car Selection

		String userinput;
		userinput="init";
		System.out.println("Select a Car [1-10]");
		Scanner sc=new Scanner(System.in);
		int c=sc.nextInt();

		//Set Current Car
		car currentCar=mycars[c-1];
		
		nextDisplay();

		//Main Program Loop
		while(!userinput.equals("x")){

			//Display Car State
			System.out.printf("Car Number:\t%d \n",c);
			System.out.println(currentCar.toString());

			//Generate Grid and Car
			generateGrid(currentCar);
				
			
			//Main User Menu
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
			else{
				switch(userinput){
					
					//Change Ignition
					case("i"):
						nextDisplay();
						currentCar.ignitionSwitch();
						break;	
			 		
			 		//Move Car
			 		case("m"):
						//Car is Off

						if(currentCar.getIgnition()==false){
							nextDisplay();
							System.out.println("Are you planning to push the car with your hands?"+
							"\nTurn it on first!\n");
						}

						//Car is On
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
										currentCar.moveHorizontal(distance);
										break;
									case("v"):
										nextDisplay();
										currentCar.moveVertical(distance);
										break;
								}
							}
						}
						break;

					//Change Cars
					case("c"):
						System.out.println("Which car do you want?[1-10]?");
						c=sc.nextInt();
						currentCar=mycars[c-1];
						nextDisplay();		
						break;

					//Exit Program
					case("x"):
						System.out.println("\nYou are going already? Aw man.");
						break;
				}
			}
		}	
	}

	//NextDisplay Method- Formats the Display
	public static void nextDisplay(){
		
		for(int i=1;i<=20;i++){
			System.out.print("=");
		}
		for(int i=1;i<=20;i++){
			System.out.println("");
		}
	}

	//Grid Print Method
	public static void generateGrid(car currentCar){
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
						if(currentCar.getX()==j&&currentCar.getY()==i)
						System.out.print(" "+currentCar.color+" ");
						else
						System.out.print(" - ");
					}			
				System.out.println("");
				}
	}

}

//Class
class car{
	
	 private int xPosition;
	 private int yPosition;
	 private boolean ignitionState;
	 public final char color;

	//Constructor
	public car(){
		this.xPosition=randPosition();
		this.yPosition=randPosition();
		this.color=randomColor();

	}

	//Getters for Car States
	public int getX(){
		return this.xPosition;
	}
	public int getY(){
		return this.yPosition;
	}

	public String getColor(){
		String color="";
		switch(this.color){
		
			case('R'): color="Red";		break;
			case('G'): color="Green";	break;
			case('B'): color="Black";	break;
			case('W'): color="White";	break;
			case('S'): color="Silver";	break;
		}
		return color;
	}

	public boolean getIgnition(){
		return this.ignitionState;
	}
	
	//Move Car in X Direction
	public void moveHorizontal(int distance){
		if((this.xPosition+distance)>20||this.xPosition+distance<1){
			System.out.println("Dude! You wanna drive us off the edge of the world? Really? No. Try Again.\n");
		}
		else{
			this.xPosition=this.xPosition+distance;
		}

	}

	//Move Car in Y Direction
	public void moveVertical(int distance){
		if((this.yPosition+distance)>20||(this.yPosition+distance)<1){
			System.out.println("Dude! You wanna drive us off the edge of the world? Really? No. Try Again.\n");
		}
		else {
			this.yPosition=this.yPosition+distance;
		}
	}
	
	//Ignition Switch Method	
	public void ignitionSwitch(){
		this.ignitionState = !this.ignitionState;
		if(this.ignitionState==true){ 
			System.out.println("VRRROOOOOOOMMM\n"+
					"Alright! Let's get moving!\n");
		}
		else{
			System.out.println("I suppose we are taking a break. Okay.\n");
		}
	}

	//Initial Position Method
	private int randPosition(){
		int random = (int)(Math.random() * 20 + 1);
		return random;
	}

	//Assign Color Method
	private char randomColor(){
		char clr='i';
		int randomNumber=(int)(Math.random() * 5 + 1);
		switch(randomNumber){
			case(1): clr='R'; break;
			case(2): clr='G'; break;
			case(3): clr='B'; break;
			case(4): clr='W'; break;
			case(5): clr='S'; break;
		}
		return clr;
	}

	//toString
	public String toString(){
		String ig,color="init";
		if(this.ignitionState==true)
			ig="On";
		else 
			ig="Off";

		String state = "Car Color:\t"+this.getColor()+
						"\nIgnition:\t"+ig+
						"\nPosition:\t("+this.xPosition+","+this.yPosition+")";
		return state;

	}

}