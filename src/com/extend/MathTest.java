package com.extend;

/**
 * Created by kingsir on 16-4-25.
 */
public class MathTest {
    public static void main(String[] args) {
        //绝对值
        System.out.println(Math.abs(-12));
        //arccos()
        System.out.println(Math.acos(1));
        //sum:a+b
        System.out.println(Math.addExact(Integer.MAX_VALUE-1,1));
        //subtract:a-b
        System.out.println(Math.subtractExact(2,1));
        //multiply:a*b
        System.out.println(Math.multiplyExact(2,3));
        //increce:a++;
        System.out.println(Math.incrementExact(23));
        //decrement:a--;
        System.out.println(Math.decrementExact(23));
        //相反数
        System.out.println(Math.negateExact(23));
        //long --> int
        System.out.println("long --> int : "+Math.toIntExact(22125387l));
        //[x/y]
        System.out.println(Math.floorDiv(25,3));
        //x-[x/y]*y:除法的舍去值
        System.out.println(Math.floorMod(25,3));
        //最大值
        System.out.println(Math.max(1,2));
        //最小值
        System.out.println(Math.min(2,24));

        System.out.println(Math.sinh(1.2));
        System.out.println(Math.cosh(1.2));
        System.out.println(Math.tanh(1.2));

    }
}
