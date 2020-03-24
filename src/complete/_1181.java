import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class _1181 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String[] arr = new String[num];
		for(int i=0; i<num; i++) {
			arr[i] = sc.next();
		}
//		System.out.println("////////////");
		Collections.sort(Arrays.asList(arr), new Comparator<String>() {			
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() < o2.length()) {
					return -1;
				}else if(o1.length() == o2.length()) {										
					return o1.compareTo(o2);
				}else {
					return 1;
				}
			}			
		});
//		System.out.println(Arrays.toString(arr));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(arr[0]+"\n");
		for(int i=1; i<arr.length; i++) {
			if(!arr[i-1].equals(arr[i])) bw.write(arr[i]+"\n"); 
		}
		bw.flush();
	}
}
