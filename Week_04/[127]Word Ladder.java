import java.util.*;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) return 0;
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>();

        for (String word : wordList) {
            wordSet.add(word);
        }

        Queue<String> queue = new LinkedList<>();
        int level = 1;
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int q = 0; q < len; q++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char originChar = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String newWord = new String(chars);
                        if (!wordSet.contains(newWord)) {
                            continue;
                        }
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }
                        if (!visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    chars[i] = originChar;
                }
            }
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {

        WordLadder wordLadder = new WordLadder();
        String[] input = new String[]{"ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain"};
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(input));
        System.out.println(wordLadder.ladderLength("ymain", "oecij", arrayList));

    }
}