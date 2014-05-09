
package com.dinstone.qm.model;

public class WuGe {

    /** 五行属性 */
    private WuXing attribute;

    /** 五格数 */
    private int wuGeShu;

    public WuGe(int wuGeShu) {
        this.wuGeShu = wuGeShu;
        attribute = WuXing.calculate(wuGeShu);
    }

    /**
     * Description: the attribute to get
     * 
     * @return the attribute
     * @see WuGe#attribute
     */
    public WuXing getAttribute() {
        return attribute;
    }

    /**
     * Description: the wuGeShu to get
     * 
     * @return the wuGeShu
     * @see WuGe#wuGeShu
     */
    public int getWuGeShu() {
        return wuGeShu;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return wuGeShu + "[" + attribute + "]";
    }

}
