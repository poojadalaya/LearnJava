import java.lang.*;
public class TappingRainWater {
    public static void main(String args[]) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int waterTrapped = trapUsingDP(arr);
        System.out.println("Water trapped in DP approach = "+waterTrapped);

    }
    public static int trapUsingTwoPointer(int[] height) {
        int water = 0;
        int l = 0;
        int r = height.length-1;

        return water;
    }
    public static int trapUsingDP(int[] height) {
        int water = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];
        for(int i=1; i<height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        for(int i=height.length-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        for(int i=0; i<height.length; i++) {
            water = water+Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return water;
    }
}
