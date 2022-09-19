
package com.dinstone.naming.model;

public class ShuLi {

    /** 五格数 */
    private int wuGeShu;

    /** 级别 */
    private int level;

    /** 五格数暗示 */
    private String desc;

    public ShuLi(int wuGeShu, int level, String desc) {
        this.wuGeShu = wuGeShu;
        this.level = level;
        this.desc = desc;
    }

    /**
     * Description: the wuGeShu to get
     * 
     * @return the wuGeShu
     * @see ShuLi#wuGeShu
     */
    public int getWuGeShu() {
        return wuGeShu;
    }

    /**
     * Description: the wuGeShu to set
     * 
     * @param wuGeShu
     * @see ShuLi#wuGeShu
     */
    public void setWuGeShu(int wuGeShu) {
        this.wuGeShu = wuGeShu;
    }

    /**
     * Description: the level to get
     * 
     * @return the level
     * @see ShuLi#level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Description: the level to set
     * 
     * @param level
     * @see ShuLi#level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Description: the desc to get
     * 
     * @return the desc
     * @see ShuLi#desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Description: the desc to set
     * 
     * @param desc
     * @see ShuLi#desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

}
