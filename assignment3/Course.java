import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap; 

public class Course {
int courseId;
String courseName;
int	maxCapacity;
int	professorId;
int	credits;
private int [] studentId;

/**courseId - should not be negative or 0
   courseName- should be a string with minimum length 10 and maximum 60
   maxCapacity - should not be less than 10 greater than 100
   professorId - should be a six digit integer
   credits - should be a single digit but greater than 0
*/
	
public int getcourseId(){
	   return this.courseId;
}
public void setcourseId(){
	 if(courseId<=0){
	    	throw new IllegalArgumentException("id can't be this number");
	    }
	   this.courseId=courseId;	   
	   
}
	
public int getprofessorId(){
	   return this.professorId;
}
public void setprofessorId(){
	if(professorId<100000||professorId>999999){
		throw new IllegalArgumentException("professorId can't be this number");
	}
	   this.professorId=professorId;
}

public int getcredits(){
	   return this.credits;
}
public void setcredits(){
	if(credits>10||credits<0){
		throw new IllegalArgumentException("credits can't be this number");
	}
	   this.credits=credits;
	
}


public int getmaxCapacity(){
	   return this.maxCapacity;
}
public void setmaxCapacity(){
	if(maxCapacity<10||maxCapacity>100)
	{
		throw new IllegalArgumentException("maxCapacity can't be this number");
	}
	   this.maxCapacity=maxCapacity;
	
}


public String getcourseName(){
	   return this.courseName;
}
public void setcourseName(){
	if(courseName.length()<10||courseName.length()>60){
		throw new IllegalArgumentException("courseName can't be this number");
	}
	   this.courseName=courseName;
}

public Course(int courseId){
	this.courseId=courseId;
}

public Course(int courseId,int professorId){
	this.professorId=professorId;
	this.courseId=courseId;
}

public Course(int courseId,int professorId,int credits){
	this.professorId=professorId;
	this.courseId=courseId;
	this.credits=credits;
}


public void registerStudent(int[] studentId){
	this.studentId = studentId;
}



public void removeDuplicates(int[] studentIds,int n) {
 HashMap<Integer,
	 Boolean> mp = new HashMap<>(); 
 for (int i = 0; i < n; ++i) {
	 if (mp.get(studentId[i]) == null)
		 System.out.print(studentId[i] + " "); 
	 mp.put(studentId[i], true); 
 }
	
}
	



public int groupsOfStudents(int[] studentIds) {
	int count=0;
	for(int i=0;i<studentIds.length;i++){
		for(int j=i+1;j<studentIds.length;j++){
			if((studentId[i]+studentId[j])%2==0)
			{
				count++;
			}
		}
		
	}
	return count;
	
}

