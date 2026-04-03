class Solution {
    public int findKthLargest(int[] nums, int k) {
        Integer[] rowSum = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(rowSum, Collections.reverseOrder());
        return rowSum[k-1];
    }
}