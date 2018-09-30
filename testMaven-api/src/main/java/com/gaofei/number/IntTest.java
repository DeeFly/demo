package com.gaofei.number;

/**
 * Created by GaoQingming on 2018/9/6 0006.
 */
public class IntTest {
    public static void main(String[] args) {
        byte b1 = 86;
        byte b2 = 3;
        byte b3 = (byte)(b1 * b2);
        System.out.println(b3);

        System.out.println("-------------");
        int i = 1431655766 * 3;          //这里证明了这种运算是截取低位的，+ * 等。
        System.out.println(i);

        i = 1 << 32;
        System.out.println(i);           //这里证明了这种运算是截取高位的。

        System.out.println((int)1.621162912497823e+17);         //这里是证明了int强转截取最大值（如果越界了）
        //int x = 402636674 * 402636674;
        //System.out.println(402636674 * 402636674 / 402636674);
        //System.out.println(402636674 * 402636674);
        //System.out.println(x);
        //Double d = new Double(Math.pow(402636674, 2));
        //System.out.println(d.toString());
        //System.out.println(Math.pow(402636674, 2));
        //if (402636674 * 402636674 > 2147395599 || 402636674 * 402636674 < 0) {
        //    System.out.println(1);
        //} else if (402636674 * 402636674 < 2147395599){
        //    System.out.println(2);
        //} else {
        //    System.out.println(3);
        //}
    }
}
