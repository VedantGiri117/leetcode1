class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        int j = 0;
        for(int i=0; i<b.length; i++){
            if(a[j]==b[i]){
                j++;
            }
            if(j==a.length) break;
        }
        return j==a.length;


    }
}