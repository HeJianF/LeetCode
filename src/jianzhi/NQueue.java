package jianzhi;

public class NQueue {

    public static void main(String[] args) {
        //int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //System.out.println(search(nums, 3));
        System.out.println(mySqrt1(2147395599));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 1, r = x, res = 0;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (m == x / m) {
                return m;
            } else if (m < x / m) {
                l = m + 1;
                res = m;
            } else {
                r = m - 1;
            }
        }
        return res;
    }

    public static int mySqrt1(int x) {
        double r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
