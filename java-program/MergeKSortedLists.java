//  QUESTION
// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
 
//FUNCTION IMPLEMENTATION

private static ListNode mergeKLists(ListNode[] lists) {
	return partition(0, lists.length - 1, lists);
}

private static ListNode partition(int l, int r, ListNode[] lists) {
	if (r < l) return null;
	if (r == l) return lists[r];
	if (r - l == 1) return merge(lists[l], lists[r]);

	var m = (l + r) / 2;
	var left = partition(l, m, lists);
	var right = partition(m + 1, r, lists);

	if (right == null) return left;
	if (left == null) return right;

	return  merge(left, right);
}

private static ListNode merge(ListNode l1, ListNode l2) {
	var dummy = new ListNode();
	var curr = dummy;

	while (l1 != null && l2 != null)
	{
		if (l1.val < l2.val)
		{  curr.next = l1; l1 = l1.next; }
		else
		{ curr.next = l2; l2 = l2.next; }
		curr = curr.next;
	}

	curr.next = l1 != null ? l1 : l2;

	return dummy.next;
}