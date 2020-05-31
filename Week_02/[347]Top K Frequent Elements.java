import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class TopK{
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null){
            return null;
        }

        int[] ret = new int[k];

        //fill map by <key, frequent>
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //put entries in map to priorityQueue
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b)-> b.getValue() - a.getValue());
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            queue.offer(entry);
        }
        //poll k times priorityQueue
        for(int i = 0; i<k; i++){
            Map.Entry<Integer, Integer> entry = queue.poll();
            ret[i] = entry.getKey();
        }

        return ret;
    }
}