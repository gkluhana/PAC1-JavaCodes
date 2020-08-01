public class GkSmallInt{
	
	private int value;
	public static int dummy;

	public static int MAXVALUE=1000;

	//Default Constructor
	public GkSmallInt ()
	{
		this.value=0;
	}

	//Constructor with parameter
	public GkSmallInt (int value)
	{
		if (withinBound(value)){
			this.value = value;
		}
		else{
			this.value = 0;
			System.out.println("The value is out of bounds, value was set to 0");
		}
	}

	//Getter Decimal Representation
	public String getDec ()
	{
		return ""+ value;
	}

	//Setter 
	public void setDec (int value)
	{
		if (withinBound(value)){
			this.value = value;
		}
		else{
			this.value = 0;
			System.out.println("The value is out of bounds, value was set to 0");
		}
	}

	//Getter Binary Representation
	public String getBin()
	{
		//Stores value of instance variable in bvalue
		int bvalue=this.value;

		//Checks if bvalue is zero, returns it without any changes
		if(bvalue==0){
			return ""+value;
		}

		/*If bvalue is not 0 then converts bvalue to binary representation by
		dividing by 2 and storing the remainder as the first bit 
		of the binary value (from left to right). Repeats the division on the
		quotient until quotient is 0 (terminating condition of while loop) 

		Assume bvalue to be 125*/

		else{
			// Initialize empty String
			String binString="";
			
			/*125mod(2) is equal to 1, so the "1" gets added to the string 
			binstring, then 125/2 is stored in bvalue which is 62. 62mod(2)
			is 0 which gets concatenated with binstring to give "01". Repeating
			the process until bvalue is 0 gives us binstring = "1111101*/

			while(bvalue!=0){
				binString=bvalue%2+binString;
				bvalue=bvalue/2;
			}
			return ""+binString;
		}
	}

	public String getHex()
	{
		//Stores value of instance variable in hvalue
		int hvalue=this.value;
		//Checks if hvalue is between 0-9, returns it without any changes
		
		if(hvalue<10){
			return "0x"+value;
		}

		/*If hvalue is not between 0-9 then converts hvalue to hexadecimal representation by
		dividing by 16 and storing the remainder as the first bit 
		of the hex value (from left to right). Repeats the division on the
		quotient until quotient is 0 (terminating condition of while loop) 

		Assume havalue to be 125*/
		else{
			//Initialize empty hexstring
			String hexString="";
			//Initialze remainder variable
			int rem=0;

			/*125mod(16) is equal to 13, so then rem > 9, for this case remainder-10 =3
			which when added to char 'A' gives char value D which gets added to the string 
			hextring, then 125/16 is stored in hvalue which is 7. 7mod(16)
			is 7 which gets concatenated as it is with hexstring to give "7D". This is
			the hexadecimal representation for 125*/

			while(hvalue!=0){
				rem=hvalue%16;
				if(rem<10)
				{
					hexString=rem+hexString;
				}
				else
				{
					hexString=(char)('A'+rem-10)+hexString;

				}
				hvalue=hvalue/16;
				}
				return "0x"+hexString;
			}
			
		}

	public static boolean sameValue(String x, String y)
	{
		int binAsInt=0;

		for (int i=0;i<x.length();i++){

			if(x.substring(i,i+1).equals("1")){
			
				binAsInt=(int)Math.pow(2,x.length()-1-i)+binAsInt;
			}
		}
			GkSmallInt binAsSmallInt = new GkSmallInt(binAsInt);
			String binAsHex = binAsSmallInt.getHex();

			if (binAsHex.equals("0x"+y)){
				return true;
			}
			else
				return false;


		}


	public static boolean withinBound(int x){
		if (x>=0 && x<=MAXVALUE){
			return true;
		}
		else {
			return false;
		}
		}
} 	