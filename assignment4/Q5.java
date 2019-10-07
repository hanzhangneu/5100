
public class Q5 {
static void PrintFor(String arr){
	int curr_max=0;
	int last_entry=0;
	int j;
	
	for(int i=0;i<arr.length();i++){
		int noNext=0;
		switch(arr.charAt(i)){
		case'i':
			j=i+1;
			while(j<arr.length()&&arr.charAt(j)=='D'){
				noNext++;
				j++;
			}
			if(i==0){
				curr_max=noNext+2;
				System.out.print(""+ ++last_entry);
				System.out.print(""+ curr_max);
				last_entry=curr_max;
		}
			else{
				curr_max=curr_max+noNext+1;
				
				last_entry=curr_max;
				System.out.print(" " + last_entry); 
			}
			for (int k = 0; k < noNext; k++) {
				System.out.print(" " + --last_entry); 
				i++;
			}
			break;
		case 'D':
			if (i == 0) 
				{ j = i + 1;
				while (j < arr.length()&&arr.charAt(j) == 'D'){
					noNext++;
					j++;
				}
				curr_max = noNext + 2;
				System.out.print(" " + curr_max + " " + (curr_max - 1)); 
				last_entry = curr_max - 1;
				}
			else{
				System.out.print(" " + (last_entry - 1)); 
				last_entry--; 
			}
			break;
	}
}
	System.out.println(); 
}
  public static void main(String[] args){
	  PrintFor("IDID");
	  PrintFor("III");
}
}