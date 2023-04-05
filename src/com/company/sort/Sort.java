package com.company.sort;

import java.util.Arrays;

/**
 * @author meng
 * @Data 2021/8/14 10:11 下午
 * @Desc 排序算法
 */
public class Sort {
    //需要排序的数组
    private static final int[] array = {2,12,34,23,45,21,1,3,9,8,11};
    /**
     * @param array 待排序数组
     * @return 已排序数组
     * 时间复杂度，最低为O(n) 最差为O(n^2)
     */
    private static int [] sortBubble(int [] array){
        //将要返回的数组,这里for循环比较多少轮
        for (int i = 0; i < array.length-1; i++) {
            //每轮比较减一次
            for (int j = 0; j <array.length-1-i; j++) {
                int temp;//临时存储要交换的数值
                int current;//当前下标值
                int next;//要做比较的值
                current = array[j];
                next = array[j+1];
                if (current>next){
                    temp = current;
                    array[j] = next;
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        insertSort(array);
    }

    /**
     * 选择排序
     * @param array 待排序数组
     * 每次取序列中最小元素和待排序数组第一个元素交换,相比于冒泡排序，减少了大量的交换操作
     * 少循环一次可以忽略这个-1次，时间复杂度和冒泡排序相同
     */
    private static int[] selectSort(int[]array){
        for (int i = 0; i < array.length-1; i++) {//
            int current = array[i];;//去除当前需要比较的值，看看是否需要被交换
            int t = i;//最小值的下标
            for (int j = i+1; j < array.length; j++) {
                int next = array[j];
                if (current>next){//记录当前最小值
                    current = next;
                    t = j;
                }
            }
            //做交换
            int temp = array[i];
            array[i] = array[t];
            array[t] = temp;
        }
        return array;
    }

    /**
     * 插入排序
     *
     */
    public static void insertSort(int[] arr) {
        if(arr==null)
            return;
        int len=arr.length;
        //i控制循环次数，因为已经默认第一个数的位置是正确的，所以i的起始值为1，i<len，循环len-1次
        for(int i=1;i<len;i++) {
            int j=i;//变量j用来记录即将要排序的数的位置即目标数的原位置
            int target=arr[j];//target用来记录即将要排序的那个数的值即目标值
            //while循环用来为目标值在已经排好序的数中找到合适的位置，
            //因为是从后向前比较，并且是与j-1位置的数比较，所以j>0
            while(j>0 && target<arr[j-1]) {
                //当目标数的值比它当前位置的前一个数的值小时，将前一个数的位置向后移一位。
                //并且j--使得目标数继续与下一个元素比较
                arr[j]=arr[j-1];
                j--;
            }
            //更目标数的位置。
            arr[j]=target;
            //打印每次循环结束之后数组的排序状态（方便理解）
            System.out.println("第"+(i)+"次循环之后效果："+Arrays.toString(arr));
        }
    }

}
