package management;
import teacher.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;


public class ClassDir {
    public Lot listOfTeacher;
    public HashMap<String,String> Lor; //list of request
    public ArrayList<String> LoTR; //list of teaching requirements
    public ClassDir(){
        listOfTeacher = new Lot();
        Lor = new HashMap<String, String>();
        LoTR = new ArrayList<String>();
    }
    public void addTeacher(teacher t){
        this.listOfTeacher.addTeacher(t);
    }
    public void showTeachers(PrintStream ps){
        listOfTeacher.print(ps);
    }

    public void addRequest(teacher t,String request){
        Lor.put(t.getName(),request);
    }
    public void subRequest(teacher t, String request){
        Lor.remove(t.getName(),request);
    }

    public void submitRequest(PTTdir ptt){
        ptt.approveRequest(this.Lor);
    }

    public void addTR(String requirement){
        LoTR.add(requirement);
    }
    public void subTR(String requirement){
        LoTR.remove(requirement);
    }

    public void submitTeachingRequirement(Admin ad){
        ad.getTeachingRequirement(this.LoTR);
    }

}
