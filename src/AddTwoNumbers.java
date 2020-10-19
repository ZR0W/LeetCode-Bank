import java.util.function.IntToLongFunction;

public class AddTwoNumbers {

	public static void main(String[] args) {
		Solution s = new Solution();
		AddTwoNumbers a = new AddTwoNumbers();
		int num1 = 342;
		int num2 = 65;
		ListNode l1 = a.intToList(num1);
		ListNode l2 = a.intToList(num2);
		ListNode result = s.addTwoNumbers(l1, l2);
		
		System.out.println(a.ListNodeToArray(result));
	}
	
	public ListNode intToList(int num) {
		ListNode l = new ListNode();
		intToListHelp(num, l);
		return l;
	}
	
	public void intToListHelp(int num, ListNode node) {
		if(num > 0) {
			node.val = num % 10;
			num = num/10;
			if(!(num>0)) {
				return;
			}
			node.next = new ListNode();
			intToListHelp(num, node.next);			
		}
		return;
	}

	public String ListNodeToArray(ListNode head) {
		String output = "";
		output = ListNodeToArrayHelp(output, head);
		return output;
	}
	
	public String ListNodeToArrayHelp(String out, ListNode node) {
		if(node != null) {
			out = out + node.val;
			return ListNodeToArrayHelp(out, node.next);
		}else {
			return out;
		}
	}
	 

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       boolean carry = false;
       addDigit(l1, l2, carry);
       return l2;
   }
   
   public void addDigit(ListNode l1, ListNode l2, boolean carry){
       if(l1 != null){
           if(l2 != null){
               if(carry){
                   l2.val = l2.val + l1.val + 1;
               }else{
                   l2.val = l2.val + l1.val;
               }
               if(l2.val > 9){
                   carry = true;
                   l2.val = 0;
               }else{
                   carry  = false;
               }
               addDigit(l1.next, l2.next, carry);
           }else{
               l2 = new ListNode(0);
               if(carry){
                   l2.val++;
               }
               addDigit(l1, l2, false);
           }
       }else{
           if(l2 != null){
               if(carry){
                   addDigit(new ListNode(1), l2, false);
               }else{
                   return;
               }
           }else{
               if(carry){
                   l2 = new ListNode(1);
                   //TODO: this is where the problem is. need to assig new next node to l2
               }else{
                   return;
               }
           }
       }
   }
}