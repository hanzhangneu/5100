import java.util.ArrayList;
public class Q7 {
	public void main(String args[]){
      Q7 q=new Q7();
      
	}
	
	  public ArrayList<Integer> spiralOrder(int[][] matrix) {
	        ArrayList<Integer> result=new ArrayList<>();
	        if(matrix==null || matrix.length==0 || matrix[0].length==0) return result;
	        int m=matrix.length;
	        int n=matrix[0].length;
	        int [][] flag=new int [m][n];
	        int l2r=0,u2d=n-1,r2l=m-1,d2u=0;
	        int count=0;
	        while(count<m*n){
	            for(int i=0;i<n;i++){//从左往右
	                if(flag[l2r][i]==0){
	                    result.add(matrix[l2r][i]);
	                    count++;
	                    flag[l2r][i]=1;
	                }
	            }
	            l2r++;
	            for(int i=0;i<m;i++){//从上往下
	                if(flag[i][u2d]==0){
	                    result.add(matrix[i][u2d]);
	                    count++;
	                    flag[i][u2d]=1;
	                }
	            }
	            u2d--;
	            for(int i=n-1;i>=0;i--){//从右往左
	                if(flag[r2l][i]==0){
	                    result.add(matrix[r2l][i]);
	                    count++;
	                    flag[r2l][i]=1;
	                }
	            }
	            r2l--;
	            for(int i=m-1;i>=0;i--){//从下往上
	                if(flag[i][d2u]==0){
	                    result.add(matrix[i][d2u]);
	                    count++;
	                    flag[i][d2u]=1;
	                }
	            }
	            d2u++;
	        }
	        return result;
	    }
	}