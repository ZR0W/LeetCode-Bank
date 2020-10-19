
public class ContainsDuplicateThree {

	/**
	 * Given an array of integers
	 * find out whether there are two distinct indices i and j in the array
	 *  such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
	 *  
	 *  Example:
	 *  input: nums = [1, 2, 3, 1], k = 3, t = 0
	 *  output: true
	 */
	
	
	public static void main(String[] args) {
//		int[] nums = new int[] {1,2,3,1};
//		int k = 3;
//		int t = 0;
		
		int[] nums = new int[] {1,5,9,1,5,9};
		int k = 2;
		int t = 3;
		ContainsDuplicateThree c = new ContainsDuplicateThree();
		c.containsNearbyAlmostDuplicate(nums, k, t);

	}
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i =0; i < nums.length-k; i ++){
            int first = nums[i];
            for(int j = 1; j <= k; j++){
                int second = nums[i+j];  
                
                System.out.println("comparing " + first + " and " + second);
                
                if(Math.abs(second-first) <= t){
                	System.out.println("true");
                    return true;
                }
            }
        }
        //check last few
        int last = nums[nums.length-k];
        for(int m = 1; m < k; m++){
            int comp = nums[nums.length-k+m];
            
            System.out.println("comparing " + last + " and " + comp);
            
            if(Math.abs(comp-last) <= t){
            	System.out.println("true");
                return true;
            }
        }
        System.out.println("false");
        return false;
    }
	//TODO: not correct! test for null cases and when k is larger than nums.length
} 