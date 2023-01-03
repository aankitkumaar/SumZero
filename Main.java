import java.util.ArrayList;
import java.util.List;

public class Main {
  public static List<Integer> findElementsWithSumZero(int[] numbers) {
    // Edge case: empty array
    if (numbers.length == 0) {
      return null;
    }

    // We will use a hash map to store the numbers we have seen so far
    int[] prefixSums = new int[numbers.length];
    prefixSums[0] = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      prefixSums[i] = prefixSums[i - 1] + numbers[i];
    }

    // Check if any two prefix sums have the same value
    for (int i = 0; i < prefixSums.length; i++) {
      for (int j = i + 1; j < prefixSums.length; j++) {
        if (prefixSums[i] == prefixSums[j]) {
          // Return the elements between the two prefix sums
          List<Integer> result = new ArrayList<>();
          for (int k = i + 1; k <= j; k++) {
            result.add(numbers[k]);
          }
          return result;
        }
      }
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


//time complexity - O(n^2) and space complexity is O(n)
