import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int total = 0;
        if(costs == null){
            return total;
        }

        int cityCount = costs[0].length;
        int peopleCount = costs.length;

        PriorityQueue<PriorityQueue<Map.Entry<Integer, Integer>>> q = new PriorityQueue<>((q1, q2) -> {
            if(q1.isEmpty()){
                return 1;
            }else if(q2.isEmpty()){
                return -1;
            }else{
                return q1.peek().getValue() - q2.peek().getValue();
            }
        });

        for(int cityIndex = 0; cityIndex < cityCount; cityIndex++){
            PriorityQueue<Map.Entry<Integer, Integer>> nodes = new PriorityQueue<>();
            for(int peopleIndex = 0; peopleIndex < peopleCount; peopleIndex++){
                int finalPeopleIndex = peopleIndex;
                int finalCityIndex = cityIndex;
                nodes.add(new Map.Entry<Integer, Integer>() {
                    @Override
                    public Integer getKey() {
                        return finalPeopleIndex;
                    }

                    @Override
                    public Integer getValue() {
                        return costs[finalPeopleIndex][finalCityIndex];
                    }

                    @Override
                    public Integer setValue(Integer value) {
                        return null;
                    }
                });
            }
            q.add(nodes);
        }

        while(cityCount > 0){
            PriorityQueue<Map.Entry<Integer, Integer>> minCostQ = q.peek();
            Map.Entry<Integer, Integer> minNode = minCostQ.poll();
            while(costs[minNode.getKey()] == null){
                PriorityQueue<Map.Entry<Integer, Integer>> peek = q.peek();
                minNode = peek.poll();
            }

            total += minNode.getValue();

            costs[minNode.getKey()] = null;

            cityCount--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(1);

        return total;
    }
}