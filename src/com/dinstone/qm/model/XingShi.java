
package com.dinstone.qm.model;

public class XingShi {

    /** 姓氏 */
    private Word[] xing;

    public XingShi(Word[] xingShi) {
        if (xingShi == null) {
            throw new IllegalArgumentException("姓氏不能为空");
        }
        if (xingShi.length > 2) {
            throw new IllegalArgumentException("姓氏不能超过2个汉字");
        }
        xing = xingShi;
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
        if (xing.length == 1) {
            tgs = xing[0].getKxStroke() + 1;
        } else {
            tgs = xing[0].getKxStroke() + xing[1].getKxStroke();
        }
        return tgs;
    }

    /**
     * Description: the xing to get
     * 
     * @return the xing
     * @see XingShi#xing
     */
    public Word[] getXing() {
        return xing;
    }

}
