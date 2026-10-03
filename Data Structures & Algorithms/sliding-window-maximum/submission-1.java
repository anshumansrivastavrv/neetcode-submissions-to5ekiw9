class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();

        int l = 0;

        for (int r = 0; r < n; r++) {

            // Remove smaller elements from back
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }

            q.addLast(r);

            // Remove out-of-window elements
            if (q.getFirst() < l) {
                q.removeFirst();
            }

            // Window reached size k
            if (r + 1 >= k) {
                output[l] = nums[q.getFirst()];
                l++;
            }
        }

        return output;
    }
}