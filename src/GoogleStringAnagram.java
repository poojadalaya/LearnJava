import java.util.Arrays;

public class GoogleStringAnagram {

    /*
    * Given two strings check if S2 contains S1's anagram or no
    *
    * Strategy:
    * 1) Use Arrays.equals to compare the frequency of letters in S1 and S2
    * 2) In order to use 1 - we need to have an array of 26 - i.e. for each letter
    * 3) In the first loop that you construct h1 and h2's alphabet frequency counts should be incremented only
    *       l1 position times - meaning h1 will contain all counts of str1 but h2 will contain only a window of length l1
    * 4) Now that we have the window for S2 - check if the arrays h1 & h2 are equal
    *       a) Yes ---> We found a match!
    *       b) Slide the window
    *           -> Decrement the alphabet present in lth position and increment l
    *           -> Increment r check if we didn't overflow and add 1 to rth position in h2
    * 5) Loop through 4 until S2's window is valid.
    *
    * */

    public static void main(String args[]) {

        System.out.println("Does bbpobac contain ab? "+ checkAnagram("ab", "bbpobac"));
        System.out.println("Does read contain ae? "+ checkAnagram("ea", "read"));

    }

    public static boolean checkAnagram(String str1, String str2) {
        //S1 = “ab”, S2 = “bbpobac”
        int l1 = str1.length();
        int l2 = str2.length();

        int h1[] = new int[26];
        int h2[] = new int[26];
        int l=0, r=0;

        if(l2<l1) return false;

        for(int i=0; i<l1; i++) {
            h1[str1.charAt(i) - 'a'] += 1;
            h2[str2.charAt(i) - 'a'] += 1;
            r++;
        }
        r -= 1; // Now we have defined a window of length of S1 but on S2

        while(r<l2 && l<r) {
            if(Arrays.equals(h1, h2)) {
                return true;
            }
            r++;
            if(r != l2) {
                h2[str2.charAt(r) - 'a'] += 1;
            }
            h2[str2.charAt(l) - 'a'] -=1;
            l++;
        }
        return false;
    }
}
