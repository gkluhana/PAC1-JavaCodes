class Sundae extends IceCream{
	
	private int cost;
	private String toppingName;

	public Sundae(String name, int cost, String toppingName, int toppingCost){
		
		super(name, cost);
		this.cost = cost+toppingCost;
		this.toppingName=toppingName;

	}

	public Sundae(){
		
	}

	public int getCost(){
		return cost;
	}

	public String getDetail(){
		String detail= toppingName+" Sundae with ";
		if (detail.length() > DessertShoppe.MAX_ITEM_NAME_SIZE){
    		detail = detail.substring(0,DessertShoppe.MAX_ITEM_NAME_SIZE);
    	}

		return detail;
	}
}