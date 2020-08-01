public class gkMid2{

	public static void main(String [] args){
		
		XPS dellilah = new XPS("Dellilah","Gautam","6th September 2017");
		Laptop envy = new HP();

		/*
		dellilah.powerState();
			if(dellilah.isNo1()){
				dellilah.powerSwitch();
			}
		dellilah.powerState();
		*/System.out.println(dellilah.getName()+" Belongs To "+dellilah.belongsTo());
		System.out.println(dellilah.getName()+"\'s purpose is to be a "+dellilah.getTask());
		/*System.out.println(dellilah.getName()+"\'s Brand is "+dellilah.getBrand());
		System.out.println(dellilah.getName()+"\'s Model is "+dellilah.getModel());
		
		System.out.println(dellilah.toString());
		*/
		//equals experiment
		if(envy instanceof XPS){
			XPS dellilahclone =(XPS) envy;
		}
		/*
		System.out.println(dellilahclone.getName()+" Belongs To "+dellilahclone.belongsTo());
		System.out.println(dellilahclone.getName()+"\'s purpose is to be a "+dellilahclone.getTask());
		System.out.println(dellilahclone.getName()+"\'s Brand is "+dellilahclone.getBrand());
		System.out.println(dellilahclone.getName()+"\'s Model is "+dellilahclone.getModel());
		System.out.println(dellilahclone.toString());
		
		if(dellilahclone.equals(dellilah)){
			System.out.println("hmm,their names are same!");		
		}
		else {
			System.out.println("Dude,even their names are not same!");	
		}
		if(dellilahclone==dellilah){
			System.out.println("They are the same object!");
		}	
		else{
			System.out.println("Imposter alert!"); 		
		}
		*/
		int n=5;
		System.out.printf("\n%d Factorial is %d\n",n,myfactorial(n));

		System.out.println(dellilah.canSee());
		MI myMi= new MI();
		System.out.println(myMi.canSee()+" "+myMi.canTouch());
	
		//2D Arrays
		int n1=10;
		int n2=n1;
		int[][] myGrid= new int[n1][n2];

		for(int i=0;i<n1;i++){
			for(int j=0;j<n2;j++){
				myGrid[i][j]=7;
			}
		}
		for(int i=0;i<n1;i++){
			for(int j=0;j<n2;j++){
				System.out.print(myGrid[i][j]+" ");
			}
			System.out.println("");
		}


	}

	public static int myfactorial(int n){
		if(n==1)
			return 1;
		else
			return n*myfactorial(n-1);
	}	

}


/*
//Experiment Casting
class HP extends Laptop{
	public HP(){
		super("HP","");
	}	
}
*/
class XPS extends Laptop implements Screen{
	private String name;
	private String belongsTo;
	private String dateOfCreation;

	private boolean isNo1= true;
	private boolean power;

	//Constructors
	public XPS(){
		this("");
	}

	public XPS(String name){
		this(name,"");
	}
	public XPS(String name,  String belongsTo){
		this(name,belongsTo,"");
	}

	public XPS(String name,String belongsTo, String dateOfCreation){
		super("Dell","XPS13");
		this.name=name;
		this.dateOfCreation=dateOfCreation;
		this.belongsTo=belongsTo;
	}

	//PowerSwitch
	public void powerSwitch(){
		power = !power;
	}
	//PowerState
	public void powerState(){
		if (!power){
			System.out.printf("%s is Sleeping\n",name);
		}
		else{
			System.out.printf("%s is Awake\n",name);	
		}
	}
	//getNo1
	public boolean isNo1(){
		return isNo1;
	}
	//get BelongsTo
	public String belongsTo(){
		return belongsTo;
	}

	public String getName(){
		return name;
	}

	protected static void printStuff(String stuff){
		System.out.println(stuff);
	}
	public boolean equals(XPS a){
		if(a.getName()==this.getName()){
			return true;
		}
		else{
			return false;
		}
	}

	public String canSee(){
		return "13.3inch Screen";
	}
	/*
	public String toString(){
		return "Hello! my name is "+name+". How can I help you, today?";
	}*/
}




abstract class Laptop extends Machine{
	private String brand;
	private String model;


	/*
	public Laptop(){
		this("");
	} 
	*/
	/*
	public Laptop(String brand){
		this(brand,"");
	}
	*/
	public Laptop(String brand, String model){
		super("Personal Computing Machine");
		this.brand=brand;
		this.model=model;
	}

	public String getBrand(){
		return brand;
	}
	public String getModel(){
		return model;
	}
	public abstract String getName();
	public abstract String belongsTo();

}
class MI extends Phone implements Screen, TouchScreen{
	public String canSee(){
		return "5.5inch screen";
	}
	public String canTouch(){
		return "Touch Me Bro";
	}
}
class Phone{

}


class Machine{
	private String task;

	public Machine(){
		this("noTaskAssigned");
	}
	public Machine(String task){
		this.task=task;
	}

	public final String getTask(){
		return task;
	}
}

interface Screen{
	public int x=7;

	
	public String canSee();

}
interface TouchScreen extends Screen{
	public abstract String canTouch();
}