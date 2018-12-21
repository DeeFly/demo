package com.gaofei.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * T 和 ? 的区别 ：
 * T 在乎具体的类型， ? 不在乎具体的类型
 * 因此在往集合中添加元素的时候，（此时要用 <? super Parent> 可以插入任意Parent的子类
 * 而<T extends Parent> 这种写法是错误的，没有这种写法，（可能是担心插入Parent的各种子类，而T 希望的是单一特定的类型）
 * 总的来说 ? 比 T 更宽泛一些
 * Created by GaoQingming on 2018/10/18 0018.
 */
public class ExtendSuperTest {

    public void testList(List<? extends Parent> extendsList, List<? super Parent> superList, Class<? extends Parent> typeExtends, Class<? super Parent> typeSuper) throws IllegalAccessException, InstantiationException {
        Parent p = extendsList.get(0);
        //Parent p1 = superList.get(0);
        //extendsList.add(typeExtends.newInstance());
        //extendsList.add(typeSuper.newInstance());
        superList.add(typeExtends.newInstance());
        //superList.add(typeSuper.newInstance());
    }

    public void test2(List<? extends Child> extendsChild, List<? super Child> superChild) {
        Child child = extendsChild.get(0);
        //Child child1 = superChild.get(0);
        //superChild.add(new Parent());
        superChild.add(new Child());
        superChild.add(new ChildChild());
    }

    public void foo(List<? super Child> list) {
        list.add(new ChildChild());
    }

    public void foo2(List<? extends Child> list) {
        Parent parent = list.get(0);
    }

    public void testInvokeParent(List<Parent> parentList, List<Child> childList, List<ChildChild> childChildList) {
        test2(childList,parentList);
        test2(childChildList, childList);
    }
    public void testInvoke() {
        List<Child> children = new ArrayList<>();
    }

    class ChildChild extends Child {
        private String childChild;

        public String getChildChild() {
            return childChild;
        }

        public void setChildChild(String childChild) {
            this.childChild = childChild;
        }
    }

    class Child extends Parent {
        private String child;

        public String getChild() {
            return child;
        }

        public void setChild(String child) {
            this.child = child;
        }
    }

    class Parent implements Comparable<Parent>{
        protected String parent;

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        @Override
        public int compareTo(Parent o) {
            return 0;
        }
    }
}
