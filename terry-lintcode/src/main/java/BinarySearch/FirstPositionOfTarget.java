package BinarySearch;

/**
 * Created by xingtianyi on 11/30/17.
 */
public class FirstPositionOfTarget {

    public int binarySearch(int[] nums, int target) {

        if(nums == null){
            return -1;
        }

        int len = nums.length;

        if(len<1){
            return -1;
        }

        int left = 0;
        int right = len-1;

        if(nums[0]==target){
            return 0;
        }

        while(left <= right){

            int mid = (left+right)/2;

            int midVal = nums[mid];

            if(midVal == target){
                while(mid>0 && nums[mid-1] == target){
                        mid--;
                }
                return mid;
            }

            if(midVal < target){
                left = mid+1;
            }

            if(midVal > target){
                right = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {


    }
    }
