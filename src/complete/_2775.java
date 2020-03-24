import java.util.Scanner;

public class _2775 {
	static int[][] arr = new int[14][15];
//	static int count = 1;
	static int x,y;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=0; i<num; i++) {
			x = sc.nextInt(); // 층 수
			y = sc.nextInt(); // 호 수
//			apart(x,y);
			System.out.println(apart(x,y));
		}
	}

	private static int apart(int k, int n) {
		arr[0][0] = 1;		
		if(k>0 && n>0) {
			apart(k,n-1);
			apart(k-1,n);			
		}
		int a = n;
		int b = k;
		if(arr[y-1][x] != 0) {
//			System.out.println("count = " + count);
//			for(int[] i: arr) {
//				for(int j : i) {
//					System.out.print(j+" ");
//				}
//				System.out.println();
//			}
//			System.out.println(arr[y-1][x]);
			return arr[y-1][x];
		}
		if(a==0) {
			arr[a][b] = 1;
//			count++;
		}else if(b==0) {
			arr[a][b] = n+1;
//			count++;
		}else if(arr[a-1][b]!=0 && arr[a][b-1]!=0){
			arr[a][b] = arr[a-1][b] + arr[a][b-1];
//			count++;
		}				
		return 0;
	}
}

