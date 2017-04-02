/**
 * 30个学生的班级，生日恰好在同一天的概率？
 * @author xudan
 *
 */
public class birthday {

	public static void main(String[] args) {
		int N = 100000;
		int M = 0;
		for(int j = 0; j< N;j++){
			int[] year = new int[365];
			for(int i = 0; i < 30; i++){
				int day = (int)(Math.random() * 365 );
				if(year[day]==1) {M ++ ;break;}
				year[day] = 1;
			}
		}
		System.out.println((double)M / N);

	}

}
