package weqweqwe;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class weqwe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date nowTime = new Date();
		long systemTime = System.currentTimeMillis();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Scanner sc = new Scanner(System.in);
		String sa;
		sa = sc.next();
		long s=0;
		if(sa.equals("none")) s=systemTime;
		if(sa.equals("15s"))	s= systemTime-15*1000;
		if(sa.equals("30s"))	s= systemTime-30*1000;
		if(sa.equals("1m"))		s= systemTime-60*1000;
		if(sa.equals("30m"))	s= systemTime-1800*1000;
		if(sa.equals("1h"))		s= systemTime-3600*1000;
		if(sa.equals("1d"))		s= systemTime-86400*1000;
		System.out.println(sf.format(systemTime));
		System.out.println(sf.format(s));
	}

}
