package Strings;

/**
 * Created by xingtianyi on 11/27/17.
 */
public class StrStr {

    public int strStr(String source, String target) {
        if(source == null && target == null){
            return -1;
        } else if (source ==null || target==null){
            return -1;
        } else if(source.length() ==0 && target.length()==0){
            return 0;
        } else if(source.length() !=0 && target.length()==0) {
            return  0;
        } else if(source.length() ==0 && target.length()!=0){
            return -1;
        }



        if(source.length() < target.length()){
            return -1;
        }



        if(source.length() == target.length()){
            if(source.equals(target)){
                return 0;
            }else{
                return -1;
            }
        }

        for(int i=0; i<source.length()-target.length()+1; i++){

            if(source.charAt(i)!=target.charAt(0)){
                continue;
            }else{
                int j;
                for(j=0; j<target.length(); j++){
                    if(source.charAt(i+j)!=target.charAt(j)){
                        break;
                    }
                }
                if(j==target.length()){
                    return i;
                }
            }
        }


        return -1;

    }

    public static void main(String[] args) {

    }

}
