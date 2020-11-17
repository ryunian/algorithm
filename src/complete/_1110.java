package complete;

import java.util.Scanner;
public class _1110 {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int x = sc.nextInt();    	    	    
    	int y = x;
    	int count = 0;
    	String y1;
    	while(true){
    		String str = Integer.toString(y);
    		if(str.length()<2) str = "0" + str;
    		int z = Integer.parseInt(str.substring(0, 1))
    				+Integer.parseInt(str.substring(1, 2));
    		if(String.valueOf(z).length() > 1) {
    			y1 = str.substring(1, 2) + String.valueOf(z).substring(1,2);
    		}else{
    			y1 = str.substring(1, 2) + String.valueOf(z).substring(0,1);    			
    		}
    		y = Integer.parseInt(y1);
    		count++;
    		if(x==y) break;    		
    	}
    	System.out.println(count);

    }
}
