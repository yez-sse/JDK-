package problem.代码随想录.递归;

public class 递归分析2 {

    // 用斐波拉契数列来说明

    // 一个最基础的，大家都最开始就接触到的写法
    int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    // the time complexity of this method is tremendous
    // it's 2^n, unbelievable!


    // time complexity is just O(n), much better
    int fibonacci2(int n) {
        int[] fib = new int[n];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n - 1];
    }
}
