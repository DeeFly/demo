package com.gaofei.leetCode;

/**
 * 从两个排序的数组中寻找中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 * Created by GaoQingming on 2018/9/12 0012.
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            nums1 = new int[0];
        }
        if (nums2 == null) {
            nums2 = new int[0];
        }

        if (nums1.length == 0 && nums2.length == 0) {
            return 0d;
        } else {
            int[] num = buildSortedArray(nums1, nums2);
        }
        return 0;
    }

    private int[] buildSortedArray(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums2;
        } else if (nums2.length == 0) {
            return nums1;
        } else {
            return dobuildSortedArray(nums1, nums2);
        }
    }

    private int[] dobuildSortedArray(int[] nums1, int[] nums2) {
        return null;
    }
}
