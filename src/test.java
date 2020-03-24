import java.util.Map;
import java.util.TreeMap;

public class test {
	int a = 1; // 전역변수
	int b = 2;
	static int c = 3;

	public static void main(String[] args) {
		int a = 1;
		test test = new test();
		test.funtion(a);

		funtion2(a); // static으로 선언된 정적메소드, 인스턴트없이 사용가능asd
	}
	private static void funtion2(int a) {
		c = a;
		System.out.println(c);
		// System.out.println(b);
		// b가 static으로 선언되지 않았기 때문에 불가능
	}
	private void funtion(int a) {
		this.a = a;
		// 전역변수 a와 지역변수 a가 이름이 같기 때문에
		// 전역변수에 접근하기 위해서 this를 붙인다
		// this.a는 전역변수 a
		b = a;
		// 전역변수 b
		c = a;
		// static으로 선언되었어도 당연히 가능
		System.out.println("\n"+ a + " "+ b +" "+ c);
	}
}
