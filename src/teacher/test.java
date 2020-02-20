package teacher;

import basic.*;
import management.*;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class test {
    static File file = new File("test.txt");
    public static String[] getString(String name) throws IOException {

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
            return tempName;
    }


    public static Integer[] getInt(String name) throws IOException {

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
                }
                br.close();
                break;
            }
        }
        return b;
    }

    public static teacher makeTeacher(String[] name, Integer[] birth){
        date d = new date(birth[0], birth[1],birth[2]);
        teacher t = new teacher(name[0],d);
        return t;
    }

    public static String[] getRequestedCourse() throws IOException {
        String[] courses = new String[4];
        BufferedReader br = new BufferedReader(new FileReader(file));
        String count = br.readLine();
        while(count!=null){
            if(count.equals("Teaching Request:")){
                for(int i = 0;i<courses.length;i++){
                    String temp = br.readLine();
                    courses[i] = temp;
                }
            }
            count = br.readLine();
            if(count.equals("End of Request")){
                break;
            }
        }
        return courses;
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
        String[] zzh_name = getString("zzh|1|11|1111");
        teacher zzh = makeTeacher(zzh_name,zzh_date);

        Integer[] mjh_date = getInt("mjh|2|22|2222");
        String[] mjh_name = getString("mjh|2|22|2222");
        teacher mjh = makeTeacher(mjh_name,mjh_date);

        Integer[] cyz_date = getInt("cyz|3|33|3333");
        String[] cyz_name = getString("cyz|3|33|3333");
        teacher cyz = makeTeacher(cyz_name,cyz_date);

        Integer[] zjy_date = getInt("zjy|4|44|4444");
        String[] zjy_name = getString("zjy|4|44|4444");
        teacher zjy = makeTeacher(zjy_name,zjy_date);

        ClassDir cdir = new ClassDir();
        zzh.setClassDir(cdir);
        mjh.setClassDir(cdir);
        cyz.setClassDir(cdir);
        zjy.setClassDir(cdir);

        String[] course = getRequestedCourse();
        for(int i=0;i<course.length;i++){
            cdir.listOfTeacher.array.get(i).addCourse(course[i]);
            //let each teacher add requested course
            cdir.addRequest(cdir.listOfTeacher.array.get(i),course[i]);
            //then class director make it a list of request
        }

        cdir.showTeachers(System.out);
        System.out.println(cdir.Lor);

        PTTdir ptt = new PTTdir();
        cdir.submitRequest(ptt);

        cdir.LoTR = getTeachingRequirement();

        Admin ad = new Admin();

        cdir.submitTeachingRequirement(ad);

    }
}
