import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by xeonwell on 2017-04-28.
 */

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    int value();

    String name() default "undifined";
}

@Retention(RetentionPolicy.RUNTIME)
@interface AutoDefined {
}

public class TestAnnotation {


    @MyAnno(44)
    class AnnoTest {
        @AutoDefined
        public String str;

        @MyAnno(value = 33, name = "output")
        public void output() {
            System.out.println("output");
        }
    }

    @Test
    public void testAnnotation() {
        AnnoTest at = new AnnoTest();
        try {
            Method m = at.getClass().getMethod("output");
            MyAnno ma = m.getAnnotation(MyAnno.class);
            Assert.assertTrue(ma.value() == 33);
            Assert.assertTrue(ma.name().equals("output"));

            MyAnno ca = AnnoTest.class.getAnnotation(MyAnno.class);
            Assert.assertTrue(ca.value() == 44);

            Field f = at.getClass().getField("str");
            if (f.isAnnotationPresent(AutoDefined.class)) {
                f.set(at, "asdf");
            }

            Assert.assertTrue(at.str.equals("asdf"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
