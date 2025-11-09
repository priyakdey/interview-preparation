package com.priyakdey.arrays;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class ArrayOfProducts {

    // Take suffixProduct = 1, and prefixProduct = 1.
    // Start iterating from index 1 for prefix product.
    // For every index, prefix_product *= array[left - 1]
    // Then we can say, the product from all elements in the left of it
    // is - products[left] *= prefix_product.

    // Do the same with a pointer from the right = length - 2.
    // This will get products of all elements from the right of that index.
    // We can do in a single while loop since left = [1, length - 1]
    // and right = [length - 2, 0, -1].
    // Which means, we can accumulate left and right products in a single scan...

    public int[] arrayOfProducts(int[] array) {
        int length = array.length;
        if (length == 1) return array;
        
        int prefixProduct = 1, suffixProduct = 1;
        int left = 1, right = length - 2;

        int[] products = new int[length];
        Arrays.fill(products, 1);
        
        while (left < length) {
            prefixProduct *= array[left - 1];
            products[left] *= prefixProduct;
            left++;

            suffixProduct *= array[right + 1];
            products[right] *= suffixProduct;
            right--;
        }

        return products;
    }

}
