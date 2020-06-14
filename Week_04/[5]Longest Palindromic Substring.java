class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null) return null;

        int len = s.length();
        if (len <= 1) return s;

        int maxCenter = 0;
        int maxLen = 1;

        for (int i = 1; i < s.length(); i++) {
            int odd = extend(s, i, i);
            int even = extend(s, i - 1, i);
            System.out.println("i:" + i + " odd: " + odd + " even: " + even);
            int bigger = odd > even ? odd : even;
            if (bigger > maxLen) {
                System.out.println("maxLen:" + maxLen + " maxCenter: " + maxCenter);
                maxCenter = i;
                maxLen = bigger;
            }
        }

        int start = maxCenter - maxLen / 2;

        return s.substring(start, start + maxLen);
    }

    private int extend(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return end - begin - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("bvvcvv"));


    }
}