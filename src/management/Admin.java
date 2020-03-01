package management;
import teacher.*;
import java.util.ArrayList;
public class Admin {
    ArrayList<String> LoTR;
    ArrayList<String> TeachersFound;
    public Admin(){
        LoTR = new ArrayList<String>();
        TeachersFound = new ArrayList<>();
    }
    public void getTeachingRequirement(ArrayList<String> LoTR){
        this.LoTR = LoTR;
    }
    //get teaching requirement from class director
    public void findTeacher(teacher t){
        TeachersFound.add(t.getName());
    }
}
