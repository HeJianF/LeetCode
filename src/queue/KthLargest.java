package queue;

import java.util.*;

public class KthLargest {

    public static void main(String[] args) {
        /*KthLargeTest test = new KthLargeTest();
        int[] aar = {4, 5, 8, 2};
        test.KthLargest(3, aar);
        System.out.println(test.add(3));// returns 4
        System.out.println(test.add(5));// returns 5
        System.out.println(test.add(10));// returns 5
        System.out.println(test.add(9));// returns 8
        System.out.println(test.add(4));// returns 8*/
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, 3)));
    }

    static class KthLargeTest {
        private PriorityQueue<Integer> queue;
        private int k;

        public void KthLargest(int k, int[] nums) {
            this.k = k;
            queue = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.add(val);
            } else if (queue.peek() < val) {
                queue.poll();
                queue.add(val);
            }
            return queue.peek();
        }
    }

    static class Solution {

        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int[] nums;

        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;
            // init deque and output
            this.nums = nums;
            int max_idx = 0;
            //int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
            for (int i = 0; i < k; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                // compute max in nums[:k]
                if (nums[i] > nums[max_idx]) max_idx = i;
            }
            int[] output = new int[n - k + 1];
            output[0] = nums[max_idx];

            // build output
            for (int i = k; i < n; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                output[i - k + 1] = nums[deq.getFirst()];
            }
            return output;
        }

        public void clean_deque(int i, int k) {
            // remove indexes of elements not from sliding window
            if (!deq.isEmpty() && deq.getFirst() == i - k) {
                deq.removeFirst();
            }

            // remove from deq indexes of all elements
            // which are smaller than current element nums[i]
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
                deq.removeLast();
            }
        }

    }
}

