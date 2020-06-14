import java.util.*;

class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random random;
    int size;


    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
        size = 0;

        Map.Entry<String, Integer> stringIntegerEntry = new AbstractMap.SimpleEntry<>("a",1);
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, size);
        list.add(val);
        size++;
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int pos = map.get(val);
        int last = list.get(size - 1);
        Collections.swap(list, pos, size - 1);
        map.put(last, pos);
        map.remove(val);
        list.remove(size - 1);
        size--;
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */