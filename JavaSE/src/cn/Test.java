package cn;

import java.math.BigInteger;

/**
 * Name: admin
 * Date: 2017/3/3
 * Time: 3:32
 */
public class Test {
    public static void main(String[] args){
        //test1();
        //用一个int类型的字段就可以表示每天某人是否有上班，1表示上班了，0表示没上报，因为一个int类型是32位的
        String a = "10000000";
        BigInteger bigA = new BigInteger(a,2);
        int x =  Integer.parseInt(bigA.toString());
        System.out.println(x);

        //Int 装换为2进制
        String y  = Integer.toBinaryString(x);
        System.out.println(y);
        //判断某天是否有上班，15号是否有上班
       System.out.println(isOnduty(y,2));
        System.out.println(y.indexOf("1"));
        System.out.println(y.indexOf("0"));

        byte[] bytesY = y.getBytes();
        System.out.println(bytesY);
        for (byte b : bytesY){
            System.out.println(b - 48);
        }
    }

    private static boolean isOnduty(String y, int day) {
        try{
            char char1 = y.charAt(day - 1);
            if (char1 == 49)
                return true;
            else
                return false;
        }catch (Exception e){
            return false;
        }
    }

    private static void test1() {
        Integer i = 999;

        int j = i;

        System.out.println( j == i);
    }
}
