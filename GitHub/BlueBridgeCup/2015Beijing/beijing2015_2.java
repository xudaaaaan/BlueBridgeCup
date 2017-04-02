/**
 * 星系炸弹

在X星系的广袤空间中漂浮着许多X星人造“炸弹”，用来作为宇宙中的路标。
每个炸弹都可以设定多少天之后爆炸。
比如：阿尔法炸弹2015年1月1日放置，定时为15天，则它在2015年1月16日爆炸。
有一个贝塔炸弹，2014年11月9日放置，定时为1000天，请你计算它爆炸的准确日期。

请填写该日期，格式为 yyyy-mm-dd  即4位年份2位月份2位日期。比如：2015-02-19
请严格按照格式书写。不能出现其它文字或符号。
 * @author xudan
 *
 */
public class beijing2015_2 {
	public static void f(int y, int m, int d, int x){
		int[] leapyear = {0,31,29,31,30,31,30,31,31,30,31,30,31};
		int[] notleapyear = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int[] year;
		if( isLeapYear(y) ){
			year = leapyear;
		}else {year = notleapyear;}
		x += d;
		for(int mon = m;;mon++){
			if(mon == 13){
				mon = 1;
				y++;
				if( isLeapYear(y) ){
					year = leapyear;
				}else {year = notleapyear;}
			}
			if(x > year[mon]){
				x -= year[mon];
			}else{
				//int day = year[mon] - x;
				System.out.println(y + "-" + mon + "-" + x);
				return;
			}
			
		}
	}
	
	public static boolean isLeapYear(int y){
		if( (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0) ){
			return true;
		}else return false;
	}
	public static void main(String[] args) {
		f(2014,11,9,1000);
		f(2015,1,1,15);
		

	}

}
