import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;;

public class q1 {

	public static void main(String[] args) {	
		try {
			BufferedReader  br =  new BufferedReader(new InputStreamReader(new FileInputStream("D:test.txt"),"GB2312"));
			String b="";
			StringBuffer sb = new StringBuffer();
			try {
				while((b = br.readLine())!=null){
					sb.append(b);
				}
				String[] words = sb.toString().split("\\s");
				 String outputString = "";
				for (int i = words.length-1; i >= 0; i--)
					{
					outputString = outputString + words[i] + " ";
				}
				
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:test2.txt"),"GB2312"));
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