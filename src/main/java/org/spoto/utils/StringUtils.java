package org.spoto.utils;

public class StringUtils {
    /**
     * 判断字符串为空
     * @param str
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * 判断字符串不为空
     * @param str
     * @return boolean
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断字符串全不为空
     * @param args
     * @return boolean
     */
    public static boolean isAllNotEmpty(String... args) {
        for (String arg : args) {
            if (isEmpty(arg)) {
                return false;
            }
        }
        return true;
    }
}
