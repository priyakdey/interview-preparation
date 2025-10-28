package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P0760 {

    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[] nums3 = new int[length];
        System.arraycopy(nums2, 0, nums3, 0, length);

        int[]  mapping = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (nums1[i] == nums3[j]) {
                    mapping[i] = j;
                    nums3[j] = -1;
                    break;
                }
            }
        }

        return mapping;
    }

}
