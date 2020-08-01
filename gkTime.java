import java.util.Scanner;
public class gkTime {
	public static void main(String args [] ) {
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter Time 1 in HHMMSS format");
		int time1=sc.nextInt();
		System.out.println("Enter Time 2 in HHMMSS format");
		int time2=sc.nextInt();
		//System.out.println("Time1:"+time1+"  Time2:"+time2);
		
		int time1SS=time1%100;
		int time1MM=((time1/100)%100)*60;
		int time1HH=(time1/10000)*3600;
		int time1sec=time1SS+time1MM+time1HH;
		int time2SS=time2%100;
		int time2MM=((time2/100)%100)*60;
		int time2HH=(time2/10000)*3600;
		int time2sec=time2SS+time2MM+time2HH;
		
		//System.out.println("Time1sec:"+time1sec+"Time2sec:"+time2sec);
		int timeDif= time1sec-time2sec;
		int timeDifformat=(timeDif/3600)*10000;
		timeDifformat=timeDifformat+(timeDif%3600)/60*100;
		timeDifformat=timeDifformat + timeDif%60;
		System.out.println("TimeDifference  "+timeDifformat);
		
		sc.close();

	}
}