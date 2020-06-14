class IsSubsequence {
    public boolean _isSubsequence(String s, String t) {
        if (s == null) return true;

        int sLen = s.length();
        int tLen = t.length();

        int tIndex = 0;
        int sIndex = 0;

        while(tIndex < tLen){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
                if(sIndex == sLen){
                    return true;
                }
            }
            tIndex++;
        }

        return false;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence._isSubsequence("axc", "scasbssc"));

    }
}