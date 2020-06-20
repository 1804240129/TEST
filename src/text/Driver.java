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
   static float n=0;          //��Ŀ��
   static int stunumber=0;  //ѧ������
   static Student [] arr = new Student[100];//����������ڳɼ�����
   static String gradelist;//��Ӹ��˳ɼ���
   static String totallist="";//����ܳɼ���
   

	public static void main(String args[]) throws IOException {
		
		Scanner scan=new Scanner(System.in);
		         if(check()==1) {
		        	 System.out.println("��ʦ��������ɹ���");
		         }
		         else if(check()==0){
		        	 System.out.println("�˳�����!");
		        	 return;
		         }
		         int select;
		         for(;;) {
		         System.out.println("--------------------------------------");
		         System.out.println("�������������ϵͳ");
		         System.out.println("1���� \n2����\n3��ѯ\n4���а�\n��0�˳�");
		         System.out.println("--------------------------------------");
		     	select=scan.nextInt();
		     	switch(select) {
		     	case 0:
		     		System.out.println("�˳��ɹ�!");
		     		return;
		     	case 1:
		     	   question();
		     	  System.out.println("--------------------------------------");
		     	    break;
		     	case 2:
		     		answer();
		     		System.out.println("�Ѵ浵�� �浵·��Ϊd:/����/java/java.txt");
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
		     		default:System.out.println("����������������");
		     		break;
		     	}
		     	}
	}
	public static void question() {
		int select1;
		Scanner scan=new Scanner(System.in);
		System.out.println("��������Ҫ�������Ŀ ��0�˳�");
		
		select1=scan.nextInt();
		if(select1==0) {
			System.out.println("�˳���");
		}
		else {
			n=select1;
		}
		System.out.println("��ĿΪ"+n);
	}
	public static void answer() throws IOException {//��ô����ȫ����������..
		File file =new File("d:/����/java/java.txt");
		Scanner scan=new Scanner(System.in);
		int i=0;//���ĵ�i��
		
		if(n==0) {
	    System.out.println("��Ŀ������Ϊ��");
	    return;
		}
		 if(!file.exists()){
		       file.createNewFile();
		      }
		else {
			gradelist="";
			System.out.println("С���ѵ������ǣ�");
			String name=scan.next();
			
			gradelist=gradelist+"���֣�"+name+"\n";//���˳ɼ���
			totallist=totallist+"���֣�"+name+"\n";//�ܳɼ���
			
			stunumber=stunumber+1;//����ѧ��+1
			System.out.println("��ʼ���� ��ע���������������С������λ");
			System.out.println("--------------------------------------");
			float inputResult = 0;        //�����û�����Ľ��
			float x=100/n;
			float g=0;
	         do {
	            //ʵ����TestSystem���Ͷ���
	             TestSystem ts = new TestSystem(Operate.getRandom(),Operate.getRandom(),Operate.getOperateEle());
	             System.out.println(ts);                    //������ʽ
	             inputResult = Operate.getInput();        //�û�����
	             
	             gradelist=gradelist+"���⣺"+ts+"\n"+" ��ȷ�𰸣�"+ts.getResult()+" ��λͬѧ�Ĵ𰸣�"+inputResult+"\n";//���˳ɼ���
	             totallist=totallist+"���⣺"+ts+"\n"+" ��ȷ�𰸣�"+ts.getResult()+" ��λͬѧ�Ĵ𰸣�"+inputResult+"\n";//�ܳɼ���
	             
	             if( inputResult == ts.getResult() ) {    //�ش���ȷ�����϶�Ӧ�ķ�ֵ��
	                 
	                 System.out.println( "�ش���ȷ!" );
	                 
	                 gradelist=gradelist+"�ش���ȷ!"+"\n";//���˳ɼ���
	                 totallist=totallist+"�ش���ȷ!"+"\n";//�ܳɼ���
	                 
	                 System.out.println("��ʼ���� ��ע���������������С������λ");
	                 System.out.println("--------------------------------------");
	                 
	                 g=g+x;            
	             }else {                                    //�ش����
	                 
	                 System.out.println( "�ش����\n��ȷ��Ϊ"+ts.getResult() );
	                 
	                 gradelist=gradelist+"�ش����"+"\n";//���˳ɼ���
	                 totallist=totallist+"�ش����"+"\n";//�ܳɼ���
	                 
	                 System.out.println("��ʼ���� ��ע���������������С������λ");
	                 System.out.println("--------------------------------------");
	             }
	            i++;
	             
	            
	         }while(i < n);                                
	         System.out.println( "������"+g+"�֣�" );
	         
	         gradelist=gradelist+"�ܳɼ���"+g+"\n";//���˳ɼ���
	         totallist=totallist+"�ܳɼ���"+g+"\n";//�ܳɼ���
	         
	         SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
	 		 Date today=new Date();
	 		 String todayStr=df.format(today);     
	         Student st=new Student(name,g,todayStr);//ʱ��
	         
	         FileReader fr=new FileReader(file);
	         BufferedReader bf=new BufferedReader(fr);
	         String before=bf.readLine();
	         FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw);
             bw.write(before+st.toString());
             bw.close();
             bf.close();//�����ļ�
             
             arr[stunumber-1]=st;//�������������ں����������׶�
	     }
		}
	

public static void inquire() {
	Scanner scan=new Scanner(System.in);
	int select;
	for(;;) {
	 System.out.println("1ѧ����ѯ���˳ɼ��� \n2��ʦ��ѯ�ܳɼ���\n��0�˳�");
     System.out.println("--------------------------------------");
 	select=scan.nextInt();
	switch(select) {
	case 0:
		System.out.println("�˳��ɹ���");
 		return;
	case 1:	
		System.out.println("ѧ�����˳ɼ���");
		System.out.println(gradelist);
		break;
	case 2:	
		System.out.println("�ܳɼ���");
		System.out.println(totallist);
		break;
	default:System.out.println("����������������");
		break;
	}
	}
	}
public static void rank() {
	if(stunumber==0) {
		System.out.println("��Ҫ��ѧ��!");
	}
	System.out.println("����ѧ���ɼ���������");
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
	System.out.println("��������ʦ�����֣�С����");
	String name=scan.next();
	if(name.equals("xiaoming")|| name.equals("С��")) {
		return 1;
	}
	else {
		System.out.println("��ʦ��������������������� �������"+i+"��������� ����֮��رճ���");
	}
	}
	return 0;
}
	}
