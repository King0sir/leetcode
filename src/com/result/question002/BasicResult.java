package com.result.question002;

/**
 * Created by kingsir on 16-4-25.
 */
public class BasicResult {
    public static void main(String[] args) {
        int[] a1 = {2,4,3};
        int[] a2 = {5,6,4};
        ListNode l1 = ListGenerator.generator(a1);
        ListNode l2 = ListGenerator.generator(a2);
        ListGenerator.deGenerator(l1);

        BasicResult basicResult = new BasicResult();
        ListNode listNode = basicResult.addTwoNumbers(l1,l2);
        ListGenerator.deGenerator(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = sumNode(l1,l2);

        return listNode;
    }

    private ListNode sumNode(ListNode l1,ListNode l2){
        int lenL1 = getLen(l1);
        int lenL2 = getLen(l2);

        ReBean reBean = sumValues(l1.val,l2.val,false);
        ListNode listNode = new ListNode(reBean.value);
        ListNode node = listNode;
        boolean isOut = reBean.isOutOfLimit;

        int flag=0;
        while(true){
            flag++;
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
            int v1 = l1==null?0:l1.val;
            int v2 = l2==null?0:l2.val;
            reBean = sumValues(v1,v2,isOut);
            if(reBean.value == 0&& flag>=lenL1 && flag>=lenL2){
                break;
            }
            node.next = new ListNode(reBean.value);
            isOut = reBean.isOutOfLimit;
            node = node.next;
        }


        return listNode;
    }

    private ReBean sumValues(int v1, int v2 , boolean isOut){
        int value = v1+v2+(isOut?1:0);
        if(value >=10){
            return new ReBean(value%10,true);
        }else{
            return new ReBean(value,false);
        }
    }

    private int getLen(ListNode node){
        int value = 0;
        while(node!=null){
            node = node.next;
            value++;
        }
        return value;
    }

    class ReBean{
        int value;
        boolean isOutOfLimit;
        ReBean(int value, boolean isOutOfLimit){
            this.value = value;
            this.isOutOfLimit = isOutOfLimit;
        }
    }
}
