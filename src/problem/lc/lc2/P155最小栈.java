package problem.lc.lc2;

import java.util.ArrayDeque;
import java.util.Deque;

public class P155最小栈 {

    Deque<Integer> nums;
    Deque<Integer> mins;

    public P155最小栈() {
        nums = new ArrayDeque<>();
        mins = new ArrayDeque<>();
    }

    public void push(int val) {
        if (nums.isEmpty()) {
            nums.push(val);
            mins.push(val);
        } else {
            nums.push(val);
            mins.push(Math.min(val, mins.peek()));
        }
    }

    public void pop() {
        nums.pop();
        mins.pop();
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
