package others;

import org.junit.Test;

/**
 * Created by 钱斌 on 2016/11/8.
 */
public class OtherTest {
    @Test
    public void testByte() {
        byte b = -3;
        System.out.println(b);//-3
        System.out.println(b & 0xff);//253,以无符号值输出
        int i1 = (int) b;
        int i2 = b & 0xff;
        System.out.println((byte) i1 == b);//true
        System.out.println((byte) i2 == b);//true
    }
}
