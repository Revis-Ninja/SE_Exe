package management;

import java.util.ArrayList;

public class Admin {
    ArrayList<String> LoTR;

    public Admin(){
        LoTR = new ArrayList<String>();
    }
    public void getTeachingRequirement(ArrayList<String> LoTR){
        this.LoTR = LoTR;
    }
}
