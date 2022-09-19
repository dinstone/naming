
package com.dinstone.qm.model;

public class WuGe {

    /** 五行属性 */
    private WuXing wuXing;

    /** 五格数 */
    private int wuGeShu;

    private String yinyang;

    public WuGe(int wuGeShu) {
        this.wuGeShu = wuGeShu;
        this.wuXing = WuXing.calculate(wuGeShu);
        if (wuGeShu == wuXing.getYangShu()) {
            yinyang = "阳";
        } else {
            yinyang = "阴";
        }
    }

    public WuXing getWuXing() {
        return wuXing;
    }

    /**
     * Description: the wuGeShu to get
     * 
     * @return the wuGeShu
     * 
     * @see WuGe#wuGeShu
     */
    public int getWuGeShu() {
        return wuGeShu;
    }

    @Override
    public String toString() {
        return "WuGe [wuXing=" + wuXing + ", wuGeShu=" + wuGeShu + ", yinyang=" + yinyang + "]";
    }

}
