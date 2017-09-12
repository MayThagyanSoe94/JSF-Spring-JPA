package com.exam.common;

/**
 * @author Zaw Than Oo
 */
public class FormatID {
    /**
     * This method is used to format plain id (plain number). Mostly,
     * this method is used in setId() methods of entities.
     * <p>
     * E.g.
     * Input: id=523, prefix="ACE", maxLength=15
     * Output: ACE000000000523
     * <p>
     * @param id id must not be null.
     * @param prefix prefix must not be null.
     * @param maxLength maximum length of the id string and it must not be negative number.
     * @return a formatted id string
     */
    public static String formatId(String id, String prefix, int maxLength) {
        if (!id.startsWith(prefix)) {
            int length = id.length() + prefix.length();
            for (; (maxLength - length) > 0; length++) {
                id = '0' + id;
            }
            id = prefix + id;
        }
        return id;
    }
}
