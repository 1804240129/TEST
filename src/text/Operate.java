package text;
 import java.util.Random;
 import java.util.Scanner;
public class Operate {
	 //定义方法，返回一个10以内的随机数
	     public static int getRandom() {
	         
	         Random ran = new Random();
	         
	         return ran.nextInt(10);  
	     }
	     
	     //定义方法，返回操作符
     public static String getOperateEle() {
	         
	         String[] operateEle = {"+","-","*","/"};
	         Random ran = new Random();
	         
	         return operateEle[ran.nextInt(4)];
	    }
	     
	     
     //定义方法，取得用户输入的结果
     public static float getInput() {
	         
	         Scanner scan = new Scanner(System.in);        //实例化Scanner对象
	         float result = 0;
	        
	         System.out.println( "请输入结果：" );
         result = scan.nextFloat();
	         return result;
	         
	     }
}
