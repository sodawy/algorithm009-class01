import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombinations {
    final static Map<Character, String> map = new HashMap<>() {{
        put('0', " ");
        put('1', "");
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ret;
        _findCombinations(digits.toCharArray(), 0, "", ret);
        return ret;
    }

    // letterCombinations(n) = letterCombinations(0) + letterCombinations(n - 1)
    private void _findCombinations(char[] digits, int begin, String acc, List<String> ret) {
        if (acc.length() >= digits.length) {
            ret.add(acc);
            return;
        }
        char[] ch2str = map.get(digits[begin]).toCharArray();
        for (int i = 0; i < ch2str.length; i++) {
            _findCombinations(digits, begin + 1, acc + ch2str[i], ret);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations("23");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}