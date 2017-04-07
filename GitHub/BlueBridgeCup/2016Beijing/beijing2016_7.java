/**
 * 剪邮票

如【图1.jpg】, 有12张连在一起的12生肖的邮票。
现在你要从中剪下5张来，要求必须是连着的。
（仅仅连接一个角不算相连）
比如，【图2.jpg】，【图3.jpg】中，粉红色所示部分就是合格的剪取。

请你计算，一共有多少种不同的剪取方法。

请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。

 * @author xudan
 *
 */
public class beijing2016_7 {
	static int[][] near = {{0,0,0,0},
			{2,5},
			{1,3,6},
			{2,4,7},
			{3,8},
			{1,6,9},
			{2,5,7,10},
			{3,6,8,11},
			{4,7,12},
			{5,10},
			{6,9,11},
			{7,10,12},
			{8,11}};
	//a为剪好的5个方格内的数字组成的数组，判断它们是否符合要求
	public static boolean test(int[] a){
		int[] flag =  new int[a.length - 1];
		for(int i= 0; i < a.length - 1;i++){
			for(int j = 0; j < a.length - 1;j++){
				if(i == j) continue;
				else{
					for(int k = 0; k < near[a[i]].length;k++){
						if (a[j] == near[a[i]][k]){
							flag[i] = 1;;
							break;
						}
					}
				}
				if(flag[i] == 1) break;
			}
		}
		if(flag[0]==flag[1]&&flag[0]==flag[2]&&flag[0]==flag[3]&&flag[0]==1) return true;
		else return false;
	}
	
	
	static int all = 0;
	static int[] isVisited= new int[13]; 
	public static void f(int[] a, int k){
		if(k == 5){
			if(test(a)) {all++;
			for(int i = 0; i < a.length - 1;i++){
			System.out.print(a[i] + " ");
			}
			System.out.println();return;}
			else return;
		}
		for(int i = 1; i < 13;i++){
			if(isVisited[i] == 0){
				a[k] = i;
				isVisited[i] = 1;
				f(a,k + 1);
				isVisited[i] = 0;
			}
			
		}
	}
	public static void main(String[] args) {
		for(int i = 1; i<=12; i++){
			isVisited[i] = 0;
		}
		int[] a = new int[6];
		f(a,0);
		System.out.println(all/120); 
		
		
	} 
		
	/*static int[] isVisited= new int[13]; 
	static int[][] near = {{0,0,0,0},
			{2,5},
			{1,3,6},
			{2,4,7},
			{3,8},
			{1,6,9},
			{2,5,7,10},
			{3,6,8,11},
			{4,7,12},
			{5,10},
			{6,9,11},
			{7,10,12},
			{8,11}};
	static int all = 0;
	
	
	public static void f(int[] a, int k){
		if(k==0){
			for(int i = 1; i <= 12; i++){
					a[k] = i;
					isVisited[i] = 1;
					f(a,k + 1);
					isVisited[i] = 0;
			}
		} 
		if(k == 5){
			all++;
			return;
		}
		else{
			for(int i = 0;i < k;i++){
				for(int j = 0;j < near[a[i]].length; j ++){
					if(isVisited[near[a[i]][j]] == 0){
						a[k] = near[a[i]][j];
						isVisited[near[a[i]][j]] = 1;
						f(a, k + 1);
						isVisited[near[a[i]][j]] = 0;
					}
				}
			}
		}
	}
*/
	

}
