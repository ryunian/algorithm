package programmers.Lv1;

public class 체육복 {
    public static void main(String[] args) {
        체육복 test = new 체육복();
        test.solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
        test.solution(5, new int[]{2,4},new int[]{3});
        test.solution(3, new int[]{3},new int[]{1});
        test.solution(10, new int[]{1,3,5,7},new int[]{2,4,6});
        test.solution(10, new int[]{5,7,9},new int[]{1,2,3,4,6,8});
        test.solution(5,new int[]{1,2,3}, new int[]{1,2,3});
        test.solution(8,new int[]{4,2,3}, new int[]{1});
        test.solution(10,new int[]{3,9,10}, new int[]{3,8,9});
        test.solution(5, new int[]{1, 2}, new int[]{2, 3});
        test.solution(3, new int[]{1, 2}, new int[]{2, 3});
        test.solution(3, new int[]{1, 2, 3}, new int[]{1, 2, 3});
        test.solution(3, new int[]{3}, new int[]{1});
        test.solution(7, new int[]{2, 3, 4}, new int[]{1, 2, 3, 6});
        test.solution(5, new int[]{2, 3, 4}, new int[]{3, 4, 5});
        test.solution(8, new int[]{2, 3, 4}, new int[]{1});
        test.solution(8, new int[]{3,7}, new int[]{2,4});
        test.solution(5, new int[]{2,3,5}, new int[]{2,4});
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n + 2];
        for (int x : lost) {
            arr[x]--;
        }
        for (int x : reserve) {
            arr[x]++;
        }
        // 도난당한학생 : -1 , 여벌이 있는 학생 : 1

        int answer = 0;
//        int leftCnt = 0;
//        int rightCnt = 0;
        for (int i = 1; i <= n; i++) {
            if(arr[i] == 0 || arr[i] == 1){
                answer++;
            }else if(arr[i] == -1){
                if(arr[i-1] == 1){
                    arr[i-1] = arr[i]= 0;
                    answer++;
                }else if(arr[i+1] == 1){
                    arr[i+1] = arr[i]= 0;
                    answer++;
                }
            }
            /*if (arr[i] == 0 || i == n || (arr[i-1] == arr[i] && arr[i+1] != arr[i])) {
                answer += Math.max(leftCnt, rightCnt);
                leftCnt = 0;
                rightCnt = 0;
            }
            if (arr[i - 1] == 1 && arr[i] == -1) {
                leftCnt++;
            }
            if (arr[i + 1] == 1 && arr[i] == -1) {
                rightCnt++;
            }*/
        }
//        for (int i = 1; i <= n ; i++) {
//            if (arr[i] != -1) answer++;
//        }

        System.out.println(answer);
        return answer;
    }

}
