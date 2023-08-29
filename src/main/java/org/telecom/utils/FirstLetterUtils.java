package org.telecom.utils;
import net.sourceforge.pinyin4j.PinyinHelper;

public class FirstLetterUtils {
    /**
     * 获取汉字首字母（优化版）
     * @param str 需要转换的汉字字符串
     * @return 返回汉字首字母
     */
    public static String getFirstLetterOptimized(String str) {
        StringBuilder firstLetter = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (ch >= 0x4e00 && ch <= 0x9fa5) { // 判断是否为汉字
                String pinyin = PinyinHelper.toHanyuPinyinStringArray(ch)[0]; // 获取汉字拼音
                firstLetter.append(pinyin.charAt(0)); // 获取拼音首字母
            } else {
                firstLetter.append(ch);
            }
        }
        return firstLetter.toString().toUpperCase();
    }
}
