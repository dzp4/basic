package com.staduy.basic.sort;

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author dzp 2020/11/16
 */
public class BubbleSort {

    public static void main(String[] args) {
        // 初始化数组
        int[] arr = initArray();
        outArray(arr);

        // 倒序
        reverseSort(arr);
        outArray(arr);

        // 倒序优化
        reverseSortOptimization(arr);
        outArray(arr);

        // 倒序
        sortOptimization(arr);
        outArray(arr);

        // 顺序
        sort(arr);
        outArray(arr);

    }

    private static int[] initArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RandomUtil.randomInt(0, 100);
        }
        return arr;
    }

    private static void outArray(int[] arr) {
        System.out.println("\n" + Arrays.toString(arr));
    }

    /**
     * 最小的放到最后
     * 循环每一个元素，和其他元素比较
     *
     * @param arr int数组
     */
    private static void reverseSort(int[] arr) {
        int temp;
        int arrLength = arr.length;

        for (int i = 0; i < arrLength - 1; i++) {
            for (int j = 0; j < arrLength - i - 1; j++) {

                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }

    }

    /**
     * 将最小的放到最后
     * 减少循环次数，排一个就减少一次次数
     * 因为每次冒泡出来的一定是最小的
     *
     * @param arr int数组
     */
    private static void reverseSortOptimization(int[] arr) {
        int temp;
        int arrLength = arr.length;
        // 最后一轮不用比
        for (int i = arrLength; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {

                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }

    }

    /**
     * 将最大的放到最前面
     * 比较一个后就从下一个开始比较
     *
     * @param arr int数组
     */
    private static void sortOptimization(int[] arr) {
        int temp;
        int arrLength = arr.length;

        for (int i = 0; i < arrLength - 1; i++) {
            for (int j = i + 1; j < arrLength; j++) {

                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }

    }

    /**
     * 最小的放到最前面
     * 从最后一位开始比较
     *
     * @param arr int数组
     */
    private static void sort(int[] arr) {
        int temp;
        int arrLength = arr.length;

        for (int i = 0; i < arrLength - 1; i++) {
            for (int j = arrLength - 1; j > i; j--) {

                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }

            }
        }

    }

}
