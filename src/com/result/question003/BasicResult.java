package com.result.question003;

import java.util.*;

/**
 * Created by kingsir on 16-4-25.
 */
public class BasicResult {
    public static void main(String[] args) {
        String s = "aab";

        BasicResult basicResult = new BasicResult();
        basicResult.lengthOfLongestSubstring(s);
    }
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if(chars.length<=1) {
            return chars.length == 1 ? 1 : 0;
        }
        Set set = new HashSet();
        Map<Integer,String> map = new HashMap<Integer, String>();
        int front = 0;
        for(int i=0;i<chars.length;i++){
            if(!set.add(chars[i])){
                map.put(set.size(),s.substring(front,i));
                do{
                    set.remove(chars[front]);
                    front++;
                }while (!set.add(chars[i]));
            }
        }
        Set<Integer> values = map.keySet();
        int max = Integer.MIN_VALUE;
        for(Integer value :values){
            if(max<value){
                max = value;
            }
        }
        return max>set.size()?max:set.size();
    }
}
