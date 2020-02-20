package teacher;

import java.io.PrintStream;
import java.util.ArrayList;

public class Lot {
    ArrayList<teacher> array;
    public Lot(){
        array = new ArrayList<teacher>();
    }

    public void addTeacher(teacher t){
        array.add(t);
    }
    public void subTeacher(teacher t){
        array.remove(t);
    }
    public teacher find(String name){
        teacher result = null;
        for (teacher t:array
             ) {
            if(t.getName().equals(name)){
                result = t;
                break;
            }
        }
        return result;
    }
    public void print(PrintStream ps){
        ps.println("List of teachers: ");
        for (teacher t:array
             ) {
            t.print(ps);
        }
        ps.println("End of list");
    }

}
