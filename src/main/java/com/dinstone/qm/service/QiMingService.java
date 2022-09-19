
package com.dinstone.qm.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.dinstone.qm.model.SanCai;
import com.dinstone.qm.model.ShuLi;
import com.dinstone.qm.model.Word;
import com.dinstone.qm.model.WuGe;
import com.dinstone.qm.model.WuXing;
import com.dinstone.qm.model.Xing;
import com.dinstone.qm.model.XingMing;

public class QiMingService {

    private Config config;

    public QiMingService(Config config) {
        this.config = config;
    }

    /**
     * Description:由姓氏查找姓名
     * 
     * @param xings
     * 
     * @return
     */
    public List<XingMing> findXingMing(Word[] xings) {
        List<XingMing> xmList = new LinkedList<XingMing>();

        // 计算姓氏的天格和五行属性
        Xing xingShi = new Xing(xings);

        // 根据天格五行属性查找最佳三才配置
        List<SanCai> sanCaiPeiZhis = findBestSanCaiPeiZhi(xingShi);
        // 遍历最佳三才配置，寻找最佳五格数理，推算名字笔画
        for (SanCai sanCaiPeiZhi : sanCaiPeiZhis) {
            xmList.addAll(findXingMing(xingShi, sanCaiPeiZhi));
        }

        return xmList;
    }

    /**
     * Description:
     * 
     * @param xmList
     * 
     * @return
     */
    public List<XingMing> selectBestWuGeXingMing(List<XingMing> xmList) {
        List<XingMing> bxmList = new LinkedList<XingMing>();
        Map<Integer, ShuLi> wgslm = config.getWuGeShuLiMap();
        for (XingMing xingMing : xmList) {
            int c = 0;
            ShuLi wgsl = wgslm.get(xingMing.getTianGeShu());
            // c += wgsl.getLevel();

            wgsl = wgslm.get(xingMing.getRenGeShu());
            c += wgsl.getLevel();

            wgsl = wgslm.get(xingMing.getDiGeShu());
            c += wgsl.getLevel();

            wgsl = wgslm.get(xingMing.getZongGeShu());
            c += wgsl.getLevel();

            wgsl = wgslm.get(xingMing.getWaiGeShu());
            c += wgsl.getLevel();

            if (c > 3) {
                bxmList.add(xingMing);
            }
        }
        return bxmList;
    }

    /**
     * Description: 由姓氏、和三才配置来查找姓名
     * 
     * @param xingShi
     * @param renGes
     * @param diGes
     * 
     * @return
     */
    private List<XingMing> findXingMing(Xing xingShi, SanCai sanCaiPeiZhi) {
        // 由人才计算最佳人格：人格%10=人才
        WuXing renCai = sanCaiPeiZhi.getRenCai();
        List<WuGe> renGes = findBestWuGe(renCai);

        WuXing diCai = sanCaiPeiZhi.getDiCai();
        // 由地才计算最佳地格：地格%10=地才
        List<WuGe> diGes = findBestWuGe(diCai);

        List<XingMing> xmList = new LinkedList<XingMing>();
        int maxx = config.getMaxX();
        for (WuGe renGe : renGes) {
            // 名字第一个字的笔画
            int x = getMingZiKxStroke(xingShi, renGe);
            if (x < 1 || x > maxx) {
                continue;
            }

            List<WuGe> bestDiGes = selectDiGe(diGes, x);
            int maxy = config.getMaxY();
            for (WuGe diGe : bestDiGes) {
                int y = diGe.getWuGeShu() - x;
                if (y < 1 || y > maxy) {
                    continue;
                }
                Word[] mingzi = new Word[] { new Word("X", x, renGe.getWuXing()), new Word("Y", y, diGe.getWuXing()) };
                XingMing xm = new XingMing(xingShi, mingzi, sanCaiPeiZhi);
                xmList.add(xm);
            }
        }
        return xmList;
    }

    /**
     * Description: 筛选满足条件的地格
     * 
     * @param diGes
     * @param x
     * 
     * @return
     */
    private List<WuGe> selectDiGe(List<WuGe> diGes, int x) {
        List<WuGe> dgl = new ArrayList<WuGe>();
        for (WuGe diGe : diGes) {
            int diGeShu = diGe.getWuGeShu();
            int y = diGeShu - x;
            if (y > 0) {
                dgl.add(diGe);
            }
        }
        return dgl;
    }

    /**
     * Description: 计算与人格相关的名的笔画
     * 
     * @param xingShi
     * @param renGe
     * 
     * @return
     */
    private int getMingZiKxStroke(Xing xingShi, WuGe renGe) {
        Word[] xs = xingShi.getXing();
        if (xs.length == 1) {
            return renGe.getWuGeShu() - xs[0].getKxStroke();
        }
        return renGe.getWuGeShu() - xingShi.getXing()[1].getKxStroke();
    }

    /**
     * Description:计算最佳三格：三格%10=三才
     * 
     * @param sanCai
     * 
     * @return 三格
     */
    private List<WuGe> findBestWuGe(WuXing sanCai) {
        List<WuGe> wgList = new ArrayList<WuGe>();

        int yangShu = sanCai.getYangShu();
        for (int i = 0; i < 9; i++) {
            int sg1 = i * 10 + yangShu;
            if (sg1 < 82) {
                wgList.add(new WuGe(sg1));
            } else {
                break;
            }
        }

        int yinShu = sanCai.getYinShu();
        for (int j = 0; j < 9; j++) {
            int sg = j * 10 + yinShu;
            if (sg < 82) {
                wgList.add(new WuGe(sg));
            } else {
                break;
            }
        }

        return wgList;
    }

    /**
     * Description: 根据天格五行属性查找最佳三才配置
     * 
     * @param xingShi
     *            天格
     * 
     * @return
     */
    private List<SanCai> findBestSanCaiPeiZhi(Xing xingShi) {
        WuXing tianCai = xingShi.getTianGe().getWuXing();
        List<SanCai> sanCaiPeiZhis = new ArrayList<SanCai>();
        List<SanCai> scpzList = config.getSanCaiPeiZhiList();
        for (SanCai sanCaiPeiZhi : scpzList) {
            if (tianCai.equals(sanCaiPeiZhi.getTianCai()) && sanCaiPeiZhi.getLevel() > 0) {
                sanCaiPeiZhis.add(sanCaiPeiZhi);
            }
        }

        return sanCaiPeiZhis;
    }
}
