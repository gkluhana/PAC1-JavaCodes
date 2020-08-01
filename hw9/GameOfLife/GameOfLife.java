import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GameOfLife{
	public static void main(String [] args){
		
		//Prompt User for filename
		Scanner gameReader= new Scanner(System.in);
		System.out.println("Enter filename for initial configuration:\t");
		String filename = gameReader.next();
		
		//Catch Exception for incorrect filename
		File file= new File(filename);
		Scanner fileReader= null;

		try { 
		   fileReader = new Scanner (file);
		}

		catch (FileNotFoundException e) {
		   System.out.print("file " + file + " does not exist\n");
		   System.exit(0);
		}

		//Create First Generation Array

		final int M = 25;
		final int N = 75; 
		char[][] oldGeneration= new char[M+2][N+2];

		//Add Ghost Boundary layer
		for(int i=0;i<M+2;i++){
			for(int j=0;j<N+2;j++){
				if(i==0||i==M+1||j==0||j==N+1){
					oldGeneration[i][j]='.';
				}
			}
		}

		//Inner layer using file and Print First Generation
		for (int i = 1; i <= M; i++) {
			String line = fileReader.nextLine();
			for (int j=1; j<=N;j++){
				oldGeneration[i][j]=line.charAt(j-1);
			}
			System.out.println(line);
  		}



		//New Generation Array
		
		char[][] newGeneration= new char[M+2][N+2];
		
		//Add Ghost Boundary layer
		for(int i=0;i<M+2;i++){
			for(int j=0;j<N+2;j++){
				if(i==0||i==M+1||j==0||j==N+1){
					newGeneration[i][j]='.';
				}
			}
		}
		
		//While loop with User Input
		
		String userinput="i";
		while (!userinput.equals("x")){
			
			//Display User Menu
			System.out.println("What do you want to do?"+
							"\nNext Generation:\t[n]"+
							"\nQuit Program:\t\t[x]");
			userinput=gameReader.next();

			//Decide Actions based on User Input
						
			//User inputs Illegal Input
			if(!userinput.equals("n")&&!userinput.equals("x")){
				System.out.println("\nInvalid Input, Try Again\n");
			}

			//User wants next Generation
			else if(userinput.equals("n")){

				//Calculate Neighbours for each cell in inner grid, and insert them as char value in cell
				for (int r=1;r<=M;r++){
					for (int c=1;c<=N;c++){
						newGeneration[r][c]=(char)(neighbours(oldGeneration,r,c)+'0');
					}
				}

				//Convert cells with neighbour valeus to X's or dots using Rules 

				for (int r=1;r<=M;r++){
					for (int c=1;c<=N;c++){

						//Decide X's from Old Generation survive or die

						if(oldGeneration[r][c]=='X'){
							if(newGeneration[r][c]=='2'||newGeneration[r][c]=='3'){
								newGeneration[r][c]='X';
							}
							else{
								newGeneration[r][c]='.';	
							}
						}

						//Decide dots from Old Generation come to life or stay dead
						else{
							if(newGeneration[r][c]=='3'){
								newGeneration[r][c]='X';
							}
							else{
								newGeneration[r][c]='.';	
							}
						}

					}			
				}
				//Print New Generation from array excluding boundary layer
					
		  		for (int i = 1; i <=M; i++){
		  			for(int j=1;j <=N;j++){
		  				System.out.print(newGeneration[i][j]);
		  			}
		  			System.out.println("");
				}
				System.out.println("");

				//Did the World Change?

				boolean stillWorld=true;
				for(int i=1;i<M;i++){
					for (int j=1;j<N;j++){
						if(oldGeneration[i][j]!=newGeneration[i][j]){
						stillWorld=false;
						break;						
						}
					}
				}
				//Print Error Message for Still World
				if(stillWorld){
					System.out.println("The World is Stagnant");
				}

			
				//Make Old Generation New Generation
				for(int i=1;i<M;i++){
					for (int j=1;j<N;j++){
						oldGeneration[i][j]=newGeneration[i][j];
					}
				}

				//Auto Terminate if World Empty or Still
				if(emptyWorld(newGeneration)||stillWorld){
					System.out.println("Program terminated Automatically\n");
					userinput="x";
				}
			}
			
			//Terminate Program
			else{
				System.out.println("I hope you wondered about the philosophical implications of this game");
				break;
			}
		}
		
	}

	//Method neighbours takes old Generation, cell coordinates, returns neighbour values
	public static int neighbours(char[][] oldGen,int x,int y){
			int n=0;
			for (int r=x-1;r<=x+1;r++){
				for(int c=y-1;c<=y+1;c++){
					if(r==x&&c==y);
					else{
						if (oldGen[r][c]=='X'){
							n=n+1;
						}
					}
				}
			}
			return n;
		}

	//Method emotyWorld takes current generation, returns boolean for empty or not'
	
	public static boolean emptyWorld(char[][] world){
		boolean empty=true;
		for (int r=1;r<=world.length-2;r++){
			for(int c=1;c<=world[r].length-2;c++){
				if(world[r][c]=='X'){
					empty=false;
				break;
				}
			}

		}
		if(empty){
			System.out.println("The World is Empty");
		}
		return empty;
	}
}
