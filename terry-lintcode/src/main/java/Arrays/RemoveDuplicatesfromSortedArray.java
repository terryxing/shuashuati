package Arrays;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  11/28/17
 * Time  :  4:23 PM
 */
public class RemoveDuplicatesfromSortedArray {
//    Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//    Do not allocate extra space for another array, you must do this in place with constant memory.
//    Given input array A = [1,1,2],
//
//    Your function should return length = 2, and A is now [1,2].


    public int removeDuplicates(int[] nums) {

        if(nums == null || nums.length==0){
            return 0;
        }

        if(nums.length==1){
            return 1;
        }

        int i=0;
        int j=0;
        int prev=nums[0];

        while(i<nums.length){
            int curr = nums[i];
            if(nums[i]!=prev){
                prev=nums[i];
                nums[j]=curr;
                i++;
                j++;
             }else{
                if(i==0){
                    j++;
                }
                i++;
            }
        }

        return j;
    }

    public static void main(String[] args) {

        RemoveDuplicatesfromSortedArray x = new RemoveDuplicatesfromSortedArray();

        int[] nums = {-10,0,1,2,3};

        int reuslt = x.removeDuplicates(nums);

    }


    }
