package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        int gp = length - 1;

        for (int i = length -2; i >= 0; i--) {
            if (i + nums[i] >= gp) {
                gp = i;
            }
        }

        return gp == 0;
    }
}
