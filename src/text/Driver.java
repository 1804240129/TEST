package text;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Driver {
   static float n=0;          //题目数
   static int stunumber=0;  //学生人数
   static Student [] arr = new Student[100];//添加数组用于成绩排序
   static String gradelist;//添加个人成绩单
   static String totallist="";//添加总成绩单
   

	public static void main(String args[]) throws IOException {
		
		Scanner scan=new Scanner(System.in);
		         if(check()==1) {
		        	 System.out.println("老师名字输入成功！");
		         }
		         else if(check()==0){
		        	 System.out.println("退出程序!");
		        	 return;
		         }
		         int select;
		         for(;;) {
		         System.out.println("--------------------------------------");
		         System.out.println("简单算术运算测验系统");
		         System.out.println("1出题 \n2答题\n3查询\n4排行榜\n按0退出");
		         System.out.println("--------------------------------------");
		     	select=scan.nextInt();
		     	switch(select) {
		     	case 0:
		     		System.out.println("退出成功!");
		     		return;
		     	case 1:
		     	   question();
		     	  System.out.println("--------------------------------------");
		     	    break;
		     	case 2:
		     		answer();
		     		System.out.println("已存档！ 存档路径为d:/网课/java/java.txt");
		     		System.out.println("--------------------------------------");
		     		break;
		     	case 3:
		     		inquire();
		     		System.out.println("--------------------------------------");
		     		break;
		     	case 4:
		     		rank();
		     		System.out.println("--------------------------------------");
		     		break;
		     		default:System.out.println("发生错误！重新输入");
		     		break;
		     	}
		     	}
	}
	public static void question() {
		int select1;
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入想要出题的数目 按0退出");
		
		select1=scan.nextInt();
		if(select1==0) {
			System.out.println("退出！");
		}
		else {
			n=select1;
		}
		System.out.println("数目为"+n);
	}
	public static void answer() throws IOException {//怎么操作全都进这里了..
		File file =new File("d:/网课/java/java.txt");
		Scanner scan=new Scanner(System.in);
		int i=0;//做的第i题
		
		if(n==0) {
	    System.out.println("题目数不能为空");
	    return;
		}
		 if(!file.exists()){
		       file.createNewFile();
		      }
		else {
			gradelist="";
			System.out.println("小朋友的名字是？");
			String name=scan.next();
			
			gradelist=gradelist+"名字："+name+"\n";//个人成绩单
			totallist=totallist+"名字："+name+"\n";//总成绩单
			
			stunumber=stunumber+1;//测试学生+1
			System.out.println("开始计算 ！注意除法除不尽保留小数点后八位");
			System.out.println("--------------------------------------");
			float inputResult = 0;        //接收用户输入的结果
			float x=100/n;
			float g=0;
	         do {
	            //实例化TestSystem类型对象
	             TestSystem ts = new TestSystem(Operate.getRandom(),Operate.getRandom(),Operate.getOperateEle());
	             System.out.println(ts);                    //输出表达式
	             inputResult = Operate.getInput();        //用户输入
	             
	             gradelist=gradelist+"问题："+ts+"\n"+" 正确答案："+ts.getResult()+" 这位同学的答案："+inputResult+"\n";//个人成绩单
	             totallist=totallist+"问题："+ts+"\n"+" 正确答案："+ts.getResult()+" 这位同学的答案："+inputResult+"\n";//总成绩单
	             
	             if( inputResult == ts.getResult() ) {    //回答正确，加上对应的分值分
	                 
	                 System.out.println( "回答正确!" );
	                 
	                 gradelist=gradelist+"回答正确!"+"\n";//个人成绩单
	                 totallist=totallist+"回答正确!"+"\n";//总成绩单
	                 
	                 System.out.println("开始计算 ！注意除法除不尽保留小数点后八位");
	                 System.out.println("--------------------------------------");
	                 
	                 g=g+x;            
	             }else {                                    //回答错误
	                 
	                 System.out.println( "回答错误！\n正确答案为"+ts.getResult() );
	                 
	                 gradelist=gradelist+"回答错误！"+"\n";//个人成绩单
	                 totallist=totallist+"回答错误！"+"\n";//总成绩单
	                 
	                 System.out.println("开始计算 ！注意除法除不尽保留小数点后八位");
	                 System.out.println("--------------------------------------");
	             }
	            i++;
	             
	            
	         }while(i < n);                                
	         System.out.println( "你获得了"+g+"分！" );
	         
	         gradelist=gradelist+"总成绩是"+g+"\n";//个人成绩单
	         totallist=totallist+"总成绩是"+g+"\n";//总成绩单
	         
	         SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
	 		 Date today=new Date();
	 		 String todayStr=df.format(today);     
	         Student st=new Student(name,g,todayStr);//时间
	         
	         FileReader fr=new FileReader(file);
	         BufferedReader bf=new BufferedReader(fr);
	         String before=bf.readLine();
	         FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw);
             bw.write(before+st.toString());
             bw.close();
             bf.close();//存入文件
             
             arr[stunumber-1]=st;//存入数组中用于后两个两个阶段
	     }
		}
	

public static void inquire() {
	Scanner scan=new Scanner(System.in);
	int select;
	for(;;) {
	 System.out.println("1学生查询个人成绩单 \n2老师查询总成绩单\n按0退出");
     System.out.println("--------------------------------------");
 	select=scan.nextInt();
	switch(select) {
	case 0:
		System.out.println("退出成功！");
 		return;
	case 1:	
		System.out.println("学生个人成绩单");
		System.out.println(gradelist);
		break;
	case 2:	
		System.out.println("总成绩单");
		System.out.println(totallist);
		break;
	default:System.out.println("发生错误！重新输入");
		break;
	}
	}
	}
public static void rank() {
	if(stunumber==0) {
		System.out.println("需要有学生!");
	}
	System.out.println("按照学生成绩升序排序");
	for(int i=0;i<stunumber;i++) {
		for(int j=i+1;j<stunumber;j++) {
			if(arr[i].getGrade()>arr[j].getGrade()) {
				Student x=arr[i];
				arr[i] =arr[j];
				arr[j]=x;
			}
		}
	}
   for(int h=0;h<stunumber;h++) {
	   System.out.println(arr[h]+"");
   }

	}
public static int  check() {
	Scanner scan=new Scanner(System.in);
	
	for(int i=1;i<=3;i++) {
	System.out.println("请输入老师的名字（小明）");
	String name=scan.next();
	if(name.equals("xiaoming")|| name.equals("小明")) {
		return 1;
	}
	else {
		System.out.println("老师名字输入错误请重新输入 这是你第"+i+"次输入错误 三次之后关闭程序");
	}
	}
	return 0;
}
	}
