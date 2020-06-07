import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class QueueRestructByHeight{
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0]!=o2[0] ? o2[0]-o1[0] :  o1[1]-o2[1]);

        List<int[]> list = new LinkedList<>();

        for(int[] cur:people){
            list.add(cur[1], cur);
        }

        return list.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        QueueRestructByHeight queueRestructByHeight = new QueueRestructByHeight();
        int[][] people = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] ints = queueRestructByHeight.reconstructQueue(people);
        for(int i = 0; i < ints.length;i++){
            System.out.println(ints[i][0] + ":"+ints[i][1]);
        }
    }
}