
package com.dinstone.naming.model;

import java.util.Arrays;

public class Xing {

    /** 姓氏 */
    private Word[] words;

    public Xing(Word... xingShi) {
        if (xingShi == null) {
            throw new IllegalArgumentException("姓氏不能为空");
        }
        if (xingShi.length > 2) {
            throw new IllegalArgumentException("姓氏不能超过2个汉字");
        }
        words = xingShi;
    }

    /**
     * Description: 计算天格
     * 
     * @return
     */
    public WuGe getTianGe() {
        int tgs = getTianGeShu();
        return new WuGe(tgs);
    }

    public int getTianGeShu() {
        int tgs = 0;
        if (words.length == 1) {
            tgs = words[0].getKxStroke() + 1;
        } else {
            tgs = words[0].getKxStroke() + words[1].getKxStroke();
        }
        return tgs;
    }

    /**
     * Description: the xing to get
     * 
     * @return the xing
     * 
     * @see Xing#words
     */
    public Word[] getXing() {
        return words;
    }

    @Override
    public String toString() {
        return "姓氏=" + Arrays.toString(words) + "]";
    }

}
