/**
 * 整数划分问题。输入一个整数并打印所有划分。
 * @author xudan
 *
 */
import java.util.Scanner;
//a[]:缓存  k：a的第几个元素
public class IntSeparation {
	public static void f(int n, int[] a, int k){
		if(n <= 0) {
			for(int i = 0; i < k-1; i++){
				System.out.print(a[i] + " + ");
			}
			System.out.println(a[k-1]);
			return;
		}
		for(int i = n; i > 0; i--){
			if(k > 0 && i > a[k - 1]){//顺序不能颠倒
				continue;}
			a[k] = i;
			f(n - i,a,k + 1);//传入的参数为k+1，并不改变K的值。
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(" Please enter an integer:");
		int n = input.nextInt();
		int[] a = new int[100];
		f(n,a,0);
		input.close();

	}

}

/**
 * results:
 * Please enter an integer:
6
6
5 + 1
4 + 2
4 + 1 + 1
3 + 3
3 + 2 + 1
3 + 1 + 1 + 1
2 + 2 + 2
2 + 2 + 1 + 1
2 + 1 + 1 + 1 + 1
1 + 1 + 1 + 1 + 1 + 1
**/

