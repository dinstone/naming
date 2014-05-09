
package com.dinstone.qm.model;

public class SanCai {

    /** 天才 */
    private WuXing tianCai;

    /** 人才 */
    private WuXing renCai;

    /** 地才 */
    private WuXing diCai;

    private SanCai(WuXing tianCai, WuXing renCai, WuXing diCai) {
        this.tianCai = tianCai;
        this.renCai = renCai;
        this.diCai = diCai;
    }

    /**
     * Description: the tianCai to get
     * 
     * @return the tianCai
     * @see SanCai#tianCai
     */
    public WuXing getTianCai() {
        return tianCai;
    }

    /**
     * Description: the renCai to get
     * 
     * @return the renCai
     * @see SanCai#renCai
     */
    public WuXing getRenCai() {
        return renCai;
    }

    /**
     * Description: the diCai to get
     * 
     * @return the diCai
     * @see SanCai#diCai
     */
    public WuXing getDiCai() {
        return diCai;
    }

}
