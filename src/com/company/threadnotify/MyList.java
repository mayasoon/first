package com.company.threadnotify;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private List<String> list = new ArrayList<>();
    public void add(){
        list.add("你好");
    }
    public int size(){
        return list.size();
    }
}
