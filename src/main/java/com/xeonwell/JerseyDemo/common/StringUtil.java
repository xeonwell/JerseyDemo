package com.xeonwell.JerseyDemo.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xeonwell on 2017-04-24.
 */
public class StringUtil {
    /**
     * @param str
     * @return
     */
    public static String toCamelCase(String str) {
        return toCase(str, TransformType.Camel);
    }

    public static String toPascal(String str) {
        return toCase(str, TransformType.Pascal);
    }

    public static String toSnake(String str) {
        return toCase(str, TransformType.Snake);
    }

    private final static String RegSnake = "[_-]([a-z])";
    private final static String RegBigLetter = "[A-Z]";

    private static String toCase(String str, TransformType type) {
        if (str == null || str.isEmpty()) return str;

        Pattern p;
        if (type == TransformType.Snake) {
            p = Pattern.compile(RegBigLetter);
        } else {
            p = Pattern.compile(RegSnake, Pattern.CASE_INSENSITIVE);
        }
        Matcher m = p.matcher(str);
        boolean result = m.find();
        StringBuffer sb = new StringBuffer();
        do {
            if (type == TransformType.Snake) {
                String g = m.group();
                m.appendReplacement(sb, "_" + g.toLowerCase());
            } else {
                String g = m.group(1);
                m.appendReplacement(sb, g.toUpperCase());
            }

            result = m.find();
        } while (result);
        m.appendTail(sb);
        char f = sb.charAt(0);
        switch (type) {
            case Camel:
                if (f >= 'A' && f <= 'Z') {
                    f += 32;
                    sb.replace(0, 1, String.valueOf(f));
                }
                break;
            case Pascal:
                if (f >= 'a' && f <= 'z') {
                    f -= 32;
                    sb.replace(0, 1, String.valueOf(f));
                }
                break;
            case Snake:
                if (f == '_') {
                    sb.deleteCharAt(0);
                }
                break;
            default:
                break;
        }

        return sb.toString();
    }

    enum TransformType {
        Camel, Pascal, Snake
    }
}
