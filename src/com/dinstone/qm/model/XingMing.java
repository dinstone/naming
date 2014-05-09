
package com.dinstone.qm.model;

public class XingMing {

    /** 姓氏 */
    private XingShi xingShi;

    /** 名字 */
    private Word[] ming;

    /** 三才配置 */
    private SanCaiPeiZhi sanCaiPeiZhi;

    public XingMing(XingShi xingShi, Word[] ming, SanCaiPeiZhi sanCaiPeiZhi) {
        if (ming == null || ming.length != 2) {
            throw new IllegalArgumentException("名字必须为2个汉字");
        }

        this.xingShi = xingShi;
        this.ming = ming;
        this.sanCaiPeiZhi = sanCaiPeiZhi;
    }

    /**
     * Description: 天格数
     * 
     * @return
     */
    public int getTianGeShu() {
        return xingShi.getTianGeShu();
    }

    /**
     * Description: 人格数
     * 
     * @return
     */
    public int getRenGeShu() {
        Word[] xs = xingShi.getXing();
        int tgs = 0;
        if (xs.length == 1) {
            tgs = xs[0].getKxStroke() + ming[0].getKxStroke();
        } else {
            tgs = xs[1].getKxStroke() + ming[0].getKxStroke();
        }
        return tgs;
    }

    /**
     * Description: 地格数
     * 
     * @return
     */
    public int getDiGeShu() {
        return ming[0].getKxStroke() + ming[1].getKxStroke();
    }

    /**
     * Description: 总格数
     * 
     * @return
     */
    public int getZongGeShu() {
        int zgs = 0;
        Word[] xs = xingShi.getXing();
        for (Word x : xs) {
            zgs += x.getKxStroke();
        }

        for (Word m : ming) {
            zgs += m.getKxStroke();
        }
        return zgs;
    }

    /**
     * Description: 外格数
     * 
     * @return
     */
    public int getWaiGeShu() {
        Word[] xs = xingShi.getXing();
        int tgs = 0;
        if (xs.length == 1) {
            tgs = ming[1].getKxStroke() + 1;
        } else {
            tgs = xs[1].getKxStroke() + ming[1].getKxStroke();
        }
        return tgs;
    }

    /**
     * Description: the xingShi to get
     * 
     * @return the xingShi
     * @see XingMing#xingShi
     */
    public XingShi getXingShi() {
        return xingShi;
    }

    /**
     * Description: the ming to get
     * 
     * @return the ming
     * @see XingMing#ming
     */
    public Word[] getMing() {
        return ming;
    }

    /**
     * Description: the sanCaiPeiZhi to get
     * 
     * @return the sanCaiPeiZhi
     * @see XingMing#sanCaiPeiZhi
     */
    public SanCaiPeiZhi getSanCaiPeiZhi() {
        return sanCaiPeiZhi;
    }

}
