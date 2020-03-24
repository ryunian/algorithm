package programmers;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i=0; i<phone_book.length-1;i++){
            for(int j=i+1; j< phone_book.length;j++){
                if(i==j) continue;
                if(phone_book[j].indexOf(phone_book[i]) == 0){
                    return false;
                }
                if(phone_book[i].indexOf(phone_book[j]) == 0){
                    return false;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        전화번호목록 test = new 전화번호목록();
        String[] x = {"119", "97674223", "1195524421"};

        System.out.println(test.solution(x));
    }
}
