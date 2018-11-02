package com.gaofei.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
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

    public void testInvokeParent(List<Parent> list) {

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
        public int compareTo(Object o) {
            return 0;
        }
    }
}
