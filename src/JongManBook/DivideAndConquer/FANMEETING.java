package JongManBook.DivideAndConquer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

// 7.6 팬미팅
// 카라츠바알고리즘
public class FANMEETING {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            char[] member = sc.next().toCharArray();
            char[] fan = sc.next().toCharArray();
            System.out.println(solve(member, fan));
        }
    }

    private static int solve(char[] member, char[] fan) {
        int n = member.length;
        int m = fan.length;
        // array 를 arraylist 에 담는다
        // karatsuba 를 이용하기 위해 M(남자)를 1로 담고 아닐경우 0으로 담는다
        ArrayList<Integer> a = new ArrayList<>(member.length);
        ArrayList<Integer> b = new ArrayList<>(fan.length);
        for (int i = 0; i < n; i++) {
            a.add(i, member[i] == 'M' ? 1 : 0);
        }
        for (int i = 0; i < m; i++) {
            b.add(i, fan[m - i - 1] == 'M' ? 1 : 0);
        }
        // karatsuba
        ArrayList<Integer> c = karatsuba(a, b);
        int allHug = 0;
        for (int i = n - 1; i < m; i++) {
            if (c.get(i) == 0) allHug++;

        }
        return allHug;
    }

    /*
     * 카라츠바 알고리즘 O(n^lg3)
     */
    private static ArrayList<Integer> karatsuba(ArrayList<Integer> a, ArrayList<Integer> b) {
        int sizeA = a.size();
        int sizeB = b.size();

        // a가 b보다 짧을 경우 순서를 바꾼다.
        if (sizeA < sizeB) return karatsuba(b, a);

        // a나 b가 비어있을 경우
        if (sizeA == 0 || sizeB == 0) return new ArrayList<>();

        // 비교적 짧을 경우 O(n^2) 곱셈 으로 변경
        if (sizeA <= 50) return multiply(a, b);

        // a와 b를 밑에서 half 자리와 나머지로 분리한다.
        int half = sizeA / 2;
        ArrayList<Integer> a0 = a.stream().limit(half).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> a1 = a.stream().skip(half).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> b0 = a.stream().limit(Math.min(sizeB, half)).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> b1 = a.stream().skip(Math.min(sizeB, half)).collect(Collectors.toCollection(ArrayList::new));


        // 표현 방식
        // 1. 스트림
        // ArrayList<Integer> a0 = a.stream().limit(half).collect(Collectors.toCollection(ArrayList::new));
        // 2. 스트림 + 형변환
        // ArrayList<Integer> a0 = (ArrayList<Integer>) a.stream().limit(half).collect(Collectors.toList());
        // 3. 서브리스트
        // ArrayList<Integer> a0 = new ArrayList<Integer>(b.subList(0, half);

        // z2 = a1 * b1
        ArrayList<Integer> z2 = karatsuba(a1, b1);

        // z0 = a0 * b0
        ArrayList<Integer> z0 = karatsuba(a0, b0);

        // a0 = a0 + a1; b0 = bo + b1;
        addTo(a0, a1, 0);
        addTo(b0, b1, 0);

        // z1 = (a0 * b0) - z0 - z2;
        ArrayList<Integer> z1 = karatsuba(a0, b0);
        subFrom(z1, z0);
        subFrom(z1, z2);

        // ret = z0 + z1 * 10^half + z2 * 10^(half*2)
        ArrayList<Integer> ret = new ArrayList<>();
        addTo(ret, z0, 0);
        addTo(ret, z1, half);
        addTo(ret, z2, half + half);

        return ret;
    }

    // a -= b;
    private static void subFrom(ArrayList<Integer> a, ArrayList<Integer> b) {
        // resize
        for (int i = a.size(); i < b.size(); i++) {
            a.add(0);
        }
        for (int i = 0; i < b.size(); i++) {
            a.set(i, a.get(i) - b.get(i));
        }
        // normalize(a);
    }

    // a += b * (10 ^ k)
    private static void addTo(ArrayList<Integer> a, ArrayList<Integer> b, int k) {
        // resize
        for (int i = a.size(); i < b.size() + k; i++) {
            a.add(0);
        }
        for (int i = 0; i < b.size(); i++) {
            a.set(i + k, a.get(i + k) + b.get(i));
        }
        // normalize(a);
    }

    // 두 수의 정수의 곲을 반환
    private static ArrayList<Integer> multiply(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (list.size() < a.size() + b.size() + 1) {
            list.add(0);
        }
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                list.set(i + j, list.get(i + j) + a.get(i) * b.get(j));
            }
        }

        // normalize(list);
        return list;
    }

    // list num의 자릿수 올림을 처리한다.
    // 현재 알고리즘에선 사용하지 않는다.
    public static ArrayList<Integer> normalize(ArrayList<Integer> num) {
        num.add(0);
        for (int i = 0; i < num.size() - 1; i++) {
            if (num.get(i) < 0) {
                int borrow = (Math.abs(num.get(i)) + 9) / 10;
                num.set(i + 1, num.get(i + 1) - borrow);
                num.set(i, num.get(i) + borrow * 10);
            } else {
                num.set(i + 1, num.get(i + 1) + num.get(i) / 10);
                num.set(i, num.get(i) % 10);
            }
        }

        if (num.get(num.size() - 1) == 0)
            num.remove(num.size() - 1);
        return num;
    }
}

/*
4
FFFMMM
MMMFFF
FFFFF
FFFFFFFFFF
FFFFM
FFFFFMMMMF
MFMFMFFFMMMFMF
MMFFFFFMFFFMFFFFFFMFFFMFFFFMFMMFFFFFFF
 */