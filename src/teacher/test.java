package teacher;
import basic.*;
import management.*;
import java.io.*;
import java.util.ArrayList;
public class test {
    static File file = new File("test.txt");

    public static String getString(String name) throws IOException {
        //get name from test.txt file
        BufferedReader br = new BufferedReader(new FileReader(file));
        String teacher;
        String[] tempName = null;
        while(br.ready()){
            teacher=br.readLine();
            if(teacher.equals(name)){
                tempName = teacher.split("\\|");
                //read from file and then store them into temporary array
                br.close();
                break;
            }
        }
            return tempName[0];
    }
    public static Integer[] getInt(String name) throws IOException {
        //get birth date from test.txt file
        BufferedReader br = new BufferedReader(new FileReader(file));
        String teacher;
        String[] tempName = null;
        Integer[] b =null;
        while(br.ready()){
            teacher=br.readLine();
            if(teacher.equals(name)){
                tempName = teacher.split("\\|");
                b = new Integer[3];
                //read from file and then store them into temporary array
                for(int i=1; i<tempName.length; i++){
                    int birth = Integer.parseInt(tempName[i]);
                    //turn String type into Integer
                    b[i-1]=birth;
                    //tempName.length is larger than integer[] b
                }
                br.close();
                break;
            }
        }
        return b;
    }
    public static teacher makeTeacher(String name, Integer[] birth){
        //this helper method is to build up teacher object quickly
        date d = new date(birth[0], birth[1],birth[2]);
        teacher t = new teacher(name,d);
        return t;
    }
    public static ArrayList<String> getRequestedCourse() throws IOException {
        //get teaching requests from test.txt file
        ArrayList<String> courses = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String count = br.readLine();
        while(count!=null){
            if(count.equals("Teaching Request:")){
                while (br.ready()){
                    String temp = br.readLine();
                    courses.add(temp);
                    //store requests into arraylist
                }
            }
            count = br.readLine();
        }
        br.close();
        return courses;
    }
    public static void sortRequest(ArrayList<String> request, ClassDir cdir) throws IOException{
        ArrayList<String> temp = request;
        for (String name: temp) {
            String[] course = name.split("\\|");
            teacher t = cdir.listOfTeacher.find(course[0]);
            t.addCourse(course[1]);
            cdir.addRequest(course[0]+": "+course[1]);
        }
    }
    public static ArrayList<String> getTeachingRequirement() throws IOException {
        ArrayList<String> requirement = new ArrayList<String>(4);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String count2 = br.readLine();
        while(count2!=null){
            if(count2.equals("Teaching Requirement:")){
                for(int i = 0;i<4;i++){
                    String temp = br.readLine();
                    requirement.add(temp);
                }
            }
            count2 = br.readLine();
            if(count2.equals("End of Teaching Requirement")){
                break;
            }
        }
        return requirement;
    }
    public static void main (String[] args) throws IOException{

        Integer[] zzh_date = getInt("zzh|1|11|1111");
        String zzh_name = getString("zzh|1|11|1111");
        teacher zzh = makeTeacher(zzh_name,zzh_date);

        Integer[] mjh_date = getInt("mjh|2|22|2222");
        String mjh_name = getString("mjh|2|22|2222");
        teacher mjh = makeTeacher(mjh_name,mjh_date);

        Integer[] cyz_date = getInt("cyz|3|33|3333");
        String cyz_name = getString("cyz|3|33|3333");
        teacher cyz = makeTeacher(cyz_name,cyz_date);

        Integer[] zjy_date = getInt("zjy|4|44|4444");
        String zjy_name = getString("zjy|4|44|4444");
        teacher zjy = makeTeacher(zjy_name,zjy_date);

        ClassDir cdir = new ClassDir();
        zzh.setClassDir(cdir);
        mjh.setClassDir(cdir);
        cyz.setClassDir(cdir);
        zjy.setClassDir(cdir);

        zzh.teachingRequest("zzh|HCI");

        ArrayList<String> course = getRequestedCourse();
        System.out.println(course.toString());

        sortRequest(getRequestedCourse(),cdir);

        cdir.showTeachers(System.out);
        //test list of teachers
        System.out.println(cdir.Lor);
        //test list of request
        PTTdir ptt = new PTTdir();
        cdir.submitRequest(ptt);
        //test submit request to PTT director
        cdir.LoTR = getTeachingRequirement();
        System.out.println(cdir.LoTR.toString());
        //test list of teaching requirement
        Admin ad = new Admin();
        cdir.submitTeachingRequirement(ad);
        //test submit teaching requirement to administrator
        ptt.approveRequest("zzh: HCI");
        ptt.declineRequest("mjh: Advanced Programming");
        ptt.printRequest(System.out);




    }
}
