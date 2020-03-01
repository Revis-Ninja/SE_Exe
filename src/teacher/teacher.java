package teacher;
import java.io.*;
import basic.*;
import management.*;
import java.util.ArrayList;
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
        for (String course:Loc) {
            ps.print(course+", ");
        }
        ps.println();
    }
    public void teachingRequest(String request) throws IOException {
        //teacher would like to submit request,
        //and then write to the test.txt file
        FileWriter test = new FileWriter("test.txt",true);
        BufferedWriter bw = new BufferedWriter(test);
        File file = new File("test.txt");
        bw.newLine();
        bw.write(request);
        bw.flush();
        bw.close();
    }
    public void setClassDir(ClassDir cdir){
        cdir.addTeacher(this);
    }
}
