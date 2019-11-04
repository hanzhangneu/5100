import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;;

public class q2 {

	public static void main(String[] args) {	
		try {
			BufferedReader  br =  new BufferedReader(new InputStreamReader(new FileInputStream("D:test3.txt"),"GB2312"));
			String b="";
			StringBuffer sb = new StringBuffer();
			try {
				while((b = br.readLine())!=null){
					sb.append(b);
				}
				 StringBuilder ans = new StringBuilder();
			        Stack<Character> sp = new Stack<>();
			        int i=0;
			        String s=sb.toString();
			        while(i<s.length()){
			            char c = s.charAt(i);
			            if(c==']'){
			                StringBuilder temp = new StringBuilder();
			                StringBuilder currString = new StringBuilder();
			                Queue<Character> que = new LinkedList<>();
			                while(sp.peek()!='[') currString.append(sp.pop());
			                int size = que.size();
			                sp.pop();
			                StringBuilder countString = new StringBuilder();
			                while(!sp.isEmpty() && Character.isDigit(sp.peek())){
			                    countString.append(sp.pop());
			                }
			                int count = Integer.valueOf(countString.reverse().toString());
			                int tempCount = 0;
			                while(count!=0){
			                    for(int l=0;l<currString.length();++l){
			                        temp.append(currString.charAt(l));
			                    }
			                    count--;
			                }
			                temp.reverse();
			                for(int k=0;k<temp.length();++k) sp.push(temp.charAt(k));
			            }
			            else sp.push(c);
			            i++;
			        }
			        while(!sp.isEmpty())
			            ans.append(sp.pop());
			        ans.reverse();
                String outputString=ans.toString();

			
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:test4.txt"),"GB2312"));
				bw.write(outputString);
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
			}
		}
	}