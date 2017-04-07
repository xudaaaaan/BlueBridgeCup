/**
 * 搭积木

小明最近喜欢搭数字积木，
一共有10块积木，每个积木上有一个数字，0~9。

搭积木规则：
每个积木放到其它两个积木的上面，并且一定比下面的两个积木数字小。
最后搭成4层的金字塔形，必须用完所有的积木。

下面是两种合格的搭法：

   0
  1 2        h i
 3 4 5      e f g
6 7 8 9    a b c d   10个

   0
  3 1
 7 5 2
9 8 6 4    

请你计算这样的搭法一共有多少种？
 * @author xudan
 *
 */
public class beijing2016_3 {
	static int[] a = new int[10];
	static int[] b = new int[10];
	static int cnt = 0;
    static boolean test(int n){
    		if(n == 2){
    			if(a[2] > a[0] && a[1] > a[0])  return true;
    			else return false;
    		}
    		if(n == 5){
    			if(a[3] > a[1]&&a[4] > a[1] && a[4] > a[2] && a[5] > a[2])  return true;
    			else return false;
    		}
    		if(n == 9){
    			if((a[6] > a[3]&&
    				a[7] > a[3] && a[7] > a[4]&&
    				a[8] > a[4]&&a[8] > a[5]&&
    				a[9] > a[5]))  {cnt++;return true; }
    			else return false;
    		}
    		return true;
    }
	static void dfs(int x){
		
		for(int i = 0; i < 10; i ++){
			if(b[i] == 0){
				a[x] = i;
				b[i] = 1;
				if(test(x)){
					dfs(x + 1);
					b[i] = 0;
				}
				else b[i] = 0;
			}
		}return;
	}
	public static void main(String[] args) {
	
		for(int i = 0; i < 10; i++){
			b[i] = 0;
		}
		
		dfs(0);
		System.out.println(cnt);

	}

}
