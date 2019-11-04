import java.io.*;

class q3
{
          
      public static void main(String args[]) throws IOException
      {
    
    try
    {
          FileReader fr;
          BufferedReader br;
          File f;
          String str;
          int i=0,cnt=0;
          while(args[i] != null)
          {
            f = new File(args[i]);
            fr = new FileReader("D:/test.txt");
        br = new BufferedReader(fr);
           
        while((str = br.readLine()) != null)
            cnt++;
            System.out.println("File Name : " + f.getName() + " Total Lines : " + cnt);
            cnt = 0;  
            i++;   
            fr.close();
          }  
      
    }
    catch(FileNotFoundException e)
     {
      System.out.println("File Not Found");
    }
    catch(IOException e)
        {
      System.out.println("Exception : " + e);
    } 
      }
}
