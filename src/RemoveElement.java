
public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World! Testing Leet code Problem 27");
		int[] nums = new int[] {
				3,2,2,3
		};
		int val = 3;
		RemoveElement r = new RemoveElement();
		System.out.println("old Array: ");
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
		System.out.print("\n");
		int newL = r.removeElement(nums, val);
		System.out.println("new Array: ");
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
		System.out.print("\n");
		System.out.println("new return length: " + newL);
	}
	
	public int removeElement(int[] nums, int val) {
        int numRemoved = 0;
        int numLength = nums.length;
        int lastSwitch = numLength-1;
        for(int i = 0; i < numLength; i++){
            if(nums[i] == val){
                for(int j = lastSwitch; j > i; j--){
                    if(nums[j] != val){
                        int foo = nums[j];
                        nums[j] = val;
                        nums[i] = foo;
                        lastSwitch = j;
                        numRemoved++;
                        break;
                    }else{
                        //look for next one
                    }
                }
            }
        }
        for(int i = 0; i < numLength; i++) {
        	if(nums[i] == val) {
        		return i;
        	}
        }
        return numLength;
//        return numLength - numRemoved;
    }

}
