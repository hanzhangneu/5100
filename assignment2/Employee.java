
public class Employee {

	private int id;

	    private String firstName;

	    private int age;

	    private double salary;
	    
	    Employee(int id, String firstName, int age, double salary) {

	        this.id = id;

	        this.firstName = firstName;

	        this.age = age;

	        this.salary = salary;

	    }


	    public int getId() {

	        return id;

	    }


	    public void setId(int id) {

	        this.id = id;

	    }


	    public String getFirstName() {

	        return firstName;

	    }


	    public void setFirstName(String firstName) {

	        this.firstName = firstName;

	    }


	    public int getAge() {

	        return age;

	    }


	    public void setAge(int age) {

	        this.age = age;

	    }


	    public double getSalary() {

	        return salary;

	    }


	    public void setSalary(double salary) {

	        this.salary = salary;

	    }
	    public double salaryGreaterThanFiveThousand(Employee employees) {
	    	int sum=0;
	    	if(employees.getSalary()>5000){
	    		sum=(int) (sum+employees.getSalary());
	    	}
	        // @TODO
	    	return sum;

	    }

	    /*
	        This method should print either "Fizz", "Buzz" or "FizzBuzz"
	        "Fizz" - if id of employee is divisible by 3
	        "Buzz" - if id of employee is divisible by 5
	        "FizzBuzz" - if id of employee is divisible by both 3 and 5
	     */

	    public void fizzBuzz(Employee employee) {
	    	int sumID=0;
	    	if(employee.getId()%3==0|employee.getId()%5==0){
	    		System.out.println(employee.getId());
	    	}
	        // @TODO
	    }
	    /*

	        This method should calculate tax for an employee in dollars

	        If salary of employee is less than or equal to 2500, tax should be 10%

	        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%

	        If salary of employee is greater than 5000, tax should be 35%

	    */

	    public double calculateTax(Employee employee) {
	        double tax=0;
	        if(employee.getSalary()<=2500){tax=employee.getSalary()*0.1;}
	        else if(employee.getSalary()<=5000&&employee.getSalary()>2500){tax=employee.getSalary()*0.25;}
	        else if(employee.getSalary()>5000){tax=employee.getSalary()*0.35;}
	        // @TODO
	        return tax;

	    }
	    /*
	        We are given two employee objects.
	        Implement this method to swap salaries of employees
	    */

	    public void swap(Employee firstEmployee, Employee secondEmployee) {
	        double salary1=0;
	        double salary2=0;
	        salary1=firstEmployee.getSalary();
	        salary2=secondEmployee.getSalary();
	        firstEmployee.setSalary(salary2);
	        secondEmployee.setSalary(salary1);
	        // @TODO
	    }

	    /*
	        Return number of employees whose age is greater than 50
	        Note: Employee array is passed, not employee
	     */
	    public int employeesAgeGreaterThan50(Employee[] employees) {
	    	int Sum=0;
	       for(Employee employee:employees){
	    	   if(employee.getAge()>50){
	    		   Sum++;
	    	   }
	       }
	        return Sum;

	    }
	    /*
	        Implement this method to reverse firstName of employee.

	        Ex. Before: employee.getFirstName() -> "John"

	        After : employee.getFirstName() -> "nhoJ"

	     */

	    public void reverseFirstName(Employee employee) {
	    	StringBuffer sb =new StringBuffer(employee.getFirstName());
	         sb.reverse();
	        // @TODO
	    }
	    /*
	        Print "true" if employee's first name contain one or more digits
	        Print "false" if employee's first name doesn't contain any digit
	        Ex: employee.getFirstName() -> "ha8l" == true
	        employee.getFirstName() -> "hail" == false
	     */
	    public void isContainDigit(Employee employee) {
	        if(employee.getFirstName().matches("[0-9]+")){ System.out.print("true");}
	        else{System.out.print("false");}
	        // @TODO
	    }
	     /*
	        Write a method to raise an employee's salary to three times of his/her original salary.
	        Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
	        DO NOT change the input in this method.
	        Try to add a new method in Employee class: public void raiseSalary(double byPercent) 
	        Call this new method.
	     */
	    public void tripleSalary(Employee employee) {
	        double salary=0;
	        salary=(double) employee.getSalary()*3;
	        employee.setSalary(salary);
	        // @TODO
	    }



}
