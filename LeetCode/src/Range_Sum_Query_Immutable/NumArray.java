package Range_Sum_Query_Immutable;

public class NumArray {

    private SegmentTree<Integer> segTree;

    public NumArray(int[] nums) {

        if (nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segTree = new SegmentTree<>(data, (a , b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {
        if (segTree == null)
            throw new IllegalArgumentException("Segment Tree is null.");
        return segTree.query(i,j);
    }
}
