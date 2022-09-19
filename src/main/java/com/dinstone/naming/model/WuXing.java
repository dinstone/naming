
package com.dinstone.naming.model;

public class WuXing {

    /** 金 */
    public static final WuXing JIN = new WuXing("金", 8, 7);

    /** 水 */
    public static final WuXing SHUI = new WuXing("水", 0, 9);

    /** 木 */
    public static final WuXing MU = new WuXing("木", 2, 1);

    /** 火 */
    public static final WuXing HUO = new WuXing("火", 4, 3);

    /** 土 */
    public static final WuXing TU = new WuXing("土", 6, 5);

    /** 名称 */
    private String name;

    /** 阴数 */
    private int yinShu;

    /** 阳数 */
    private int yangShu;

    private WuXing(String name, int yinShu, int yangShu) {
        this.name = name;
        this.yinShu = yinShu;
        this.yangShu = yangShu;
    }

    /**
     * Description: the name to get
     * 
     * @return the name
     * 
     * @see WuXing#name
     */
    public String getName() {
        return name;
    }

    /**
     * Description: the yinShu to get
     * 
     * @return the yinShu
     * 
     * @see WuXing#yinShu
     */
    public int getYinShu() {
        return yinShu;
    }

    /**
     * Description: the yangShu to get
     * 
     * @return the yangShu
     * 
     * @see WuXing#yangShu
     */
    public int getYangShu() {
        return yangShu;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Description:根据五行数计算五行
     * 
     * @param wuXingShu
     * 
     * @return
     */
    public static WuXing calculate(int wuXingShu) {
        WuXing wxres = null;
        int wx = wuXingShu % 10;
        switch (wx) {
        case 1:
            wxres = MU;
            break;
        case 2:
            wxres = MU;
            break;
        case 3:
            wxres = HUO;
            break;
        case 4:
            wxres = HUO;
            break;
        case 5:
            wxres = TU;
            break;
        case 6:
            wxres = TU;
            break;
        case 7:
            wxres = JIN;
            break;
        case 8:
            wxres = JIN;
            break;
        case 9:
            wxres = SHUI;
            break;
        case 0:
            wxres = SHUI;
            break;
        default:
            break;
        }
        return wxres;
    }

    /**
     * Description: 根据五行名称计算五行
     * 
     * @param wuXingName
     * 
     * @return
     */
    public static WuXing calculate(String wuXingName) {
        wuXingName = wuXingName.trim();
        if (wuXingName == null || wuXingName.length() == 0) {
            return null;
        }

        WuXing wxres = null;
        if ("金".equals(wuXingName)) {
            wxres = JIN;
        } else if ("水".equals(wuXingName)) {
            wxres = SHUI;
        } else if ("木".equals(wuXingName)) {
            wxres = MU;
        } else if ("火".equals(wuXingName)) {
            wxres = HUO;
        } else if ("土".equals(wuXingName)) {
            wxres = TU;
        }
        return wxres;
    }

}
