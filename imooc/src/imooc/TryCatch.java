package imooc;

public class TryCatch {

	public static void main(String[] args) {
 TryCatch tct=new TryCatch();
 int result=tct.test();
 System.out.println(result);

	}
	public int test() {
		try{
		int divider=10;
		int result=100;
		while(divider>-1) {
			divider--;
			result=result+100/divider;
		}
		return result;
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println("程序异常");
		return -1;
		}
	}
}
