public class FibonacciSeries {
    public static int fib(int n) {
        if(n<=1) {
            //System.out.println(n);
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public static void main(String args[]) {

        int output = fib(6);
        //System.out.println(output);
    }
}
// 0,1,1,2,3,5,8
