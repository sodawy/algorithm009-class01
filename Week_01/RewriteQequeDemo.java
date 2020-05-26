package Week_01;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class RewriteQequeDemo {
    public static void main(String[] args) {
        LinkedList<String> deque = new LinkedList<>();

        deque.addLast("a");
        deque.addLast("c");
        deque.addLast("d");
        System.out.println(deque);

        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);

        try {
            while (deque.size() > 0) System.err.println(deque.removeLast());
        } catch (NoSuchElementException e) {
            System.err.printf(String.valueOf(e.getStackTrace()));
        }

        System.out.println(deque);
    }
}
