package test.collection;

import java.util.LinkedList;

public class testLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.addFirst(2);
        linkedList.addLast(3);
        linkedList.offer(4);
        linkedList.offerFirst(5);
        linkedList.offerLast(6);

        linkedList.poll();
        linkedList.peek();
        linkedList.pollLast();
        linkedList.peekLast();
        linkedList.pollFirst();
        linkedList.peekFirst();

        linkedList.push(8);
        linkedList.pop();
    }
}
