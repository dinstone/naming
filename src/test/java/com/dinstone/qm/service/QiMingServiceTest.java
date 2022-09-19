
package com.dinstone.qm.service;

import java.util.List;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dinstone.qm.model.ShuLi;
import com.dinstone.qm.model.Word;
import com.dinstone.qm.model.WuXing;
import com.dinstone.qm.model.XingMing;

public class QiMingServiceTest {

    private static QiMingService qmService;

    /**
     * Description:
     * 
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Config config = new Config();
        config.setMaxX(30);
        config.setMaxY(30);

        for (Entry<Integer, ShuLi> e : config.getWuGeShuLiMap().entrySet()) {
            System.out.println(e.getKey() + "|" + e.getValue().getLevel() + "|" + e.getValue().getDesc());
        }

        System.out.println("--------------------------------------------------------");

        qmService = new QiMingService(config);
    }

    /**
     * Test method for {@link com.dinstone.qm.service.QiMingService#findXingMing(java.lang.String)} .
     */
    @Test
    public final void testFindXingMing00() {
        try {
            qmService.findXingMing(null);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof IllegalArgumentException);
            return;
        }

        Assert.fail();
    }

    /**
     * "郭"测算
     */
    @Test
    public final void testFindXingMing01() {
        Word[] ws = new Word[] { new Word("郭", 15, WuXing.MU) };
        List<XingMing> res = qmService.findXingMing(ws);
        System.out.println("所有可能的组合:");
        showResult(res);

        System.out.println("==============================================");

        System.out.println("筛选过的的组合:");
        res = qmService.selectBestWuGeXingMing(res);
        showResult(res);
    }

    /**
     * "张"测算
     */
    @Test
    public final void testFindXingMing02() {
        Word[] ws = new Word[] { new Word("张", 11, WuXing.HUO) };
        List<XingMing> res = qmService.findXingMing(ws);
        System.out.println("所有可能的组合:");
        showResult(res);

        System.out.println("==============================================");

        System.out.println("筛选过的的组合:");
        res = qmService.selectBestWuGeXingMing(res);
        showResult(res);
    }

    /**
     * "杨"测算
     */
    @Test
    public final void testFindXingMing03() {
        Word[] ws = new Word[] { new Word("杨", 13, WuXing.MU) };
        List<XingMing> res = qmService.findXingMing(ws);
        System.out.println("所有可能的组合:");
        showResult(res);

        System.out.println("==============================================");

        System.out.println("筛选过的的组合:");
        res = qmService.selectBestWuGeXingMing(res);
        showResult(res);
    }

    /**
     * "高"测算
     */
    @Test
    public final void testFindXingMing04() {
        Word[] ws = new Word[] { new Word("高", 10, WuXing.MU) };
        List<XingMing> res = qmService.findXingMing(ws);
        System.out.println("所有可能的组合:");
        showResult(res);

        System.out.println("==============================================");

        System.out.println("筛选过的的组合:");
        res = qmService.selectBestWuGeXingMing(res);
        showResult(res);
    }

    /**
     * "原"测算
     */
    @Test
    public final void testFindXingMing05() {
        Word[] ws = new Word[] { new Word("原", 10, WuXing.MU) };
        List<XingMing> res = qmService.findXingMing(ws);
        System.out.println("所有可能的组合:");
        showResult(res);

        System.out.println("==============================================");

        System.out.println("筛选过的的组合:");
        res = qmService.selectBestWuGeXingMing(res);
        showResult(res);
    }

    /**
     * "万"测算
     */
    @Test
    public final void testFindXingMing06() {
        Word[] ws = new Word[] { new Word("万", 15, WuXing.SHUI) };
        List<XingMing> res = qmService.findXingMing(ws);
        System.out.println("所有可能的组合:");
        showResult(res);

        System.out.println("==============================================");

        System.out.println("筛选过的的组合:");
        res = qmService.selectBestWuGeXingMing(res);
        showResult(res);
    }

    private void showResult(List<XingMing> res) {
        for (XingMing xingMing : res) {
            StringBuilder sb = new StringBuilder();
            Word[] xs = xingMing.getXingShi().getXing();
            for (Word word : xs) {
                sb.append(word.getJtChar());
                sb.append("(" + word.getKxStroke() + ")");
            }
            sb.append("\t");
            Word m = xingMing.getMing()[0];
            sb.append(m.getJtChar());
            sb.append("(" + m.getKxStroke() + ")");

            sb.append("\t");
            m = xingMing.getMing()[1];
            sb.append(m.getJtChar());
            sb.append("(" + m.getKxStroke() + ")");

            sb.append("\t " + xingMing.getSanCaiPeiZhi());

            System.out.println(sb.toString());
        }
    }

}
