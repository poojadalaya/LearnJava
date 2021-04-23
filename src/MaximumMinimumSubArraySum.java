import java.util.*;
import java.util.List;

//Split the given array into K sub-arrays such that maximum sum of all sub arrays is minimum
public class MaximumMinimumSubArraySum {

    public static void main(String args[]) {

        int k=3;
        int[] arr = {1,2,3,4};
        /* List<List<Integer>> subArrays = generateSubArrays(arr, k);
           printSubArrays(subArrays);
           Strategy is to use Binary Search over the sum space i.e. 1 to 10
           Then check with sum as this mid value can we construct k sub arrays
           If we can then we have a solution
           [1,2,3,4] , k=3
           [1][2,3][4] --> [1,5,4]
           [1][2][3,4] --> [1,2,7]
           [1,2][3][4] --> [3,3,4]
           Now, take the min of all three arrays : [1,1,3] ---> This is what we have to maximize
           Ans: 3
           Listing all the subarrays is a 4D DP problem hence we need to think out of the box. Listing all subarrays is never a solution
           Credit for logic: https://www.geeksforgeeks.org/split-the-given-array-into-k-sub-arrays-such-that-maximum-sum-of-all-sub-arrays-is-minimum/
        */

        int ans = 0;
        int l =1;
        int r =findSum(arr);
        System.out.println("We will start Binary search from "+l+" to "+r);
        while(r>=l) {
            int mid = (r+l)/2;
            if(canWeConstructKSubArrays(arr, k, mid)) {
                ans = mid;
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        System.out.println("Pooja ans is:"+ans);
    }

    public static int findSum(int arr[]) {
        int sum = 0;
        for(int i: arr) {
            sum += i;
        }
        return sum;
    }

    public static boolean canWeConstructKSubArrays(int[] arr, int k, int mid) {
        int origK = k;
        int runningSum = 0;
        for(int i=0; i<arr.length; i++) {
            runningSum += arr[i];
            if(runningSum>=mid) {
                k--;
                runningSum = 0;
            }
        }
        boolean val = k==0;
        System.out.println("Can we construct with k="+origK+" and mid="+mid+"? "+val);
        return val;
    }

    public static List<List<Integer>> generateSubArrays(int[] arr, int k) {
        //We should generate n*(n+1)/2 sub arrays, n=4 then 10 subarrays
        int[][] output = new int[2][2];
        ArrayList<List<Integer>> temp = new ArrayList<>();
        //Window method
        for(int i=0;i<arr.length;i++) {
            for(int group = 1; group<= arr.length; group++) {
                List<Integer> x = new ArrayList<>();
                for (int j = i; j < group; j++) {
                    //System.out.println("Generating sequence " + i + " to " + j + " Single list is:" + x);
                    x.add(arr[j]);
                }
                if(x.size()>0)
                {
                    temp.add(x);
                }
            }
        }
        return temp;
    }

    public static void printSubArrays(List<List<Integer>> subArrays) {
        for(List<Integer>  x: subArrays) {
            System.out.print("[");
            for (int y: x) {
                System.out.print(" "+y);
            }
            System.out.println("]");
        }
        System.out.println("The total number of subarrays generated are:"+subArrays.size());
        int n = subArrays.size();
        int actualCount = n*(n+1)/2;
        if(actualCount!=subArrays.size()) {
            System.out.println("Something went wrong!!! Please check if rounding off might be wrong or subarrays are wrong!");
        } else {
            System.out.println("Number of subarrays generated is correct");
        }
    }
}
