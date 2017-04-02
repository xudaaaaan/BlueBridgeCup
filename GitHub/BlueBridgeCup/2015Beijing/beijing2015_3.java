/**
 * 九数分三组

1~9的数字可以组成3个3位数，设为：A,B,C,  现在要求满足如下关系：
B = 2 * A
C = 3 * A

请你写出A的所有可能答案，数字间用空格分开，数字按升序排列。

注意：只提交A的值，严格按照格式要求输出。
 * @author xudan
 *
 */
public class beijing2015_3 {
	public static boolean charSame(String s1,String s2){
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		for(int i = 0; i < a1.length;i++){
			for(int j = i + 1;j < a1.length;j++){
				if(a1[i] == a1[j]){
					return true;
				}
			}
		}
		for(int i = 0; i < a2.length;i++){
			for(int j = i + 1;j < a2.length;j++){
				if(a2[i] == a2[j]){
					return true;
				}
			}
		}
		for(int i = 0; i < a1.length; i++){
			for(int j = 0; j< a2.length; j++){
				if(a1[i] == a2[j]){
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		for(int i = 1; i < 4; i++){
			for(int j = 1; j < 10; j++){
				for(int k = 1; k < 10; k++){
					if(i == j || i == k || j == k) {continue;}
					int n = i * 100 + j * 10 + k;
					int n1 = n * 2, n2 = n * 3;
					if(n1 > 987 || n2 > 987) continue;
					String sn = Integer.toString(n);
					String sn1 = Integer.toString(n1);
					String sn2 = Integer.toString(n2);
					if(charSame(sn,sn1)||charSame(sn,sn2)||charSame(sn2,sn1)){
						continue;
					}else{
						System.out.print(n + " ");
					}
					
					
					
					
					/*
					int h1 = n1/100,h2=n2/100,t1=(n1-h1*100)/10,t2=(n2-h2*100)/10,o1=n1-h1*100-t1*10,o2=n2-h2*100-t2*10;
					if((h1==i)||(h1==j)||(h1==k)
							||(t1==i)||(t1==j)||(t1==k)
							||(o1==i)||(o1==j)||(o1==k)
							||(o2==i)||(o2==j)||(o2==k)
							||(t2==i)||(t2==j)||(t2==k)
							||(h2==i)||(h2==j)||(h2==k)){
						continue;
					}
					else{
						System.out.print(n + " ");
					}*/
					
					
			}
		}

	}

	}}
