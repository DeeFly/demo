package com.gaofei.suanfa;

/**
 * Created by GaoQingming on 2018/1/13 0013.
 */
public class ByteStore {
    private byte[] storeByteArry = new byte[3000];

    //在指定的Index上存放MyItem的属性，这里的Index是0-999
    public boolean putMyItem(int index,MyItem item) {
        if (item == null) {
            return false;
        }
        int arrayPos = getArrayPos(index);
        storeByteArry[arrayPos] = item.getType();
        storeByteArry[++arrayPos] = item.getColor();
        storeByteArry[++arrayPos] = item.getPrice();
        return true;
    }

    //从指定的Index上查找MyItem的属性，并返回对应的MyItem对象。
    public MyItem getMyItem(int index) {
        int arrayPos = getArrayPos(index);
        if (storeByteArry[arrayPos] == 0) {
            return null;
        }
        return new MyItem(storeByteArry[arrayPos],storeByteArry[++arrayPos],storeByteArry[++arrayPos]);
    }

    public void sortMyItem() {
        quickSort(storeByteArry,0,999);
    }

    private void quickSort(byte[] array,int start,int end) {
        if (array == null || start >= end) return ;

        int middlePos = quickSortOnce(array,start,end);
        quickSort(array,start,middlePos - 1);
        quickSort(array,middlePos + 1,end);
    }

    private int quickSortOnce(byte[] array,int start,int end) {
        int i = start;
        int j = end;
        MyItem middleItem = getMyItem(start);
        while (i < j) {
            while (i < j && storeByteArry[getArrayPos(j) + 2] >= middleItem.getPrice()) {
                j--;
            }
            if (i < j) {
                swapMyItem(i,j);
            }
            while (i < j && storeByteArry[getArrayPos(i) + 2] <= middleItem.getPrice()){
                i ++;
            }
            if (i < j) {
                swapMyItem(i,j);
            }
        }
        putMyItem(i,middleItem);
        return i;
    }

    private void swapMyItem(int i, int j) {
        MyItem itemI = getMyItem(i);
        putMyItem(i,getMyItem(j));
        putMyItem(j,itemI);
    }

    private int getArrayPos (int pos) {
        if (pos < 0 || pos >= 1000) {
            throw  new RuntimeException();
        }
        return 3 * pos;
    }
}
