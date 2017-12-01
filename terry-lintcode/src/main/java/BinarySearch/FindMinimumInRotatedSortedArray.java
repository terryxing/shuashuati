package BinarySearch;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  11/30/17
 * Time  :  2:03 PM
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] num) {

        int len=num.length;

        if(num==null){
            return -1;
        }

        if(len == 0){
            return -1;
        }

        int left = 0;
        int right = len-1;

        while(left<=right){

            int mid =(left+right)/2;
            int midVal = num[mid];

            if(mid+1<len && num[mid+1]<num[mid]){
                return num[mid+1];
            }

            if(mid-1>=0 && num[mid-1]>num[mid]){
                return num[mid];
            }

            if(num[mid]>num[right]){
                left=mid+1;
            }else if(num[mid]<num[left]){
                right=mid-1;
            }else{
                return num[0];
            }

        }
        return num[0];
    }


    public static void main(String[] args) {

        int[] num = {0,1,2,3,4,5};
        FindMinimumInRotatedSortedArray x = new FindMinimumInRotatedSortedArray();

        int result = x.findMin(num);

    }

    }
