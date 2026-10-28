import java.util.*;

public class General {
    public static void main(String[] args) {
    int[] arr = {2, 3, -2, 4};
    System.out.println("Maximum Product Subarray: " + maxProdSubarray(arr));

    int[][] arr2 = {
        {1, 1, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 0},
        {0, 0, 2, 4, 4, 0},
        {0, 0, 0, 2, 0, 0},
        {0, 0, 1, 2, 4, 0}
    };
    System.out.println("Maximum Hourglass Sum: " + maxHourglassSum(arr2));
}
    // Function to find the maximum product subarray
    public static int maxProdSubarray(int[] arr) {
        int n = arr.length;
        int prefix = 1;
        int suffix = 1;
        int ans = arr[0];

        for (int i = 0; i < n; i++) {
            // Reset product if it becomes 0
            prefix = (prefix == 0) ? 1 : prefix;
            suffix = (suffix == 0) ? 1 : suffix;

            prefix *= arr[i];
            suffix *= arr[n - 1 - i];

            ans = Math.max(ans, Math.max(prefix, suffix));
        }

        return ans;
    }

    // Function to find the maximum hourglass sum in a 2D array
    public static int maxHourglassSum(int[][] arr2) {
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < arr2.length - 1; i++) {
            for (int j = 1; j < arr2[0].length - 1; j++) {
                int sum = arr2[i - 1][j - 1] + arr2[i - 1][j] + arr2[i - 1][j + 1]
                        + arr2[i][j]
                        + arr2[i + 1][j - 1] + arr2[i + 1][j] + arr2[i + 1][j + 1];

                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
