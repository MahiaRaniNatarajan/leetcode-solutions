class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n=s.length();
        int max=0;
        int left=0;
        HashSet<Character> arr=new HashSet<>();
        for(int right =0;right<n;right++){
            if(!arr.contains(s.charAt(right))){
                arr.add(s.charAt(right));
                max=Math.max(max,right-left+1);
            }
            else
            {
                while(arr.contains(s.charAt(right))){
                    arr.remove(s.charAt(left));
                    left++;
                }
                arr.add(s.charAt(right));
            }
        }
        return max;
    }
}