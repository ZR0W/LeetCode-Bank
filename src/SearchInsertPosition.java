import java.util.Arrays;

public class SearchInsertPosition {

	public static void main(String[] args) {
		System.out.println("LeetCode Problem 35: Search Insert Position-->");
		
		SearchInsertPosition s = new SearchInsertPosition();
		int[] nums = new int[]{1,2,3,4,5,6,7,9,10};
		int target = 8;
		int output = s.searchInsert(nums, target);
		System.out.println("Position: " + output);
	}
	
	public int searchInsert(int[] nums, int target) {
		System.out.println("Looking for " + target + " in Array: " + Arrays.toString(nums));
        return help(0, nums.length-1, target, nums);
    }
    
    public int help(int start, int end, int target, int[] nums){
    	System.out.println("\tstart " + start + ", end " + end);
    	//edge cases?
    	if(nums[start] >= target) {
    		return 0;
    	}
    	if(nums[end] < target) {
    		return nums.length;
    	}
    	if(nums[end] == target) {
    		return nums.length-1;
    	}
    	//general case where target is in the middle somewhere
        if(start > end){
            System.out.println("error?");
            return start;
        }
        if(start == end){
            return start;
        }
        if((end - start) == 1) {
        	return end;
        }
        int middle = (end+start)/2; //plus one to make sure the index rounds up
        int foo = nums[middle];
        if(foo == target){
            return middle;
        }
        if(foo < target){
            return help(middle, end, target, nums);
        }else{//has to be foo > target since equal case is tested already
            return help(start, middle, target, nums);
        }
    }

}
