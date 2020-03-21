public class Solution {

    public ListNode removeElements(ListNode head, int val, int depth){
        String depthString = generateDepthString(depth);
        System.out.println(depthString);
        System.out.println("Call:remove " + val + " in" + head);

        if (head == null){
            System.out.println(depthString);
            System.out.println("Return: " + head);
            return null;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.println(depthString);
        System.out.println("After remove " + val + ": " + res);
        if (head.val == val)
            return res;
        else {
            head.next = res;
            return head;
        }
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 6, 6);
        System.out.println(res);
    }
}