
package com.dinstone.naming.service;

import java.util.List;

import com.dinstone.naming.model.Word;
import com.dinstone.naming.model.Xing;
import com.dinstone.naming.model.XingMing;
import com.dinstone.naming.service.Config;
import com.dinstone.naming.service.Dictionary;
import com.dinstone.naming.service.NamingService;

public class NamingServiceTest {

    private NamingService qmService;

    public static void main(String[] args) {
        NamingServiceTest t = new NamingServiceTest();
        t.namingGuo("郭");
    }

    public NamingServiceTest() {
        Config config = new Config();
        config.setMaxX(30);
        config.setMaxY(30);
        qmService = new NamingService(config);
    }

    /**
     * "郭"测算
     * 
     * @param xing
     */
    public final void namingGuo(String xing) {
        Xing xs = findXing(xing);

        List<XingMing> res = qmService.findXingMing(xs);
        System.out.println(xs + "所有可能的组合:");
        showResult(res);

        System.out.println("==============================================");

        System.out.println("筛选过的的组合:");
        res = qmService.selectBestWuGeXingMing(res);
        showResult(res);
    }

    private Xing findXing(String xing) {
        Word[] ws = new Word[xing.length()];
        for (int i = 0; i < ws.length; i++) {
            ws[i] = Dictionary.find(String.valueOf(xing.charAt(i)));
        }
        return new Xing(ws);
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
