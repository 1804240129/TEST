package text;

public class TestSystem {
	 private float num1;            //��������������
	      private float num2;
	      private String operateEle;        //����������
	      private static int grade = 0;        //��¼���÷�
	      
	      //�����޲ι��췽��
	      public TestSystem() {
	          
	      }
	      
	      //����������Ĺ��췽��
	      public TestSystem(float num1,float num2,String operateEle) {
	          
	          this.num1 = num1;
	          this.num2 = num2;
	          this.operateEle = operateEle;
	      }
	  
	      //����setter()��getter()����
	      public float getNum1() {
	          return num1;
	      }
	  
	     public void setNum1(float num1) {
	         this.num1 = num1;
	      }
	  
	      public float getNum2() {
	          return num2;
	      }
	  
	      public void setNum2(float num2) {
	          this.num2 = num2;
	      }
	      
	      //��дtoString()����
	      public String toString() {
	          
	          return this.num1 + this.operateEle + this.num2;
	      }
	      
	      //ȡ�ñ��ʽ����ȷ���
	      public float getResult() {
	          
	         float result = 0;
	          switch(this.operateEle) {
	         
	              case "+": result = this.num1 + this.num2;break;
	              
	              case "-": result =  this.num1 - this.num2;break;
	              
	              case "*": result =  this.num1 * this.num2;break;
	              
	             case "/": result =  this.num1 / this.num2;break;
	          }
	          
	          return result;
	     }
	      
	      //����Ļ����ܳɼ�
	      public static float getGrade() {
	          
	           return TestSystem.grade ;
	      }
	     
	     
	      
	      //���ܳɼ�����
	      public static void clear() {
	  
	         TestSystem.grade = 0;
	      }
	      
	      
}
