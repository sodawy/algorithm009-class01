package Week_01;

import Utils.ListNode;

import java.util.Stack;

public class LinkedListCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode walker = head;
        ListNode runner = head;

        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) {
                return true;
            }

            Stack<Integer> stack = new Stack<>();
            stack.peek();
            stack.push(1);
            stack.pop();
            Integer.MIN

        }

        return false;
    }
}
