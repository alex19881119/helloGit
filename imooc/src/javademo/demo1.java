package javademo;

import java.util.Scanner;

public class demo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("第1个数");
		int a = sc.nextInt();
		System.out.println("第2个数");
		int b = sc.nextInt();
		System.out.println("第3个数");
		int c = sc.nextInt();
		int temp = a>b? a:b;
		int max = c>temp? c:temp;
		System.out.println(max);
	}
}
