package Shape;

import java.util.Calendar;

public class HelloMessage {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println("������ �ð��� " + cal.get(Calendar.HOUR_OF_DAY)+
				"��" +cal.get(Calendar.MINUTE)+"���Դϴ�.");
		if(Calendar.HOUR_OF_DAY>=4 || Calendar.HOUR_OF_DAY<12)
			System.out.println("Good Morning");
		else if(Calendar.HOUR_OF_DAY<22)
			System.out.println("Good Afternoon!");
		else 
			System.out.println("Good Night!");
	}

}
