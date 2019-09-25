
public class test {
	public static void main(String[] args){
		Employee e1=new Employee(10,"tom",25,2400);
		Employee e2=new Employee(11,"harry",46,4800);
		Employee e3=new Employee(12,"hat",55,5200);
		
        e2.swap(e1,e2);  
        System.out.println(e1.getSalary()+"+"+e2.getSalary());
        
}
     
}