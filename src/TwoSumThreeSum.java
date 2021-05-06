import java.util.*;

public class TwoSumThreeSum {

    public static void main(String args[]) {

        int[] arr = {2,7,11,15};
        System.out.println("Leetcode problem #1 2 sum with [2,7,11,15] and k=9:"
                + twoSum(arr,9)[0] + "," + twoSum(arr,9)[1]);
        System.out.println("Leetcode problem #167 2 sum with sorted array [2,7,11,15] and k=9 (1-indexed):"
                + sortedArrayTwoSum(arr,9)[0] + "," + sortedArrayTwoSum(arr,9)[1]);
        int[] nums = {-1,0,1,2,-1,-4}; //Sorted array: {-4,-1,-1,0,1,2}
        List<List<Integer>> ans = threeSumAddingUptoZero(nums);
        System.out.println("Size of ans:"+ans.size());
    }

    public static List<List<Integer>> threeSumAddingUptoZero(int nums[]) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(i==0 || nums[i-1]!=nums[i]) {
                sortedTwoSumForThreeSum(nums, i, ans);
            }
        }
        return ans;
    }

    public static void sortedTwoSumForThreeSum(int nums[], int i, List<List<Integer>> ans) {
        int l = i+1;
        int r = nums.length -1;
        while(l<r) {
            int sum = nums[l] + nums[r] + nums[i];
            System.out.println("i:"+i+" nums[i]:"+nums[i]+" l:"+l+" nums[l]:"+nums[l]+" r:"+r+" nums[r]:"+nums[r]+" SUM:"+sum);
            if(sum==0) {
                ans.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[l],nums[r])));
                System.out.println("Pooja here:"+nums[i]+", "+nums[l]+", "+nums[r]);
                l++;
                r--;
                while(l<r && nums[l-1]==nums[l]) {
                    l++;
                }
            } else if(sum>0) {
                r--;
            } else if(sum<0) {
                l++;
            }
        }
    }

    public static int[] sortedArrayTwoSum(int nums[], int k) {
        /*
         * Problem is to return the indices i,j such that nums[i]+nums[j]=k
         * Given that the array is sorted
         * Two Sum II uses the two pointers pattern and also has \mathcal{O}(N)O(N) time complexity for a sorted array.
         *  We can use this approach for any array if we sort it first,
         *  which bumps the time complexity to O(nlogn).
         * */
        int[] output = new int[2];
        int l = 0;
        int r = nums.length-1;
        while(l<r) {
            int sum = nums[l] + nums[r];
            if(sum==k) {
                output[0] = l+1; //As it is 1-indexed
                output[1] = r+1; //As it is 1-indexed
                break;
            }
            if(sum>k) {
                r--;
            } else {
                l++;
            }
        }
        return output;
    }

    public static int[] twoSum(int nums[], int k) {
        /*
        * Problem is to return the indices i,j such that nums[i]+nums[j]=k
        * Two Sum uses a hashmap to find complement values, and therefore achieves O(N) time complexity.
        * */
        int[] output = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(k-nums[i])) {
                output[0] = map.get(k-nums[i]);
                output[1] = i;
                break;
            } else {
                map.put(nums[i],i);
            }
        }
        return output;
    }
}
