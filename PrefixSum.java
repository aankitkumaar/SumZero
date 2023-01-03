package Contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrefixSum{
    public static List<Integer> findElementsWithSumZero(int[] numbers) {
        // Edge case: empty array
        if (numbers.length == 0) {
            return null;
        }

        // We will use a hash map to store the prefix sums we have seen so far
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, -1);  // Add a dummy entry for prefix sum 0 at index -1
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (prefixSums.containsKey(sum)) {
                // Return the elements between the two prefix sums
                List<Integer> result = new ArrayList<>();
                for (int j = prefixSums.get(sum) + 1; j <= i; j++) {
                    result.add(numbers[j]);
                }
                return result;
            }
            prefixSums.put(sum, i);
        }

        // If no pair of numbers with sum zero is found, return null
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {-4, 1, 3, -2, -1};
        List<Integer> result = findElementsWithSumZero(numbers);
        if (result == null) {
            System.out.println("No Elements found");
        } else {
            for (int number : result) {
                System.out.print(number + " ");  // Output: 3 -2 -1
            }
            System.out.println();
        }

        numbers = new int[] {1, 2, 3, 4};
        result = findElementsWithSumZero(numbers);
        if (result == null) {
            System.out.println("No Elements found");  // Output: No Elements found
        } else {
            for (int number : result) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
