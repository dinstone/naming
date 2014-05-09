
package com.dinstone.qm.model;

public class WuGeShuLi {

    /** 五格数 */
    private int wuGeShu;

    /** 级别 */
    private int level;

    /** 五格数暗示 */
    private String desc;

    public WuGeShuLi(int wuGeShu, int level, String desc) {
        this.wuGeShu = wuGeShu;
        this.level = level;
        this.desc = desc;
    }

    /**
     * Description: the wuGeShu to get
     * 
     * @return the wuGeShu
     * @see WuGeShuLi#wuGeShu
     */
    public int getWuGeShu() {
        return wuGeShu;
    }

    /**
     * Description: the wuGeShu to set
     * 
     * @param wuGeShu
     * @see WuGeShuLi#wuGeShu
     */
    public void setWuGeShu(int wuGeShu) {
        this.wuGeShu = wuGeShu;
    }

    /**
     * Description: the level to get
     * 
     * @return the level
     * @see WuGeShuLi#level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Description: the level to set
     * 
     * @param level
     * @see WuGeShuLi#level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Description: the desc to get
     * 
     * @return the desc
     * @see WuGeShuLi#desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Description: the desc to set
     * 
     * @param desc
     * @see WuGeShuLi#desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

}
