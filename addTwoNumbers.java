/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {    
         if (l1 == null) {
             return l2;
         }else if (l2 == null) {
             return l1;
         }
         ListNode dummyHead = new ListNode(-1);
         int longer = 0;
         ListNode t1 = l1;
         ListNode t2 = l2;
         while (true) {
             if ((t1 == null && t2 == null) || (t1 !=null && t2 == null)) {
                 longer = 1;
                 break;
             }else if (t1 == null && t2 != null) {
                 longer = 2;
                 break;
             }
             t1= t1.next;
             t2 = t2.next;
         }
         if (longer == 1) {
             dummyHead.next = l1;
         }else {
             dummyHead.next = l2;
             l2 = l1;
         }
         ListNode temp = dummyHead.next;
         int value = 0;
         while (temp != null) {
             if (l2 != null) {
                 int sum = value + temp.val + l2.val;
                 if (sum >= 10) {
                     temp.val = sum % 10;
                     value = 1;
                 }else {
                     temp.val = sum;
                     value = 0;
                 }
                 l2 = l2.next;
             }else {
                 int sum = value + temp.val;
                 if (sum >= 10) {
                     temp.val = sum % 10;
                     value = 1;
                 }else {
                     temp.val = sum;
                     value = 0;
                 }
             }
             if (temp.next == null) {
                 break;
             }
             temp = temp.next;
         }
         if (value == 1) {
             ListNode newNode = new ListNode(value);
             temp.next = newNode;
         }
         return dummyHead.next;
    }
}
