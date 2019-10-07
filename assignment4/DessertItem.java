public abstract class DessertItem{
	protected String name;
	
	public DessertItem(){
		this("");
	}
	
	public DessertItem(String name){
		if (name.length() <= DessertShoppe.MAX_ITEM_NAME_SIZE){
			this.name = name;
		} else {
			this.name = name.substring(0,DessertShoppe.MAX_ITEM_NAME_SIZE);
		}
	}
	
	public final String getName(){
		return name;
	}

	public abstract int getCost(); 
}


class DessertShoppe {

	public final static double TAX_RATE = 6.5;

	public final static String STORE_NAME = "M & M Dessert Shoppe";

	public final static int MAX_ITEM_NAME_SIZE = 25;

	public final static int COST_WIDTH = 6;
	public static String cents2dollarsAndCents(int cents){

		String s = "";
		if (cents < 0) {

			s += "-";

			cents *= -1;

		}

		int dollars = cents/100;

		cents = cents % 100;

		if (dollars > 0){

			s += dollars;

		}

		s += ".";

		if (cents < 10) {

			s += "0";

		}
		s += cents;
		return s;
	}
}


 class Candy extends DessertItem{

	private double weight;

	private int pricePerLb;

	

	public Candy(String name, double weight, int pricePerLb){

		super(name);

		this.weight = weight;

		this.pricePerLb = pricePerLb;

	}



	public int getCost(){

		int cost = (int)Math.round(pricePerLb * weight);

		return cost;

	}



	public double getWeight(){

		return weight;

	}



	public int getPricePerLb(){

		return pricePerLb;

	}
}
 
 
 
 
  class Checkout{
		public static int numberOfItems = 0;
		private DessertItem[] itemArray;

		public Checkout(){
			this.itemArray = new DessertItem[100];
		}

		public int numberOfItems(){
			return numberOfItems;
		}
		
		public void enterItem(DessertItem newItem){
			itemArray[numberOfItems] = newItem;
			numberOfItems++;
		}

		public void clear(){
			itemArray = new DessertItem[100];
			numberOfItems = 0;
		}

		

		public int totalCost(){ // without tax
			int cost = 0;
			for (int i = 0; i < numberOfItems; i++){
				cost += itemArray[i].getCost();
			}
			return cost;
		}

		public int totalTax(){
			return (int)Math.round(totalCost() * DessertShoppe.TAX_RATE /100); 
		}

		public java.lang.String toString(){
			String s = "";
			//Formating: set column widths
			String leftColumn = "%-" + DessertShoppe.MAX_ITEM_NAME_SIZE + "s";
			String rightColumn = "%" + DessertShoppe.COST_WIDTH + "s";
			int recieptWidth = DessertShoppe.MAX_ITEM_NAME_SIZE + DessertShoppe.COST_WIDTH;
			//Name of store underlined by row of dashes
			String storeName = DessertShoppe.STORE_NAME;
			String dashes = "";
			//create string of dashes equal to length of store name
			for(int i = 0; i < storeName.length(); i++){
				dashes += "-";
			}

			//to center, I've added empty strings with a set width to act as padding

			String padding = "%" + (recieptWidth - storeName.length())/2 + "s";
			s += String.format(padding + "%s\n" + padding +"%s\n\n", "", storeName,"", dashes);

			//Item names and prices

			for (int i = 0; i < numberOfItems; i++){

				String itemName = itemArray[i].getName();

				String itemCost = DessertShoppe.cents2dollarsAndCents(itemArray[i].getCost());

				if (itemArray[i] instanceof Candy){

					double candyWeight = ((Candy)itemArray[i]).getWeight();

					String candyCost = DessertShoppe.cents2dollarsAndCents(((Candy)itemArray[i]).getPricePerLb());

					s += String.format("%,.2f lbs. @ %s /lb.\n", candyWeight, candyCost);

					//%,.2f is a double with 2 decimal places of precision

				}

				if (itemArray[i] instanceof Cookie){

					int numCookies = ((Cookie)itemArray[i]).getNumCookies();

					String cookieCost = DessertShoppe.cents2dollarsAndCents(((Cookie)itemArray[i]).getPricePerDozen());

					s += String.format("%d @ %s /dz.\n", numCookies, cookieCost);

				}

				if (itemArray[i] instanceof Sundae){

					String nameTopping = ((Sundae)itemArray[i]).getNameTopping();

					s += String.format("%s Sundae with\n", nameTopping);

				}

				s += String.format(leftColumn + rightColumn + "\n", itemName, itemCost); 

			}



			//Tax

			String tax = DessertShoppe.cents2dollarsAndCents(totalTax());

			s += String.format(leftColumn + rightColumn + "\n", "Tax", tax);



			//Total

			String total = DessertShoppe.cents2dollarsAndCents(totalTax() + totalCost());

			s += String.format(leftColumn + rightColumn + "\n", "Total Cost", total);

			

			return s;

		}

	}
  
  class Cookie extends DessertItem{

		private int numCookies;

		private int pricePerDozen;



		public Cookie(String name, int numCookies, int pricePerDozen){

			super(name);

			this.numCookies = numCookies;

			this.pricePerDozen = pricePerDozen;

		}



		public int getCost(){

			int cost = (int)Math.round(numCookies * pricePerDozen / 12);

			return cost;

		}



		public int getNumCookies(){

			return numCookies;

		}



		public int getPricePerDozen(){

			return pricePerDozen;

		}

	}
  
  class IceCream extends DessertItem{

		private int cost;



		public IceCream(String name, int cost){

			super(name);

			this.cost = cost;

		}



		public int getCost(){

			return cost;

		}
	}
  
  
  class Sundae extends IceCream{

		private String nameTopping;

		private int costTopping;



		public Sundae(String nameIceCream, int costIcecream, String nameTopping, int costTopping){

			super(nameIceCream, costIcecream);

			this.nameTopping = nameTopping;

			this.costTopping = costTopping;

		}



		public int getCost(){

			return super.getCost() + costTopping;

		}



		public String getNameTopping(){

			return nameTopping;

		}
	}
  
  
  class TestCheckout {



	  public static void main(String[] args) {

	  

	    Checkout checkout = new Checkout();

	    

	    checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));

	    checkout.enterItem(new IceCream("Vanilla Ice Cream",105));

	    checkout.enterItem(new Sundae("Choc. Chip Ice Cream",145, "Hot Fudge", 50));

	    checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));

	    

	    System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");

	    System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");

	    System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");

	    System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");

	    System.out.println(checkout);

	    

	    checkout.clear();

	    

	    checkout.enterItem(new IceCream("Strawberry Ice Cream",145));

	    checkout.enterItem(new Sundae("Vanilla Ice Cream",105, "Caramel", 50));

	    checkout.enterItem(new Candy("Gummy Worms", 1.33, 89));

	    checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 399));

	    checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));

	    checkout.enterItem(new Candy("Candy Corn",3.0, 109));

	    

	    System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");

	    System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");

	    System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");

	    System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");

	    System.out.println(checkout);

	  }

	}