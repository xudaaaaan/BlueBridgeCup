/**
 * 熊怪吃核桃
 * 森林里有一只熊怪，很爱吃核桃。不过它有个习惯，每次都把找到的核桃分成相等的两份，吃掉一份，留一份。
 * 如果不能等分，熊怪就会扔掉一个核桃再分。第二天再继续这个过程，直到最后剩一个核桃了，直接丢掉。
 * 有一天，熊怪发现了1543个核桃，请问，它在吃这些核桃的过程中，一共要丢掉多少个核桃。
 * 请填写该数字（一个整数），不要填写任何多余的内容或说明文字。
 * @author xudan
 *
 */
public class beijing2015_1 {

	public static void main(String[] args) {
		int sum = 1543, x = 0;
		while(sum != 0){
			if(sum % 2 == 0){
				sum = sum / 2;
			}else{
				sum = (sum - 1)/2;
				x++;
			}
		}
		System.out.println(x);
	}

}

//输出：5
