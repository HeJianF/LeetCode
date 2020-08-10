import java.util.Arrays;

public class Test {
    public int majorityElement(int[] nums) {
        /*Arrays.sort(nums);
        return nums[nums.length / 2];*/
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }

    public int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                count += prices[i + 1] - prices[i];
            }
        }
        return count;
    }

    public boolean isSubsequence(String s, String t) {
        int count = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = index; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    count++;
                    index = j;
                    break;
                }
            }
        }
        return count == s.length();
    }
}
