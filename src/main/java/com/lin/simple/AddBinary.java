package com.lin.simple;

/**
 * <p>TODO: 二进制两数相加并且二进制结果输出</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/10/11 12:58
 */
public class AddBinary {

    public static void main(String[] args) {
        String a = "11";
        String b = "11";
        System.out.println(addBinary(a, b));
        System.out.println(myAddBinary(a, b));

    }

    public static String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int maxLen = Math.max(aLen, bLen);
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            carry += i < aLen ? a.charAt(aLen - 1 - i) - '0' : 0;
            carry += i < bLen ? b.charAt(bLen - 1 - i) - '0' : 0;
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    /**
     *    100    10
     *    111     1
     *   1011    11
     * @param a
     * @param b
     * @return
     */
    public static String myAddBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int maxLen = Math.max(aLen, bLen);
        int carry = 0; //进位
        StringBuilder resultStr = new StringBuilder();
        for (int i=0;i<maxLen;i++){
            carry += i < aLen ? a.charAt(aLen - 1 - i) - '0' : 0; //i< aLen时 位数够，直接跟0做减法，得到进位
                                                                //eg： 当前位是1，1-0 =1 carry=0+1=1
            carry += i < bLen ? b.charAt(bLen - 1 - i) - '0' : 0; //i< bLen时 位数够，直接跟0做减法，得到进位
                                                                // 当前位是1，1-0 =1 carry=1+1=2
            resultStr.append((char) (carry % 2 + '0')); //当前位是1，1%2=1，1+0=1  结果位追加的是carry%2的结果
            carry /= 2; //carry=2/2=1 得到下一位的进位
        }
        if (carry > 0) {
            resultStr.append('1');  //最后一位进位
        }
        return resultStr.reverse().toString();  //反转字符串
    }
}
