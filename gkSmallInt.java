public class GkSmallInt{
	private int value;

	public static int MAXVALUE=1000;
	
	public GkSmallInt (int value)
	{
		if (withinBound(value,0,MAXVALUE))
			this.value = value;
		else
			this.value = 0;
			System.out.println("The value is out of bounds, value was set to 0");
	}

	public String getDec ()
	{
		return ""+ value;
	}

	public void setDec (int value)
	{
		if (withinBound(value,0,MAXVALUE)){
		this.value = value;
		}
		else
			this.value = 0;
			System.out.println("The value is out of bounds, value was set to 0");
	}

public static boolean withinBound(int x, int min, int max){
	if (x>=min||x<=max){
		return true;
	}
	else {
		return false;
	}
	}
} 