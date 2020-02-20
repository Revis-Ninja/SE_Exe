package basic;

import java.io.PrintStream;

public class person {
    String name;
    date birth;
    public person(String name, date birth){
        this.name = name;
        this.birth = birth;
    }
    public void print(PrintStream ps){
        ps.print(this.name);
        this.birth.print(ps);
    }
    public String getName(){
        return this.name;
    }

    public date getBirth() {
        return birth;
    }
}
