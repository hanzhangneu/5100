
public class Q4 {
	public int[][] multiply(int[][] A, int[][] B) {
	    //validity check
	    int[][] C = new int[A.length][B[0].length];
	    for(int i=0; i<C.length; i++){
	        for(int j=0; j<C[0].length; j++){
	            int sum=0;
	            for(int k=0; k<A[0].length; k++){
	                sum += A[i][k]*B[k][j];
	            }
	            C[i][j] = sum;
	        }
	    }
	
	    return C;
	}
}
