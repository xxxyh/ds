package test;


import sun.misc.Unsafe;

/**
 * 无法执行的例子
 */
public class TestUnsafe {
    //获取unsafe实例
    static final Unsafe unsafe = Unsafe.getUnsafe();
    //记录变量state在类TestUnsafe中的偏移量
    static long stateOffset;

    private volatile long state = 0;

    static{
        try {
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestUnsafe test = new TestUnsafe();
        Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
