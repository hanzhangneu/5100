
public abstract class Employee {
	private String name;
	private int paymentPerHour;
	
	public Employee(String name,int paymentPerHour){
		this.name=name;
		this.paymentPerHour=paymentPerHour;
	}
    
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPaymentPerHour(int paymentPerHour){
		this.paymentPerHour=paymentPerHour;
	}
	
	public int getPaymentPerHour(){
		return paymentPerHour;
	}
	
	public abstract int calculateSalary();
}


class Contractor extends Employee {
private int workingHours;

public Contractor(String name, int paymentPerHour, int workingHours) {
	
super(name, paymentPerHour);
this.workingHours = workingHours;
}

public int calculateSalary() {
return getPaymentPerHour() * workingHours;
}
}

class FullTimeEmployee extends Employee {

public FullTimeEmployee(String name, int paymentPerHour) {

super(name, paymentPerHour);
}

public int calculateSalary() {
return getPaymentPerHour() * 8;
}
}


