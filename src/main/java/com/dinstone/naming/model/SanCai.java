
package com.dinstone.naming.model;

public class SanCai {

    /** 天才 */
    private WuXing tianCai;

    /** 人才 */
    private WuXing renCai;

    /** 地才 */
    private WuXing diCai;

    /** 三才配置级别 */
    private int level;

    /** 三才配置描述 */
    private String desc;

    public SanCai(WuXing tianCai, WuXing renCai, WuXing diCai, int level, String desc) {
        this.tianCai = tianCai;
        this.renCai = renCai;
        this.diCai = diCai;
        this.level = level;
        this.desc = desc;
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

    /**
     * Description: the level to get
     * 
     * @return the level
     * @see SanCai#level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Description: the desc to get
     * 
     * @return the desc
     * @see SanCai#desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "三才配置 [" + tianCai.getName() + ", " + renCai.getName() + ", " + diCai.getName() + ", " + desc + "]";
    }

}
