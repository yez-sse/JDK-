package problem.代码随想录.递归;

public class 递归分析1 {

    // 一道题，求x的n次方

    // 非递归，用遍历，这个都能想到
    int func1(int x, int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return res;
    }


    // 用一种样子上的，形式上的递归
    int func2(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return func2(x, n - 1);
    }
    // 这个虽然是递归，但是很容易看出来，计算了n次
    // 时间复杂度依然是N


    // 下面这个更是递归，而且很容易觉得是logN
    int func3(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            return x * func3(x, n / 2) * func3(x, n / 2);
        }
        return func3(x, n / 2) * func3(x, n / 2);
    }
    // 上面这个就很容易让人满足，本身树高也是logN
    // 但是节点数呢？计算次数呢？还是N啊！
    // 通过画树形图可以看出来的是，有重复计算啊！


    int func4(int x, int n) {
        if (n == 0) {
            return 1;
        }
        // 要用临时变量记录，这样避免重复计算
        // 只递归调用了一次方法，但通过临时变量完成了两次计算
        // 这里的前提就是，两次计算内容是完全一致的
        int t = func4(x, n / 2);
        if (n % 2 == 1) {
            return t * t * x;
        }
        return t * t;
    }
}
