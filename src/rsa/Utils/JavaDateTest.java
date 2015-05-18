package rsa.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaDateTest {
	
	public static void main(String[] args){
		Date dt = new Date();
		System.out.println(dt.toString());   //java.util.Date的含义
		long lSysTime1 = dt.getTime()/1000;   //得到秒数，Date类型的getTime()返回毫秒数
		System.out.println(lSysTime1); 
		//由long类型转换成Date类型
		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		//前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
		dt = new Date(lSysTime1 * 1000);  
		String sDateTime = sdf.format(dt);  //得到精确到秒的表示：08/31/2006 21:08:00
		System.out.println(sDateTime);


	}
}
