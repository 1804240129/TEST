package text;
 import java.util.Random;
 import java.util.Scanner;
public class Operate {
	 //���巽��������һ��10���ڵ������
	     public static int getRandom() {
	         
	         Random ran = new Random();
	         
	         return ran.nextInt(10);  
	     }
	     
	     //���巽�������ز�����
     public static String getOperateEle() {
	         
	         String[] operateEle = {"+","-","*","/"};
	         Random ran = new Random();
	         
	         return operateEle[ran.nextInt(4)];
	    }
	     
	     
     //���巽����ȡ���û�����Ľ��
     public static float getInput() {
	         
	         Scanner scan = new Scanner(System.in);        //ʵ����Scanner����
	         float result = 0;
	        
	         System.out.println( "����������" );
         result = scan.nextFloat();
	         return result;
	         
	     }
}
