package javademo;

import java.util.Random;

public class demoRandom {
	public static void main(String[] args) {
		Random r = new Random();
		int fun = fun(10);
		System.out.println(fun);
	}
	
	
	public static int fun(int a) {
		Random r = new Random();
		int num = r.nextInt(a+1);
		return num;
	}
}
