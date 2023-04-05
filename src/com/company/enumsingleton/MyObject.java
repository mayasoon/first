package com.company.enumsingleton;

import com.company.Student;

/**
 * 枚举类单例比较完美，可以避免反射创建对象，因为枚举没有构造方法，也就无法反射出对象
 */
public enum MyObject {
    MY_INSTANCE;

    public String doSomeThing(){
        System.out.println(Thread.currentThread().getName()+"  "+this.hashCode());
        return " do 123";
    }

}
