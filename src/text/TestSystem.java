package text;

public class TestSystem {
	 private float num1;            //声明两个操作数
	      private float num2;
	      private String operateEle;        //声明操作符
	      private static int grade = 0;        //记录最后得分
	      
	      //定义无参构造方法
	      public TestSystem() {
	          
	      }
	      
	      //定义带参数的构造方法
	      public TestSystem(float num1,float num2,String operateEle) {
	          
	          this.num1 = num1;
	          this.num2 = num2;
	          this.operateEle = operateEle;
	      }
	  
	      //设置setter()和getter()方法
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
	      
	      //覆写toString()方法
	      public String toString() {
	          
	          return this.num1 + this.operateEle + this.num2;
	      }
	      
	      //取得表达式的正确结果
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
	      
	      //向屏幕输出总成绩
	      public static float getGrade() {
	          
	           return TestSystem.grade ;
	      }
	     
	     
	      
	      //将总成绩清零
	      public static void clear() {
	  
	         TestSystem.grade = 0;
	      }
	      
	      
}
