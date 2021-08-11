public class test {
    String a;
    double b;
    int x = 0;
    public int getX(){
        return x;
    }
    private String getX(int a){
        return x+" ";
    }

    public static void main(String[] args) {
        test a = new test();
//        a.getX();
        System.out.println(a.a);
        System.out.println(a.b);
    }
}
