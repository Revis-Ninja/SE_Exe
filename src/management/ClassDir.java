package management;
import teacher.*;
import java.io.PrintStream;
import java.util.ArrayList;
public class ClassDir {
    public Lot listOfTeacher;
    public ArrayList<String> Lor; //list of request
    public ArrayList<String> LoTR; //list of teaching requirements
    public ClassDir(){
        listOfTeacher = new Lot();
        Lor = new ArrayList<>();
        LoTR = new ArrayList<String>();
    }
    public void addTeacher(teacher t){
        this.listOfTeacher.addTeacher(t);
    }
    public void showTeachers(PrintStream ps){
        listOfTeacher.print(ps);
    }
    public void addRequest(String request){ Lor.add(request); }
    public void subRequest(String request){
        Lor.remove(request);
    }
    public void submitRequest(PTTdir ptt){ ptt.getTeachingRequest(this.Lor);}
    //this method is to sumbit request to ptt director
    public void addTR(String requirement){
        LoTR.add(requirement);
    }
    public void subTR(String requirement){
        LoTR.remove(requirement);
    }
    public void submitTeachingRequirement(Admin ad){ad.getTeachingRequirement(this.LoTR);}
    //this method is to submit requirement to administrator
}
