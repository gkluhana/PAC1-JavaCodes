class Cookie extends DessertItem{
	private int number;
	private int pricePerDozen;
	private int cost;

	public Cookie(String name, int number, int pricePerDozen){
		
		super(name);
		this.number=number;
		this.pricePerDozen=pricePerDozen;

	}

	public Cookie(){

	}

	public int getCost(){
		cost= (int)Math.round(number*(pricePerDozen/12.0));
		return cost;
	}

	public String getDetail(){
		String detail= number+" @ "+ DessertShoppe.cents2dollarsAndCents(pricePerDozen)+" /dz.";
		
		if (detail.length() > DessertShoppe.MAX_ITEM_NAME_SIZE){
    		detail = detail.substring(0,DessertShoppe.MAX_ITEM_NAME_SIZE);
    	}
		return detail;
	}
}