public class Q5{
	public static void main(String[]args){
		Q5 a=new Q5();
		int a1=2;
		System.out.println(a.countAndSay(a1));
	}
	
	
	  public static String countAndSay(int n) {
	        String temp = "1";
	        while(--n > 0){
	            temp = magic(temp);
	        }
	        return temp;
	    }
	    
	    public static String magic(String num){
	        int i=0, counter = 0;
	        char cur = 0, prev = 0;
	        StringBuilder sb = new StringBuilder();
	        while(i<num.length()){
	            cur = num.charAt(i++);
	            if(cur == prev) counter++;
	            else{
	                if(i>1) sb.append(counter).append(prev);
	                counter = 1;
	            }
	            if(i==num.length()) sb.append(counter).append(cur);
	            prev = cur;
	        }
	        return sb.toString();
	    }
	}