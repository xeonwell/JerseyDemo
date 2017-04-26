import com.xeonwell.JerseyDemo.Common.RegexpUtil;
import com.xeonwell.JerseyDemo.Common.StringUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by xeonwell on 2017-04-24.
 */


public class TestStringUtil {
    @Test
    public void testCamelCase() {
        Assert.assertTrue(StringUtil.toCamelCase("aa_bbb-cc_Ddd").equals("aaBbbCcDdd"));
        Assert.assertTrue(StringUtil.toCamelCase("Aa_bbb-cc_Ddd").equals("aaBbbCcDdd"));
    }

    @Test
    public void testPascal(){
        Assert.assertTrue(StringUtil.toPascal("aa_bbb-cc_Ddd").equals("AaBbbCcDdd"));
        Assert.assertTrue(StringUtil.toPascal("Aa_Bbb-cc_Ddd").equals("AaBbbCcDdd"));
    }

    @Test
    public void testSnake(){
        Assert.assertTrue(StringUtil.toSnake("ToLowerCase").equals("to_lower_case"));
        Assert.assertTrue(StringUtil.toSnake("toLowerCase").equals("to_lower_case"));
    }

    @Test
    public void testRegReplace(){
        Assert.assertTrue(RegexpUtil.replace("aa_bbb-cc_Ddd", "[_-]([a-z])", (m) -> m.group(1).toUpperCase(), Pattern.CASE_INSENSITIVE).equals("aaBbbCcDdd"));
        Assert.assertTrue(RegexpUtil.replace("aa_bbb-cc_Ddd", "[_-]([a-z])", (m) -> m.group(1).toUpperCase()).equals("aaBbbCc_Ddd"));
    }
}
