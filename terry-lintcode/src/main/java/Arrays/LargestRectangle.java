package Arrays;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  1/3/18
 * Time  :  2:58 PM
 */
public class LargestRectangle {

    public int largestRectangleArea(int[] height) {
        // write your code here
        if(height == null){
            return 0;
        }

        int len = height.length;
        if(len ==0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for(int i=0 ; i<len; i++){
            int curr = height[i];
            int left=i-1;
            int width = 1;
            int area = 0;

            while(left>=0){
                if(height[left]>=curr){
                    width++;
                }else{
                    break;
                }
                left=left-1;
            }
            int right = i+1;
            while(right<=len-1){
                if(height[right]>=curr){
                    width++;
                }else{
                    break;
                }
                right=right+1;
            }

            area= curr*width;
            if(area>max){
                max = area;
            }
        }

        return max;

    }
}
