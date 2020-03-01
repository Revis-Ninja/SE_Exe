package management;

import java.io.PrintStream;
import java.util.ArrayList;
public class PTTdir {
    ArrayList<String> RequestApproved;
    ArrayList<String> RequestDeclined;
    ArrayList<String> TeachingRequest;
    public PTTdir(){
        RequestApproved = new ArrayList<>();
        RequestDeclined = new ArrayList<>();
        TeachingRequest = new ArrayList<>();
    }
    public ArrayList<String> getTeachingRequest(ArrayList<String> list){
        //receive teaching request from class director
        TeachingRequest = list;
        return TeachingRequest;
    }
    public void approveRequest(String name){ RequestApproved.add(name); }
    public void declineRequest(String name){
        RequestDeclined.add(name);
    }
    //through these two methods to approve or decline
    public void printRequest(PrintStream ps){
        ps.println("Requests Approved: ");
        ps.println(RequestApproved.toString());
        ps.println("Requests Declined: ");
        ps.println(RequestDeclined.toString());
    }

}
