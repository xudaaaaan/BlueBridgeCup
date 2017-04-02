/**
 * 递归实现字符的全排列
 * @author xudan
 *
 */
public class Quanpailie {
	static int c = 0;
	public static void f(char[]a, int k){

		if(k == a.length){
			for(int i = 0; i < a.length; i++){
				System.out.print(a[i] + " ");
			}
			System.out.println();
			c++;
		}
		for(int i = k; i < a.length; i++){
			char t = a[k];
			a[k] = a[i];
			a[i] = t;
			f(a,k + 1);
			char t2 = a[k];
			a[k] = a[i];
			a[i] = t2;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("####################");
		char[] a = "abcde".toCharArray();
		f(a,0);
		System.out.println("一共有" + c +"种排列方式。");
	}

}
