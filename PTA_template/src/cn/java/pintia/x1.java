package cn.java.pintia;

import java.util.ArrayList;

public class x1 {
    public void test() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((String)list.get(i));
        }
    }
}
