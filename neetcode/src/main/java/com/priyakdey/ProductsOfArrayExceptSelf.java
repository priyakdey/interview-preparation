package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class ProductsOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int prefixProduct = 1, suffixProduct = 1;

        int[] products = new int[length];
        Arrays.fill(products, 1);
        
        int left = 1, right = length - 2;
        
        while (left < length) {
            prefixProduct *= nums[left - 1];
            products[left] *= prefixProduct;
            left++;
            
            suffixProduct *= nums[right + 1];
            products[right] *= suffixProduct;
            right--;
        }

        return products;
    }

}
