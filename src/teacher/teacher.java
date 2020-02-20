package teacher;
import java.io.*;

import basic.*;
import management.*;

import java.util.ArrayList;
import java.util.Arrays;

public class teacher extends person {

    ArrayList<String> Loc;

    public teacher(String name, date birth){
        super(name,birth);
        Loc = new ArrayList<String>();

    }
    public void addCourse(String course){
        Loc.add(course);
    }
    public void subCourse(String course){
        Loc.remove(course);
    }
    @Override
    public void print(PrintStream ps){
        ps.print(this.getName());
        this.getBirth().print(ps);
        System.out.println();
        ps.print("list of requested courses: ");
        for (String course:Loc
             ) {
            ps.print(course+", ");
        }
        ps.println();
    }

    public String teachingRequest() throws IOException {
        File file = new File("test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String result = br.readLine();
        br.close();
        return result;
    }
    public void setClassDir(ClassDir cdir){
        cdir.addTeacher(this);
    }

}
