class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int ans = 0;

        left[0] = height[0];
        for(int i=1; i<n; i++)
            left[i] = Math.max(left[i-1], height[i]);

        right[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--)
            right[i] = Math.max(right[i+1], height[i]);

        // This is the pattern that was observed in this question.
        // At a given index, amount of water depends on highest blocks on both sides of that index. It can hold up to the smallest block between these two. Remove the hieght it has on that index.
        for(int i=0; i<n-1; i++)
            ans += (Math.min(left[i], right[i]) - height[i]);

        return ans;
    }
}