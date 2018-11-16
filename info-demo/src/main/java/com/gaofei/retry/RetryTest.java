package com.gaofei.retry;

/**
 * 0  1  2  3  4  6  7  8  9
 * Created by GaoQingming on 2018/2/4 0004.
 */
public class RetryTest {
   public void retryTest() {
       retry:
       for (int i = 0; i < 10; i++) {
           for (int j = 0; j < 3; j++) {
               if (j == 2) {
                   //continue retry; //这个方法不管层数，直接跳到指定地方 但是循环中的值不变！
                   //continue ; 这个方法只能跳出一层循环，
                   //break ;  //这个方法只中断内层循环
                   break retry; //这个方法不管几层，直接中断retry下所有的循环。
               }
               System.out.print(j + "  ");
           }
           if (i == 5) {
               continue retry;
           }
           System.out.println(i + "  ");
       }
   }

   public void retryTest2() {
       boolean condition = true;
       retry2:
       while (condition) {
           System.out.println();
       }
   }

    public static void main(String[] args) {
        new RetryTest().retryTest();
    }
}
