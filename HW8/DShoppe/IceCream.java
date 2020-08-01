class IceCream extends DessertItem{
	
	private int cost;

	public IceCream(String name, int cost){
		
		super(name);
		this.cost= cost;

	}
	public IceCream(){
		
	}


	public int getCost(){
		return cost;
	}
}