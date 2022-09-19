
package com.dinstone.naming.model;

public class Word {

    /** 简体汉字 */
    private String jtChar;

    /** 简体字笔画 */
    private int jtStroke;

    /** 繁体汉字 */
    private String ftChar;

    /** 繁体字笔画 */
    private int ftStroke;

    /** 康熙字笔画 */
    private int kxStroke;

    /** 汉字拼音 */
    private String pingyin;

    /** 字属性 */
    private WuXing wuxing;

    public Word() {
        super();
    }

    public Word(String cnChar, int kxStroke) {
        this(cnChar, kxStroke, null);
    }

    public Word(String cnChar, int kxStroke, WuXing wuXing) {
        this.jtChar = cnChar;
        this.kxStroke = kxStroke;
        this.wuxing = wuXing;
    }

    public String getJtChar() {
        return jtChar;
    }

    public void setJtChar(String jtChar) {
        this.jtChar = jtChar;
    }

    public int getJtStroke() {
        return jtStroke;
    }

    public void setJtStroke(int jtStroke) {
        this.jtStroke = jtStroke;
    }

    public String getFtChar() {
        return ftChar;
    }

    public void setFtChar(String ftChar) {
        this.ftChar = ftChar;
    }

    public int getFtStroke() {
        return ftStroke;
    }

    public void setFtStroke(int ftStroke) {
        this.ftStroke = ftStroke;
    }

    public int getKxStroke() {
        return kxStroke;
    }

    public void setKxStroke(int kxStroke) {
        this.kxStroke = kxStroke;
    }

    public String getPingyin() {
        return pingyin;
    }

    public void setPingyin(String pingyin) {
        this.pingyin = pingyin;
    }

    public WuXing getWuxing() {
        return wuxing;
    }

    public void setWuxing(WuXing wuxing) {
        this.wuxing = wuxing;
    }

    @Override
    public String toString() {
        return jtChar + "(" + pingyin + ")[笔画=" + kxStroke + ", 五行=" + wuxing + "]";
    }

}
