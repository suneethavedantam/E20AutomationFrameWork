package practice;

public class GenericMetodSubtraction {

	public static void main(String[] args) {
		
		int sub=sub(30,20);
		System.out.println(sub);
		System.out.println(sub(40,30));
		System.out.println(sub(50,40));
		int res =sub(60,50);
		System.out.println(res);
		
	}
	public static int sub(int a,int b)
	{
		int c=a-b;
		return c;
	}

}
