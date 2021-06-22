package problem.struct;

import java.util.*;

public class MaxQueue {
    LinkedList<Integer> queue;
    LinkedList<Integer> queue2;

    public MaxQueue() {
        queue = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public int max_value() {
        return queue2.isEmpty() ? -1 : queue2.peek();
    }

    public void push_back(int value) {
        queue.add(value);  // 加到了尾部啊，队列最基本的是先进先出啊
        while (!queue2.isEmpty() && queue2.peekLast() < value) {
            queue2.pollLast();  // 在value之前进队还比他小的，没有机会被max_value()函数获取到
        }
        queue2.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        if (queue.peek().equals(queue2.peek())) {  // 注意这里不能用queue.peek() == queue2.peek()
            queue2.poll();
        }
        return queue.poll();
    }
}
