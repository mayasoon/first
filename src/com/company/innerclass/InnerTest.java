package com.company.innerclass;

/**
 * @author meng
 * @Data 2021/8/15 7:13 下午
 * @Desc 从上面可以看出，在run方法中访问的变量a根本就不是test方法中的局部变量a。这样一来就解决了前面所说的 生命周期不一致的问题。但是新的问题又来了，
 * 既然在run方法中访问的变量a和test方法中的变量a不是同一个变量，当在run方法中改变变量a的值的话，会出现什么情况？
 * 对，会造成数据不一致性，这样就达不到原本的意图和要求。为了解决这个问题，java编译器就限定必须将变量a限制为final变量，
 * 不允许对变量a进行更改（对于引用类型的变量，是不允许指向新的对象），这样数据不一致性的问题就得以解决了。
 */
public class InnerTest {
    public static void main(String[] args) {
        testFinal(90);
    }

    //为什么局部内部类和匿名内部类只能访问局部final变量？java 8 需要加final java 11 不需要加final

    /**
     * 当test方法执行完毕之后，变量a的生命周期就结束了，而此时Thread对象的生命周期很可能还没有结束，
     * 那么在Thread的run方法中继续访问变量a就变成不可能了，但是又要实现这样的效果，怎么办呢？Java采用了 复制  的手段来解决这个问题。
     * 这条指令表示将操作数10压栈，表示使用的是一个本地局部变量。这个过程是在编译期间由编译器默认进行，如果这个变量的值在编译期间可以确定，
     * 则编译器默认会在匿名内部类（局部内部类）的常量池中添加一个内容相等的字面量或直接将相应的字节码嵌入到执行字节码中。这样一来，
     * 匿名内部类使用的变量是另一个局部变量，只不过值和方法中局部变量的值相等，因此和方法中的局部变量完全独立开。
     */
    private static void testFinal(final int a){
        final int b = 30;
        new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("b = "+b + " a "+a);
            }
        }.start();
    }

}
