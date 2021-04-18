import java.io.*;
public class ConvertStringToIntAndAdd {

    public static void main(String args[]) {
        String sum = addStrings("123", "11");
        System.out.println(sum);
    }

    public static String addStrings(String num1, String num2) {
        int p1 = num1.length() -1;
        int p2 = num2.length() -1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (p1>=0 || p2>=0) {
            int dig1 = p1>=0 ? num1.charAt(p1) - '0' : 0;
            int dig2 = p2>=0 ? num2.charAt(p2) - '0' : 0;
            int val = (dig1 + dig2 + carry)%10;
            carry = (dig1 + dig2 + carry)/10;
            sb.append(val);
            p1--;
            p2--;
        }
        if(carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}