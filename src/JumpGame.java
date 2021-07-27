import java.io.*;
public class JumpGame {
    public static void main(String args[]) {
        int nums[] = {2,3,1,1,4};
        boolean output = canJumpDPBUApproach(nums);//canJumpDPTDApproach(nums);//canJump(nums);
        System.out.println("The output is:"+output);
    }
    public static  boolean canJumpGreedyApproach(int[] nums) {
        int lastPos = nums.length-1;
        for(int i=nums.length-2; i>=0; i--) {
            if(i+nums[i]>=lastPos) {
                lastPos = i;
            }
        }
        return lastPos==0;
    }
    public static boolean canJumpDPBUApproach(int[] nums) {
        int[] memo = new int[nums.length];
        for(int i=0; i< nums.length; i++) {
            memo[i] = -1;
        }
        memo[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--) {
            for(int j=i+1,x=0; j<nums.length&&x<nums[i]; j++,x++) {
                if(memo[j]==1) {
                    memo[i] = 1;
                    break;
                }
            }
        }
        return memo[0]==1;
    }
    public static boolean canJumpDPTDApproach(int[] nums) {
        int[] memo = new int[nums.length];
        for(int i=0; i< nums.length; i++) {
            memo[i] = -1;
        }
        return canJumpFromDPTDApproach(0, nums, memo);
    }
    public static boolean canJumpFromDPTDApproach(int pos, int[] nums, int[] memo) {
        if(memo[pos]==1 || pos == nums.length-1) {
            return true;
        } else if(memo[pos]==0) {
            return false;
        }
        for(int x=pos+1,i=0; x<nums.length&&i<nums[pos]; x++,i++) {
            System.out.println("Printing from position "+x+" with value "+nums[pos]+" at iteration "+i);
            if(canJumpFromDPTDApproach(x, nums, memo)) {
                memo[x] = 1;
                return true;
            } else {
                memo[x] = 0;
            }
        }
        return false;
    }
    public static boolean canJump(int[] nums) {
        return canJumpFrom(0, nums);
    }
    public static boolean canJumpFrom(int pos, int[] nums) {
        if(pos == nums.length-1) {
            return true;
        }
        for(int x=pos+1,i=0; x<nums.length&&i<nums[pos]; x++,i++) {
            System.out.println("Printing from position "+x+" with value "+nums[pos]+" at iteration "+i);
            if(canJumpFrom(x, nums)) {
                return true;
            }
        }
        return false;
    }
}
