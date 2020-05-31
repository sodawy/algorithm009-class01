import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams{
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        if(strs == null){
            return ret;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            String key = normalize(s);
            if(map.containsKey(key)){
                List<String> list = map.get(key);
                list.add(s);
            }else{
                List<String> list = new ArrayList<>();
                map.put(key, list);
                list.add(s);
            }
        }
        for(String key: map.keySet()){
            ret.add(map.get(key));
        }
        return ret;
    }

    private String normalize(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}