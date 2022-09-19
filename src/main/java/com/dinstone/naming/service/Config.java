
package com.dinstone.naming.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.dinstone.naming.model.SanCai;
import com.dinstone.naming.model.ShuLi;
import com.dinstone.naming.model.WuXing;

public class Config {

    private static final Map<Integer, ShuLi> wuGeShuLiMap = initWuGeShuLi();

    private static final List<SanCai> sanCaiPeiZhiList = initSanCaiPeizhi();

    private int maxX;

    private int maxY;

    /**
     * Description: 加载基于类路径下的属性(.properties)文件.
     * 
     * @param location
     *            基于类路径下的.properties文件位置
     * 
     * @throws IOException
     *             文件找不到或文件不可读
     * 
     * @return 属性列表
     */
    public static Properties loadProperties(String location) throws IOException {
        ClassLoader cl = getClassLoader();
        InputStream inStream = cl.getResourceAsStream(location);
        if (inStream == null) {
            throw new FileNotFoundException("类路径下找不到指定的文件:" + location);
        }

        Properties ps = new Properties();
        ps.load(inStream);
        return ps;
    }

    private static List<SanCai> initSanCaiPeizhi() {
        List<SanCai> scpzList = new ArrayList<SanCai>();
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(cl.getResourceAsStream("sancaipeizhi.txt"), "utf-8"));
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                String[] ts = temp.split("\\|", 3);
                SanCai scpz = new SanCai(findWuXing(ts[0].charAt(0)), findWuXing(ts[0].charAt(1)),
                        findWuXing(ts[0].charAt(2)), Integer.parseInt(ts[1]), ts[2]);
                scpzList.add(scpz);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scpzList;
    }

    private static WuXing findWuXing(char charAt) {
        switch (charAt) {
        case '金':
            return WuXing.JIN;
        case '木':
            return WuXing.MU;
        case '水':
            return WuXing.SHUI;
        case '火':
            return WuXing.HUO;
        case '土':
            return WuXing.TU;
        default:
            break;
        }
        return null;
    }

    /**
     * Description:
     * 
     * @return
     */
    private static Map<Integer, ShuLi> initWuGeShuLi() {
        Map<Integer, ShuLi> wgslMap = new HashMap<Integer, ShuLi>();
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(cl.getResourceAsStream("wugeshuli.txt"), "utf-8"));
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                String[] ts = temp.split("\\|", 3);
                int wgs = Integer.parseInt(ts[0]);
                String level = ts[1];
                int lvl = Integer.parseInt(ts[1]);
                if ("吉".equals(level)) {
                    lvl = 1;
                } else if ("凶".equals(level)) {
                    lvl = -1;
                }
                ShuLi wgsl = new ShuLi(wgs, lvl, ts[2]);
                wgslMap.put(wgs, wgsl);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Properties props = null;
        // try {
        // props = loadProperties("WuGeShuLi.properties");
        // } catch (IOException e) {
        // throw new RuntimeException(e);
        // }
        //
        // for (Object key : props.keySet()) {
        // String v = props.getProperty(key.toString());
        // String level = v.substring(0, 1);
        // int lvl = 0;
        // if ("吉".equals(level)) {
        // lvl = 1;
        // } else if ("凶".equals(level)) {
        // lvl = -1;
        // }
        //
        // int wgs = Integer.parseInt(key.toString());
        // ShuLi wgsl = new ShuLi(wgs, lvl, v.substring(2));
        // wgslMap.put(wgs, wgsl);
        // }

        return wgslMap;
    }

    /**
     * Description: 取得类加载器
     * 
     * @return
     */
    private static ClassLoader getClassLoader() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl == null) {
            cl = Config.class.getClassLoader();
        }
        return cl;
    }

    /**
     * Description: the wugeshulimap to get
     * 
     * @return the wugeshulimap
     * 
     * @see Config#wugeshulimap
     */
    public Map<Integer, ShuLi> getWuGeShuLiMap() {
        return wuGeShuLiMap;
    }

    /**
     * Description: the sanCaiPeiZhiList to get
     * 
     * @return the sanCaiPeiZhiList
     * 
     * @see Config#sanCaiPeiZhiList
     */
    public List<SanCai> getSanCaiPeiZhiList() {
        return sanCaiPeiZhiList;
    }

    /**
     * Description: the maxX to get
     * 
     * @return the maxX
     * 
     * @see Config#maxX
     */
    public int getMaxX() {
        return maxX;
    }

    /**
     * Description: the maxX to set
     * 
     * @param maxX
     * 
     * @see Config#maxX
     */
    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    /**
     * Description: the maxY to get
     * 
     * @return the maxY
     * 
     * @see Config#maxY
     */
    public int getMaxY() {
        return maxY;
    }

    /**
     * Description: the maxY to set
     * 
     * @param maxY
     * 
     * @see Config#maxY
     */
    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

}
