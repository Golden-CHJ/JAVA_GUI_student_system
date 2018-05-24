package student_system;

public class Student {
   String s_no="NULL";
   String s_name="NULL";
   String s_c="0";
   String s_m="0";
   String s_e="0";
   int s=0;
    public Student(String no,String name,String c,String m,String e) {
	// TODO Auto-generated constructor stub
    	s_no=no;
    	s_name=name;
    	s_c=c;
    	s_e=e;
    	s_m=m;
    	 int a = Integer.parseInt(s_c);
    	 int b = Integer.parseInt(s_e);
    	 int d = Integer.parseInt(s_m);
    	 s=a+b+d;
    }
    public Student() {
    	// TODO Auto-generated constructor stub
       
    }
    public String getSum() {
    	return ""+s;
    }
   
}
