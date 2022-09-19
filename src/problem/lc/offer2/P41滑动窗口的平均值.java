package problem.lc.offer2;

import java.util.LinkedList;

public class P41滑动窗口的平均值 {

}

class MovingAverage {

    private int sum;
    private int size;
    private LinkedList<Integer> queue;

    public MovingAverage(int size) {
        this.sum = 0;
        this.size = size;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        sum += val;
        queue.addLast(val);
        if (queue.size() > size) {
            sum -= queue.pollFirst();
        }
        return sum / (queue.size() * 1.0);
    }
}
