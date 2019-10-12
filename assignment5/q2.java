import java.util.Scanner;

class q2
{  
	public static void main(String arg[])
    {  
		try
		{
			int a,b,c;
			Scanner KB=new Scanner(System.in);
			
			System.out.print("Enter first number : ");
			a=KB.nextInt();
       
			System.out.print("Enter second number : ");
			b=KB.nextInt();
       
			c=a/b;
			System.out.println("Result:"+c);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Error:"+e.getMessage());
			System.out.println("Error:"+e);
		}
		
		System.out.println("End of Program...");
	}
}

