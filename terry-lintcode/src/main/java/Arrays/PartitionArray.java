package Arrays;

/**
 * Created by xingtianyi on 11/28/17.
 */
public class PartitionArray {

    public int partitionArray(int[] nums, int k) {

        int len = nums.length;

        if(nums==null || len==0){
            return 0;
        }

        int left = 0;
        int right = len-1;

        while(left < right){

            while(nums[left]<k && left < right){
                left++;
            }

            while(nums[right]>=k && left < right){
                right--;
            }

            if(left==right){
                break;
            }

            int temp = nums[left];
            nums[left]=nums[right];
            nums[right] = temp;
        }
        if(left==len-1){
            return len;
        }

        return left;




    }


    public static void main(String[] args) {

        PartitionArray x = new PartitionArray();

        int[] nums = {9,9,9,8,9,8,7,9,8,8,8,9,8,9,8,8,6,9};

        int result = x.partitionArray(nums, 9);
    }

    }
