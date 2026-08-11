import java.util.*;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {

        Arrays.sort(nums, (a, b) -> {
            // Longer number is larger
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }

            // Same length -> lexicographical comparison
            return b.compareTo(a);
        });

        return nums[k - 1];
    }
}