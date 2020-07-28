package hashmap;

import kotlin.collections.ArrayDeque;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] sums = {0, 0, 0, 0};
        int target = 9;
        //System.out.println(Arrays.toString(twoSum(sums, target)));
        System.out.println(threeSum(sums));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (hashMap.containsKey(a) && hashMap.get(a) != i) {
                return new int[]{hashMap.get(a), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        int[] num = {nums[i], nums[j], nums[k]};
                        Arrays.sort(num);
                        arrayList.add(num[0]);
                        arrayList.add(num[1]);
                        arrayList.add(num[2]);
                        lists.add(arrayList);
                    }
                }
            }
        }
        /*if (!lists.isEmpty()) {
            for (int i = 0; i < lists.size() - 1; i++) {
                for (int j = i + 1; j < lists.size(); j++) {
                    if (lists.get(i).get(0).equals(lists.get(j).get(0))
                            && lists.get(i).get(1).equals(lists.get(j).get(1))
                            && lists.get(i).get(2).equals(lists.get(j).get(2))) {
                        lists.remove(j--);
                    }
                }
            }
        }*/
        return lists;
    }

}
