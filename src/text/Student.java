package text;

import java.util.Scanner;

public class Student {
    private String name;
    private float grade;
    private String time;
    public Student(String name,float grade,String time) {
 	   super();
 	   this.name=name;
 	   this.grade=grade;
 	   this.time=time;
    }
    public String getName() {
 	   return name;
    }
    public void setName(String name) {
 	   this.name=name;
    }
    public Float getGrade() {
 	   return grade;
    }
    public void setGrade(float grade) {
 	   this.grade=grade;
    }
    public String getTime() {
 	   return time;
    }
    public void setID(String time) {
 	   this.time=time;
    }
    public String toString() {
 	   String msg;
 	   msg="ѧ�����֣�"+this.name;
 	   msg+= "  ѧ������:"+this.grade;
 	   msg+="  ����ʱ��:"+this.time;
 	   
 	   return msg;
    }
}
