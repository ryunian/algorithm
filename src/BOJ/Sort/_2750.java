package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class _2750 {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<x;i++){
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}

}
