package rsa.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaDateTest {
	
	public static void main(String[] args){
		Date dt = new Date();
		System.out.println(dt.toString());   //java.util.Date�ĺ���
		long lSysTime1 = dt.getTime()/1000;   //�õ�������Date���͵�getTime()���غ�����
		System.out.println(lSysTime1); 
		//��long����ת����Date����
		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		//ǰ���lSysTime���������ȳ�1000�õ�����������תΪjava.util.Date����
		dt = new Date(lSysTime1 * 1000);  
		String sDateTime = sdf.format(dt);  //�õ���ȷ����ı�ʾ��08/31/2006 21:08:00
		System.out.println(sDateTime);


	}
}
