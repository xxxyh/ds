package test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafe2 {
    static Unsafe unsafe;
    static long stateOffset;
    private volatile long state = 0;

    static{
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //可以通过反射访问私有类型
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(TestUnsafe2.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestUnsafe2 test = new TestUnsafe2();
        test.state = 1;
        Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 1, 2);
        System.out.println(success);
    }
}
