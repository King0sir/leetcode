package com.result.question002;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingsir on 16-4-25.
 */
public class ListGenerator {
    static ListNode generator(int[] array){
        ListNode listNode = new ListNode(array[0]);
        ListNode node = listNode;
        for(int i =1 ;i<array.length;i++){
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        return listNode;
    }

    static int[] deGenerator(ListNode listNode){
        List<Integer> list = new ArrayList<Integer>();
        while(listNode!=null){
            list.add(listNode.val);
            listNode = listNode.next;
        }

        Integer[] arrayInteger = new Integer[list.size()];
        list.toArray(arrayInteger);
        int[] array = new int[arrayInteger.length];
        for(int i = 0 ;i<arrayInteger.length;i++){
            array[i] = arrayInteger[i];
        }
        return array;
    }
}
