package com.company;

import java.util.HashSet;
import java.util.Set;

/**
 * @author meng
 * @Data 2021/8/18 7:58 下午
 * @Desc
 */
public class SomeThing {
    //[212，23，1]  [9,12,325]  3213,32
    public static void main(String[] args) {
        //
        Set set = new HashSet();


    }
    //遍历每个数，取这个数的最高位出来，然后再做比较
    public static int getM(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length; j++) {
                if (compute(array[i]) > compute(array[j])){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        String str = "";
        for (int i = array.length; i >= 0; i--) {
            str+=String.valueOf(array);
        }
        return Integer.valueOf(str);
    }

    public static int compute(int num){
        int m = 0;
        if (num/100 != 0){
            m = num/100;
        }else if (num/10!=0){
            m = num/10;
        }else if (num!=0){
            m = num;
        }
        return m;
    }

}
