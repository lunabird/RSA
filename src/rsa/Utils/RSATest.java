package rsa.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RSATest {
	/**
	 * ���ݴ�������ʵ���ݵ�ȡ������
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
	 * ��Կe��t�Ļ����ж�
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
			return 0;// x��y����ʱ����0
		else
			return 1;// x��y������ʱ����1
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		
		
		while(true){
			int p, q, e, d, m, n, t, c, r;
			System.out.println("��������������p,q:");
			BufferedReader strin = new BufferedReader(new InputStreamReader(
					System.in));
			p = Integer.parseInt(strin.readLine());
			BufferedReader strin1 = new BufferedReader(new InputStreamReader(
					System.in));
			q = Integer.parseInt(strin1.readLine());
			n = p * q;
			System.out.println("�����n=" + n);
			t = (p - 1) * (q - 1);// ��n��ŷ����
			System.out.println("�����t=" + t);
			System.out.println("�����빫Կe:");
			BufferedReader strin2 = new BufferedReader(new InputStreamReader(
					System.in));
			e = Integer.parseInt(strin2.readLine());
			if (e < 1 || e > t || prime(e, t) != 0) {
				System.out.println("e����Ҫ������������:");// e<1��e>t��e��t������ʱ����������
				BufferedReader strin3 = new BufferedReader(new InputStreamReader(
						System.in));
				e = Integer.parseInt(strin3.readLine());
			}
			d = 1;
			while (((e * d) % t) != 1)
				d++;// �ɹ�Կe���˽Կd
			System.out.println("������dΪ" + d);
			while(true){
			System.out.println("����������1");// ���ܻ����ѡ��
			System.out.println("����������2");
			System.out.println("�˳�������3");
			BufferedReader strin4 = new BufferedReader(new InputStreamReader(
					System.in));
			r = Integer.parseInt(strin4.readLine());
			
				switch (r) {
				case 1:
					System.out.println("����������m:");// ����Ҫ���ܵ���������
					BufferedReader strin5 = new BufferedReader(new InputStreamReader(
							System.in));
					m = Integer.parseInt(strin5.readLine());
					c = calulateCi(m, e, n);
					System.out.println("����Ϊ" + c);
					break;
				case 2:
					System.out.println("����������c:");// ����Ҫ���ܵ���������
					BufferedReader strin6 = new BufferedReader(new InputStreamReader(
							System.in));
					c = Integer.parseInt(strin6.readLine());
					m = calulateCi(c, d, n);
					System.out.println("����Ϊ" + m);
					break;
				case 3:
					break;
				}
				if(r==3)break;
			}
			
		}
		
		
	}
}
