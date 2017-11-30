package BinarySearch;

/**
 * Created by xingtianyi on 11/29/17.
 */
public class Sqrt {

    public int sqrt(int x) {

        if(x<=0){
            return 0;
        }

        if(x==1){
            return 1;
        }

        long left = 0;
        long right = x;

        while(left < right){
            long mid = (left+right)/2;

            long temp = mid*mid;

            long square1 = (long)(mid + 1) * (long)(mid + 1);
            long square2 = (long)(mid - 1) * (long)(mid - 1);

            if(temp<x && square1>x){
                return (int)mid;
            }

            if(temp>x && square2 < x){
                return (int)mid-1;
            }


            if(temp<x){
                left=mid+1;
            }else{
                right=mid+1;
            }

            if(temp==x){
                return (int)mid;
            }
        }

        return -1;


    }


    public static void main(String[] args) {

    }

    }
