
package com.dinstone.qm.model;

public class Word {

    /** 中文汉字 */
    private String cnChar;

    /** 康熙字笔画 */
    private int kxStroke;

    /** 字属性 */
    private WuXing attribute;

    public Word(String cnChar, int kxStroke, WuXing attribute) {
        this.cnChar = cnChar;
        this.kxStroke = kxStroke;
        this.attribute = attribute;
    }

    /**
     * Description: the cnChar to get
     * 
     * @return the cnChar
     * @see Word#cnChar
     */
    public String getCnChar() {
        return cnChar;
    }

    /**
     * Description: the cnChar to set
     * 
     * @param cnChar
     * @see Word#cnChar
     */
    public void setCnChar(String cnChar) {
        this.cnChar = cnChar;
    }

    /**
     * Description: the kxStroke to get
     * 
     * @return the kxStroke
     * @see Word#kxStroke
     */
    public int getKxStroke() {
        return kxStroke;
    }

    /**
     * Description: the kxStroke to set
     * 
     * @param kxStroke
     * @see Word#kxStroke
     */
    public void setKxStroke(int kxStroke) {
        this.kxStroke = kxStroke;
    }

    /**
     * Description: the attribute to get
     * 
     * @return the attribute
     * @see Word#attribute
     */
    public WuXing getAttribute() {
        return attribute;
    }

    /**
     * Description: the attribute to set
     * 
     * @param attribute
     * @see Word#attribute
     */
    public void setAttribute(WuXing attribute) {
        this.attribute = attribute;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return cnChar + "(" + kxStroke + "," + attribute + ")";
    }

}
