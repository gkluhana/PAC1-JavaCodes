class Candy extends DessertItem{
	private double weight;
	private int pricePerPound;
	private int cost;

	public Candy(String name, double weight, int pricePerPound){
		
		super(name);
		this.weight=weight;
		this.pricePerPound=pricePerPound;

	}
	public Candy(){
		
	}
	public int getCost(){
		cost=(int)Math.round((weight*(pricePerPound)));
		return cost;
	}
	public String getDetail(){
		String detail= weight+" @ "+ DessertShoppe.cents2dollarsAndCents(pricePerPound)+" /lbs.";
		
		if (detail.length() > DessertShoppe.MAX_ITEM_NAME_SIZE){
    		detail = detail.substring(0,DessertShoppe.MAX_ITEM_NAME_SIZE);
    	}
		return detail;
	}
}