package javademo;

import java.util.Random;
import java.util.Scanner;

public class randomGame {
     public static void main(String[] args) {
	Random r = new Random();
	int num = r.nextInt(100);
	Scanner sc = new Scanner(System.in);
	System.out.println("请猜测");
	int guessNum;
	while(true) {
		guessNum = sc.nextInt();
		if(num>guessNum) {
			System.out.println("小");
		}else if(num<guessNum){
			System.out.println("大");
		}else {
			System.out.println("正确");
		}
	}
	 
	
}
     
     
}
