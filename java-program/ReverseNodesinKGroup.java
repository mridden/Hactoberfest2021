/**
 * Author:  AKSHAY WAKHARE
 * Date:    22 October 2021
 */
 
 
 
//  Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
// You may not alter the values in the list's nodes, only nodes themselves may be changed.


public /*class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }*/
 
//FUNCTION IMPLEMENTATION
    public ListNode reverseKGroup(ListNode head, int k) {
        int c=k;
        ListNode h=head;
        ListNode s=head;
        ListNode p=null;
        while(s!=null){
        ListNode next=s.next;
            s.next=p;
            p=s;
            k--;
            if(k==0){
               h.next=reverseKGroup(next,c);
                   return s;
            }
            s=next;
                    } 
                    
        if(s==null&&k!=0){
                      s=p;
            p=null;
            while(s!=null){
                ListNode next=s.next;
            s.next=p;
            p=s;
                s=next;
                
            }return p;
        }return null;
    }
}