package rsa.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RSATest {
	/**
	 * 数据处理函数，实现幂的取余运算
	 * @param m
	 * @param e
	 * @param n
	 * @return
	 */
	static int calulateCi(int m, int e, int n)
	{
		int c = 1;
		e = e + 1;
		while (e > 1) {
			c = c * m;
			c = c % n;
			e--;
		}
		System.out.println(c);
		return c;
	}
	/**
	 * 公钥e与t的互素判断
	 * @param e
	 * @param t
	 * @return
	 */
	static int prime(int e, int t)
	{
		int g;
		while (t != 0) {
			g = e;
			e = t;
			t = g % t;
		}
		if (e == 1)
			return 0;// x与y互素时返回0
		else
			return 1;// x与y不互素时返回1
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		
		
		while(true){
			int p, q, e, d, m, n, t, c, r;
			System.out.println("请输入两个素数p,q:");
			BufferedReader strin = new BufferedReader(new InputStreamReader(
					System.in));
			p = Integer.parseInt(strin.readLine());
			BufferedReader strin1 = new BufferedReader(new InputStreamReader(
					System.in));
			q = Integer.parseInt(strin1.readLine());
			n = p * q;
			System.out.println("计算得n=" + n);
			t = (p - 1) * (q - 1);// 求n的欧拉数
			System.out.println("计算得t=" + t);
			System.out.println("请输入公钥e:");
			BufferedReader strin2 = new BufferedReader(new InputStreamReader(
					System.in));
			e = Integer.parseInt(strin2.readLine());
			if (e < 1 || e > t || prime(e, t) != 0) {
				System.out.println("e不合要求，请重新输入:");// e<1或e>t或e与t不互素时，重新输入
				BufferedReader strin3 = new BufferedReader(new InputStreamReader(
						System.in));
				e = Integer.parseInt(strin3.readLine());
			}
			d = 1;
			while (((e * d) % t) != 1)
				d++;// 由公钥e求出私钥d
			System.out.println("经计算d为" + d);
			while(true){
			System.out.println("加密请输入1");// 加密或解密选择
			System.out.println("解密请输入2");
			System.out.println("退出请输入3");
			BufferedReader strin4 = new BufferedReader(new InputStreamReader(
					System.in));
			r = Integer.parseInt(strin4.readLine());
			
				switch (r) {
				case 1:
					System.out.println("请输入明文m:");// 输入要加密的明文数字
					BufferedReader strin5 = new BufferedReader(new InputStreamReader(
							System.in));
					m = Integer.parseInt(strin5.readLine());
					c = calulateCi(m, e, n);
					System.out.println("密文为" + c);
					break;
				case 2:
					System.out.println("请输入密文c:");// 输入要解密的密文数字
					BufferedReader strin6 = new BufferedReader(new InputStreamReader(
							System.in));
					c = Integer.parseInt(strin6.readLine());
					m = calulateCi(c, d, n);
					System.out.println("明文为" + m);
					break;
				case 3:
					break;
				}
				if(r==3)break;
			}
			
		}
		
		
	}
}
