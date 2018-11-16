package com.gaofei.map;

/**
 * Created by GaoQingming on 2018/9/29 0029.
 */
class MyHashMap {
    public static void main(String[] args) {
        MyHashMap myHashMap  = new MyHashMap();
        String[] arrString = {"remove","put","remove","remove","get","remove","put","get","remove","put","put","put","put","put","put","put","put","put","put","put","remove","put","put","get","put","get","put","put","get","put","remove","remove","put","put","get","remove","put","put","put","get","put","put","remove","put","remove","remove","remove","put","remove","get","put","put","put","put","remove","put","get","put","put","get","put","remove","get","get","remove","put","put","put","put","put","put","get","get","remove","put","put","put","put","get","remove","put","put","put","put","put","put","put","put","put","put","remove","remove","get","remove","put","put","remove","get","put","put"};
        String p = "27],[65,65],[19],[0],[18],[3],[42,0],[19],[42],[17,90],[31,76],[48,71],[5,50],[7,68],[73,74],[85,18],[74,95],[84,82],[59,29],[71,71],[42],[51,40],[33,76],[17],[89,95],[95],[30,31],[37,99],[51],[95,35],[65],[81],[61,46],[50,33],[59],[5],[75,89],[80,17],[35,94],[80],[19,68],[13,17],[70],[28,35],[99],[37],[13],[90,83],[41],[50],[29,98],[54,72],[6,8],[51,88],[13],[8,22],[85],[31,22],[60,9],[96],[6,35],[54],[15],[28],[51],[80,69],[58,92],[13,12],[91,56],[83,52],[8,48],[62],[54],[25],[36,4],[67,68],[83,36],[47,58],[82],[36],[30,85],[33,87],[42,18],[68,83],[50,53],[32,78],[48,90],[97,95],[13,8],[15,7],[5],[42],[20],[65],[57,9],[2,41],[6],[33],[16,44],[95,30";
        String[] pArr = p.split("],\\[");
        System.out.print("[null,");
        for(int i = 0; i < arrString.length; i++){
            String m = arrString[i];
            if(m.equals("remove")){
                myHashMap.remove(myHashMap.getInt(pArr[i]));
                System.out.print("null");
            }else if(m.equals("put")){
                String[] param = pArr[i].split(",");
                if(85 == Integer.valueOf(param[0])){
                    System.out.println();
                }
                myHashMap.put(Integer.valueOf(param[0]),Integer.valueOf(param[1]));
                System.out.print("null");
            }else if(m.equals("get")){
                if(42 == myHashMap.getInt(pArr[i])){
                    System.out.println();
                }
                System.out.print(myHashMap.get(myHashMap.getInt(pArr[i])));
            }
            System.out.print(",");
        }
        System.out.print("]");

    }

    /**
     * Initialize your data structure here.
     */
    Node[] nodeArr;
    final int capacity = 16;

    public MyHashMap() {
        nodeArr = new Node[capacity];
    }

    /**
     * value will always be positive.
     */
    public void put(int key, int value) {
        int hash = getHash(key);
        Node node = nodeArr[hash];
        if (node == null) {
            nodeArr[hash] = new Node();
            nodeArr[hash].key = key;
            nodeArr[hash].value = value;
            return;
        }
        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        newNode.next = nodeArr[hash];
        nodeArr[hash] = newNode;
    }

    private int getInt(String s){
        return Integer.valueOf(s);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hash = getHash(key);
        Node node = nodeArr[hash];
        if (node == null) {
            return -1;
        }

        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = getHash(key);
        Node node = nodeArr[hash];
        Node before = null;
        if (node == null) {
            return;
        }
        while (node != null) {
            if (node.key == key) {
                if (before == null) {
                    if (nodeArr[hash] != null) {
                        nodeArr[hash] = nodeArr[hash].next;
                    }
                    return;
                }
                before.next = node.next;
                return;
            }
            before = node;
            node = node.next;
        }
    }

    private int getHash(int key) {
        return key & capacity - 1;
    }
}


class Node {
    int key;
    int value;
    Node next;
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

