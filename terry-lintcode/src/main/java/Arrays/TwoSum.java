package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User  :  txing
 * Data  :  11/28/17
 * Time  :  3:57 PM
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];

        if(numbers==null || numbers.length ==0){
            return result;
        }

        HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();

        for(int i=0; i<numbers.length; i++){
            if(!hashMap.containsKey(numbers[i])){
                List<Integer> currList = new ArrayList<Integer>();
                currList.add(i);
                hashMap.put(numbers[i], currList);
            }else{
                List<Integer> currList =hashMap.get(numbers[i]);
                currList.add(i);
                hashMap.put(numbers[i], currList);
            }
        }

        for(int i=0;i<numbers.length; i++){
            int x = target-numbers[i];
            if(hashMap.containsKey(x)){

                if(hashMap.get(x).size()==1 && hashMap.get(x).get(0)!=i){
                    result[0]=(i+1);
                    result[1]=(hashMap.get(x).get(0)+1);
                    break;
                }

                if(hashMap.get(x).size()==1 && hashMap.get(x).get(0)==i ){
                    continue;
                }

                if(hashMap.get(x).size()>1){
                    List<Integer> currList = hashMap.get(x);
                    int j = i;
                    for(Integer currInt : currList){
                        if(currInt != i){
                            j=currInt;
                            break;
                        }
                    }
                    result[0]=(i+1);
                    result[1]=(j+1);
                    break;
                }


            }
        }

        return result;
    }



    }
