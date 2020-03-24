package programmers;

import java.util.*;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i <participant.length-1; i++){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
        }
        if(answer.equals("")) answer = participant[participant.length-1];
        return answer;
    }

    public static void main(String[] args) {
        완주하지못한선수 test = new 완주하지못한선수();
//        String[] x = {"leo","kiki", "eden"};
        String[] x = {"mislav", "stanko", "mislav", "ana"};
//        String[] y = {"eden", "kiki"};
        String[] y = {"stanko", "ana", "mislav"};
        String a = test.solution(x,y);
        System.out.println(a);
    }
}
