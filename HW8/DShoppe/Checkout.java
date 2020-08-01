public class Checkout{

	protected DessertItem[] arrayOfDesserts;

	public Checkout(){
		arrayOfDesserts = new DessertItem[100];

	}

	public void clear(){
		//loop through array and clear until come across a null pointer, assuming all other elements are null
		for(int n=0;n<100;n++){

			if(arrayOfDesserts[n]!=null){ 
				
				arrayOfDesserts[n]=null;
			}
			else{
				break;
			}

		}
	}

	public void enterItem(DessertItem item){
		//code to enter Item at the first null pointer i.e. end of list

		for(int n=0;n<100;n++){
			if(arrayOfDesserts[n]==null){
				arrayOfDesserts[n]=item;
				break;
			}
		}
	}

	public int numberOfItems(){
		//code to get numberOfItem, assumes all further items after null pointer is null

		int number=0;
		for(int n=0;n<100;n++){
			if(arrayOfDesserts[n]==null){
				number=n;
				break;
			}
		}
		return number;
	}
	
	public int totalCost(){
		//computes and returns total cost of all items in the linear

		int totalCost=0;
		
		for(int n=0;n<100;n++){
			if(arrayOfDesserts[n]!=null){
			totalCost=totalCost+arrayOfDesserts[n].getCost();
			}
			else{
				break;
			}
		}
		
		return totalCost;
	}

	public int totalTax(){
		//computes and return total tax using tax rate from DessertShoppe.java

		int totalTax;
		totalTax=(int)Math.round((totalCost()*(DessertShoppe.TAX_RATE)/100));

		return totalTax;
	}

	public String toString(){
		

		String titleFormat= "\n%"+DessertShoppe.MAX_ITEM_NAME_SIZE+"s"+"%"+DessertShoppe.COST_WIDTH+"s";
		
		String title= String.format(titleFormat,DessertShoppe.STORE_NAME,"");
		String title_border=String.format(titleFormat,"--------------------","");
		
		String space= String.format(titleFormat,"","");

		String receipt=title+title_border+space;
		

		String itemFormat= "\n%-"+DessertShoppe.MAX_ITEM_NAME_SIZE+"s"+"%"+DessertShoppe.COST_WIDTH+"s";
		
		for(int n=0;n<100;n++){
		String itemName,itemDetail="";
			if(arrayOfDesserts[n]!=null){
						
				if(arrayOfDesserts[n] instanceof Cookie){
					Cookie cookie=(Cookie)arrayOfDesserts[n];
					
					itemDetail=String.format(itemFormat,cookie.getDetail(),"");
					itemName=String.format(itemFormat,cookie.getName(),DessertShoppe.cents2dollarsAndCents(cookie.getCost()));
					
					receipt = receipt+itemDetail+itemName;
				}

				else if(arrayOfDesserts[n] instanceof Candy){
					Candy candy=(Candy)arrayOfDesserts[n];
					
					itemDetail=String.format(itemFormat,candy.getDetail(),"");
					itemName=String.format(itemFormat,candy.getName(),DessertShoppe.cents2dollarsAndCents(candy.getCost()));
					
					receipt = receipt+itemDetail+itemName;
				}

				else if(arrayOfDesserts[n] instanceof Sundae){
					Sundae sundae=(Sundae)arrayOfDesserts[n];
					
					itemDetail=String.format(itemFormat,sundae.getDetail(),"");
					itemName=String.format(itemFormat,sundae.getName(),DessertShoppe.cents2dollarsAndCents(sundae.getCost()));
					
					receipt = receipt+itemDetail+itemName;
				}

				else{
					//case for Ice Cream, has no details

				itemName=String.format(itemFormat,arrayOfDesserts[n].getName(),DessertShoppe.cents2dollarsAndCents(arrayOfDesserts[n].getCost()));
				receipt = receipt+itemName;
				
				}
			}

			else{
				break;
			}

		}
		//Totals

		String tax = String.format(itemFormat,"Tax",DessertShoppe.cents2dollarsAndCents(totalTax()));
		String totalCost=String.format(itemFormat,"Total Cost",DessertShoppe.cents2dollarsAndCents(totalCost()+totalTax()));

		receipt=receipt+space+tax+totalCost+space;
		
		return receipt;

	}



}