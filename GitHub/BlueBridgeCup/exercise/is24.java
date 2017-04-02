/**
 *输入4个数，找到一种方法，+ - * ／ 四则运算得到24.
 *用随机算法解决。
 * @author xudan
 *
 */
import java.util.Scanner;
import java.util.Stack;

public class is24 {
	public static String random_op(){
		 int n = (int)(Math.random() * 4);//n：0、1、2、3
		 if(n == 0) return "+";
		 if(n == 1) return "-";
		 if(n == 2) return "*";
		 else return "/";
	}
	
	public static void shuffle(String[] a){
		for(int i = 0; i < a.length;i++){
			int index = (int)(Math.random() * a.length);
			String temp = a[i];
			a[i] = a[index];
			a[index] = temp;
		}
	}
	
	public static boolean isOper(String s){
		if(s == "+" || s == "-" || s == "*" || s == "/" ){
			return true;
		}return false;
	}
	
	public static int op(int x,int y, String oper) throws Exception{
		if(oper == "+") return x + y;
		if(oper == "-") return x - y;
		if(oper == "*") return x * y;
		else return x / y;
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean calcu(String[] a){
		Stack stk = new Stack();
		try{
		for(int i = 0; i < a.length; i++){
			if(isOper(a[i])){
				int x = Integer.parseInt((String) stk.pop());//Parses the string argument as a signed decimal integer. 
									    //The characters in the string must all be decimal digits
				int y = Integer.parseInt((String) stk.pop());
				stk.push(op(x,y,a[i]) + "");	
			}else{
				stk.push(a[i]);
			}
		}
		
		}catch (Exception e){
			return false;
		}
		if(stk.size()==1 && stk.pop().equals("24")){
			return true;
		}else return false;
		
	}
	
	
	public static void show(String[] a){
		Stack stk = new Stack();
		for(int i = 0; i < a.length; i++){
			if(isOper(a[i])){
				stk.push("(" + stk.pop() + a[i] + stk.pop() + ")");
			}else{
				stk.push(a[i]);
			}
		}
		System.out.println(stk.pop());
		
	}
	
	public static void f(String[] ss){
		for(int k = 0; k < 100000; k++){
			String[] a = new String[7];
			for(int i = 0; i < 4; i++){
				 a[i] = ss[i];
			 }
			for(int i = 4; i < 7;i++){
				a[i] = random_op();
			}
			//打乱数组a
			shuffle(a);
			if(calcu(a)){
				show(a);
				return;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter 4 integers:");
		Scanner scan = new Scanner(System.in);
		String[] ss = scan.nextLine().split(" ");
		f(ss);
		scan.close();
		

	}

}



/*Enter 4 integers:
  3 4 5 6
  (((5+3)-4)*6)
*/
