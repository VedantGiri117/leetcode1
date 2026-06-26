class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int a = 0;
        int b = n-1;

        while(a<b){
            int temp = citations[a];
            citations[a] = citations[b];
            citations[b] = temp;
            a++;
            b--;
        }

        for(int i = 0 ;i < n ;i++){
            if(citations[i] >= i + 1) continue ;
            else return i;
        }
        return n;
        
    }
}