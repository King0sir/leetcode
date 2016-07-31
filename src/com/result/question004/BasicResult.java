package com.result.question004;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kingsir on 16-4-29.
 */
public class BasicResult {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        Map<String,Integer[]> paraMap = new HashMap<String, Integer[]>();
        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 == 0){
            return getMedianValue(nums2,new Integer[]{0,len2-1});
        }
        if(len2 == 0){
            return getMedianValue(nums1,new Integer[]{0,len1-1});
        }

        paraMap.put("array1",new Integer[]{0,len1-1});
        paraMap.put("array2",new Integer[]{0,len2-1});

        while(true){
            paraMap = throughOut(nums1,nums2,paraMap);
            if(paraMap.get("median1") != null
                    &&paraMap.get("median2") != null){
                double median1 = getValue(nums1,paraMap.get("median1"));
                double median2 = getValue(nums2,paraMap.get("median2"));
                return (median1+median2)/2.0;
            }
        }
    }

    /**
     *
     * @param a1 origin array1
     * @param a2 origin array2
     * @param solution {{array1:[front,rear]},{array2:[front,rear}}
     * @return {{array1:[front,rear]},{array2:[front,rear]},{median:{map1.get("median")}]}(value)}
     */
    private Map<String,Integer[]> throughOut(int[] a1,int[] a2,Map<String,Integer[]> solution){
        Map<String,Integer[]> map1 = getMedian(a1,solution.get("array1"));
        Map<String,Integer[]> map2 = getMedian(a2,solution.get("array2"));
        double median1 = getMedianValue(a1,map1.get("median"));
        double median2 = getMedianValue(a2,map2.get("median"));
        Map<String,Integer[]> resultMap = new HashMap<String, Integer[]>();
        if(getDistance(solution.get("array1"),solution.get("array2"))){
            resultMap.put("median1",map1.get("median"));
            resultMap.put("median2",map2.get("median"));
            return resultMap;
        }
        if(median1 == median2){
            resultMap.put("median1",map1.get("median"));
            resultMap.put("median2",map2.get("median"));
            return resultMap;
        }
        if(median1 < median2){
            resultMap.put("array1",map1.get("larger"));
            resultMap.put("array2",map2.get("smaller"));
            return resultMap;
        }else{
            resultMap.put("array1",map1.get("smaller"));
            resultMap.put("array2",map2.get("larger"));
            return resultMap;
        }

    }

    /**
     *
     * @param array
     * @param range [front,rear]
     * @return {{smaller:[front,rear]},{larger:[front,rear},median:[m1,m2](eg:[3,4][3,3])}
     */
    private Map<String,Integer[]> getMedian(int[] array,Integer[] range){
        int front = range[0];
        int rear = range[1];
        int length = rear - front + 1;
        Map<String,Integer[]> map = new HashMap<String, Integer[]>();
        if(length%2==0){
            int median = Math.addExact(front,rear)/2;//real = median + 1/2
            map.put("smaller",new Integer[]{front,median});
            map.put("larger",new Integer[]{median+1,rear});
            map.put("median",new Integer[]{median,median+1});
        }else{
            int median = Math.addExact(front,rear)/2;
            map.put("smaller",new Integer[]{front,median-1});
            map.put("larger",new Integer[]{median+1,rear});
            map.put("median",new Integer[]{median,median});
        }
        return map;
    }

    /**
     *
     * @param array
     * @param median median:[m1,m2](eg:[3,4][3,3])
     * @return
     */
    private double getValue(int[] array,Integer[] median){
        if(median[0]==median[1]){
            return array[median[1]];
        }else{
            if(array.length-1 < Math.max(median[0],median[1])){
                return array[Math.min(median[0],median[1])];
            }
            return Math.addExact(array[median[0]],array[median[1]])/2.0;
        }
    }

    private double getMedianValue(int[] array,Integer[] median){
        int medianIndex = (median[1]-median[0])/2;
        if((median[1]-median[0])%2 == 0){
            return array[medianIndex];
        }else {
            return Math.addExact(array[medianIndex],array[medianIndex+1])/2.0;
        }
    }

    private boolean getDistance(Integer[] a,Integer[] b){
        int v1 = Math.subtractExact(a[0],a[1]);
        int v2 = Math.subtractExact(b[0],b[1]);
        v1 = Math.abs(v1);
        v2 = Math.abs(v2);
        if(v1 <= 1 && v2<=1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BasicResult basicResult = new BasicResult();
        int[] num1 = new int[]{1,1};
        int[] num2 = new int[]{1,2};
        double median = basicResult.findMedianSortedArrays(num1,num2);
        System.out.println(median);
    }
}

