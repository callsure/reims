import org.junit.Before;
import org.junit.Test;
import org.reims.asm.MethodAccess;

import java.lang.reflect.Method;

/**
 * 2021/6/11
 * Created by runshu.lin
 */
public class MethodAccessTest {
    private final TestDto bean = new TestDto();
    private Method method;// JDK的反射.
    private MethodAccess access;// ReflectAsm
    private int methodIndex;

    @Before
    public void setUp() throws Exception {
        method = TestDto.class.getMethod("setId", int.class);
        access = MethodAccess.get(TestDto.class);
        methodIndex = access.getIndex("setId");
    }

    @Test
    public void test() throws Exception {
        access.invoke(bean, methodIndex, 3);
        System.out.println(bean.getId());
    }
}
