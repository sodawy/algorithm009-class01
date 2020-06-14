import java.util.LinkedList;
import java.util.PriorityQueue;

class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null) return null;
        int len = people.length;

        int[][] ret = new int[len][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        for (int i = 0; i < len; i++) {
            pq.add(people[i]);
        }
        LinkedList<int[]> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            int[] aPeople = pq.poll();
            list.add(aPeople[1], aPeople);
        }

        int i = 0;
        for (int[] aPeople : list) {
            ret[i++] = aPeople;
        }

        return ret;
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();
        int[][] input = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        queueReconstructionByHeight.reconstructQueue(input);
    }
}