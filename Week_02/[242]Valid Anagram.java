class ValidAnagram{
    public boolean isAnagram(String s, String t) {
        int[] temp = new int[26];

        if(s == null || t == null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0; i< s.length(); i++){
            temp[s.charAt(i) - 'a']++;
            temp[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i< temp.length; i++){
            if(temp[i] != 0){
                return false;
            }
        }
        return true;
    }
}