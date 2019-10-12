public class Pet {

	private String name, owner, color;
	public static final int MALE=1, FEMALE=2, SPAYED=3, NEUTERED=4;
	private enum sex {MALE, FEMALE, SPAYED, NEUTERED};
	protected sex petSex;
	
	public Pet (String name, String ownerName, String color) {
		this.name = name;
		this.owner = ownerName;
		this.color = color;
	}

	String getPetName() {
		return name;
	}

	String getOwnerName() {
		return owner;
	}

	String getColor() {
		return color;
	}

	void setSex(int sexid) {
		try {
			switch(sexid) {
			case MALE:
				petSex = sex.MALE;
				break;
			case FEMALE:
				petSex = sex.FEMALE;
				break;
			case SPAYED:
				petSex = sex.SPAYED;
				break;
			case NEUTERED:
				petSex = sex.NEUTERED;
				break;
			}
		} catch(Exception e){
			throw new IllegalArgumentException("Value not allowed!");
		}
	}

	String getSex() {
		return petSex.toString();
	}

	@Override
	public String toString() {
		String sHelp = this.getClass().getName().toUpperCase();
		return sHelp.substring(sHelp.lastIndexOf(".") + 1) + ":\n" + this.name + " owned by " + 
				this.owner + "\nColor: " + this.color + "\nSex: " + this.getSex() + "\n";
	}
}


interface Boardable {

	public void setBoardStart(int month, int day, int year);

	public void setBoardEnd(int month, int day, int year);

	public boolean boarding(int month, int day, int year);
}

class Cat extends Pet implements Boardable {

	private String hairLength;

	private Date boardingStart, boardingEnd;



	private class Date {

		private int Day, Month, Year;



		public Date(int Day, int Month, int Year) {

			this.Day = Day;

			this.Month = Month;

			this.Year = Year;

		}


		public boolean lessThan(Date date) {

			if (this.Year < date.Year) return true;

			else if (this.Year == date.Year) {

				if (this.Month < date.Month) return true;

				else if (this.Month == date.Month && this.Day <= date.Day) return true;

			}

			return false;

		}

		public boolean greaterThan(Date date) {

			if (this.Year > date.Year) return true;

			else if (this.Year == date.Year) {

				if (this.Month > date.Month) return true;

				else if (this.Month == date.Month && this.Day >= date.Day) return true;

			}

			return false;

		}

	}



	public Cat(String name, String ownerName, String color, String hairLength){

		super(name, ownerName, color);

		this.hairLength = hairLength;

	}


	public String getHairLength() {

		return hairLength;

	}



	public String toString() {

		return super.toString() + "Hair: " + this.getHairLength() + "\n";

	}


	public void setBoardStart(int month, int day, int year) {

		boardingStart = new Date(day, month, year);

	}


	public void setBoardEnd(int month, int day, int year) {

		boardingEnd = new Date(day, month, year);

	}


	public boolean boarding(int month, int day, int year) {

		Date boarding = new Date(day, month, year);

		return (boarding.greaterThan(boardingStart) && boarding.lessThan(boardingEnd));

	}

}




class Dog extends Pet implements Boardable {

	private String size;

	private Date boardingStart, boardingEnd;

	

	private class Date {

		private int Day, Month, Year;


		public Date(int Day, int Month, int Year) {

			this.Day = Day;

			this.Month = Month;

			this.Year = Year;

		}


		public boolean lessThan(Date date) {

			if (this.Year < date.Year) return true;

			else if (this.Year == date.Year) {

				if (this.Month < date.Month) return true;

				else if (this.Month == date.Month && this.Day <= date.Day) return true;

			}

			return false;

		}



		public boolean greaterThan(Date date) {

			if (this.Year > date.Year) return true;

			else if (this.Year == date.Year) {

				if (this.Month > date.Month) return true;

				else if (this.Month == date.Month && this.Day >= date.Day) return true;

			}

			return false;

		}

	}


	public Dog(String name, String ownerName, String color, String size){

		super(name, ownerName, color);

		this.size = size;

	}


	public String getSize() {

		return size;

	}

	public String toString() {

		return super.toString() + "Size : " + this.getSize() + "\n";

	}


	public void setBoardStart(int month, int day, int year) {

		boardingStart = new Date(day, month, year);

	}


	public void setBoardEnd(int month, int day, int year) {

		boardingEnd = new Date(day, month, year);

	}


	public boolean boarding(int month, int day, int year) {

		Date boarding = new Date(day, month, year);

		return (boarding.greaterThan(boardingStart) && boarding.lessThan(boardingEnd));

	}

}
