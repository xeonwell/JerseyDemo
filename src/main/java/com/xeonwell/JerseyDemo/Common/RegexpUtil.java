package com.xeonwell.JerseyDemo.Common;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xeonwell on 2017-04-24.
 *
 * regexp utils
 */
public class RegexpUtil {

    /**
     *
     * @param str
     * @param replacement
     * @param func
     * @return
     */
    public static String replace(String str, String replacement, Function<Matcher, String> func) {
        return replace(str, replacement, func, 0);
    }

    /**
     *
     * @param str
     * @param replacement
     * @param func
     * @param flags
     * @return
     */
    public static String replace(String str, String replacement, Function<Matcher, String> func, int flags) {
        if (str == null || str.isEmpty()) return str;
        Pattern p = Pattern.compile(replacement, flags);
        Matcher m = p.matcher(str);
        boolean result = m.find();
        StringBuffer sb = new StringBuffer();
        do {
            String res = func.apply(m);
            m.appendReplacement(sb, res);
            result = m.find();
        } while (result);
        m.appendTail(sb);

        return sb.toString();
    }
}
