public class Main {
    public static void main(String[] args) {

        BST_V2<Integer> bst = new BST_V2<>();
        int[] nums = {5,3,6,8,4,2};
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }

        /////////////////////
        //       5         //
        //     /   \       //
        //    3    6       //
        //   / \    \      //
        //  2   4    8     //
        /////////////////////

        bst.preOrder();
        System.out.println();
        System.out.println(bst);

        bst.inOrder();
        System.out.println();

        bst.postOrder();
        System.out.println();

        bst.preOrderNR();
    }
}
