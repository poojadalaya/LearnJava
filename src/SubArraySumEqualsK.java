import java.util.HashMap;

public class SubArraySumEqualsK {
    /*
    *   Input: nums = [1,1,1], k = 2
        Output: 2
    * */

    public static void main(String args[]) {
        int[] nums = {1,1,1};
        System.out.println("Leetcode problem #560 (Brute Force): Subarray Sum Equals K with input [1,1,1] with k=2 is:"+
                subarraySumBruteForce(nums, 2));
        int[] numsTest = {1,-1,0};
        System.out.println("Leetcode problem #560 (Brute Force): Subarray Sum Equals K with input [1,1,1] with k=2 is:"+
                subarraySumBruteForce(numsTest, 0));

        System.out.println("Leetcode problem #560 (Using HashMap): Subarray Sum Equals K with input [1,1,1] with k=2 is:"+
                subArraySum(nums, 2));
        System.out.println("Leetcode problem #560 (Using HashMap): Subarray Sum Equals K with input [1,1,1] with k=2 is:"+
                subArraySum(numsTest, 0));
    }

    public static int subArraySum(int[] nums, int k) {
        /*
        * The strategy here is:
        * 1) Between any two indices if the cumulative sum at each of those points
        *       is the same then the sum of elements between them is 0
        * 2) On the similar lines if between any two indices if the cumulative sum at each of those points
        *       differs by k then we need to consider how many sub arrays had cumulativeSum-k
        * 3) We can maintain a hash map with (cumulativeSum, noOfOccurrences) and if we see a new cumulativeSum
        *       add it to this hash map
        * 4) When we see that the map contains cumulativeSum-k, we will add all its occurrences to our count
        * 5) Why not increment by 1? - we need to consider all sub arrays
        *       Eg: [1,-1,1,-1], k=0 - cnt will be 4 not 2
        * TC: O(n)
        * SC: O(n)
        * */
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int cumulativeSum = 0;
        for(int i=0; i<nums.length; i++) {
            cumulativeSum += nums[i];
            if(map.containsKey(cumulativeSum-k)) {
                cnt += map.get(cumulativeSum-k);
            } //Order is imp first increment cnt then only insert in map
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum,0)+1);
        }
        return cnt;
    }

    public static int subarraySumBruteForce(int[] nums, int k) {
        int x = 0;
        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            innerloop:
            for(int j=i; j<nums.length && j>=i; j++) {
                sum += nums[j];
                if(sum == k) {
                    x++;
                    continue innerloop;
                }
            }
        }
        return x;
    }
}
