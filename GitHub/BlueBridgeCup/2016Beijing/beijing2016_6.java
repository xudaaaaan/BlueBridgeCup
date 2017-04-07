/**
 * □ + □ = □
   □ - □ = □
   □ × □ = □
   □ ÷ □ = □
   
每个方块代表1~13中的某一个数字，但不能重复。
比如：
 6  + 7 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5

以及： 
 7  + 6 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5

就算两种解法。（加法，乘法交换律后算不同的方案）
你一共找到了多少种方案？
请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
 * @author xudan
 *
 */
public class beijing2016_6 {
	static int cnt = 0;
	static int[] a = new int[13];
	static int[] b = new int[14];
	
	public static void dfs(int x){
		if(x >= 3 && ((a[0] + a[1]) != a[2])) return;
		if(x >= 6 && ((a[3] - a[4]) != a[5])) return;
		if(x >= 9 && ((a[6] * a[7]) != a[8])) return;
		if(x == 12 && ((a[9] / a[10]) != a[11])) return;
		if(x == 12 && ((a[11] * a[10]) == a[9])) {cnt ++; return;}  //注意整数除法要转换成乘法
		else
		{
			for(int j = 1; j < 14; j++){
				if(b[j] == 0){
					a[x] = j;
					b[j] = 1;
					dfs(x+1);
					b[j] = 0;
				}
			}
		}
		return;
	}
	

	public static void main(String[] args) {
		for(int i = 1; i < 14; i++){
			b[i] = 0;
		}
		dfs(0);
		System.out.println(cnt);

	}

}
