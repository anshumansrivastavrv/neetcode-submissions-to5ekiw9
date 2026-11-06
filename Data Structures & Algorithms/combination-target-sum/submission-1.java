class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int[] nums, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) continue;

            curr.add(nums[i]);
            backtrack(i, nums, target - nums[i], curr, res); // reuse allowed
            curr.remove(curr.size() - 1);
        }
    }
}