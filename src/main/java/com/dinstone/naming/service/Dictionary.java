package com.dinstone.naming.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.dinstone.naming.model.Word;
import com.dinstone.naming.model.WuXing;

public class Dictionary {

    private static final Map<String, Word> wordMap = initDictionary();

    private static Map<String, Word> initDictionary() {
        Map<String, Word> wordMap = new HashMap<>();
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(cl.getResourceAsStream("kangxizidian.txt"), "utf-8"));
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                String[] ts = temp.split(",", 7);
                Word word = new Word();
                word.setJtChar(ts[0]);
                word.setFtChar(ts[1]);
                word.setPingyin(ts[2]);
                try {
                    word.setWuxing(WuXing.calculate(ts[3]));
                    word.setJtStroke(safeInt(ts[4]));
                    word.setFtStroke(safeInt(ts[5]));
                    word.setKxStroke(safeInt(ts[6]));
                } catch (Exception e) {
                    // ignore
                    System.out.println("read error : " + word);
                }
                wordMap.put(word.getJtChar(), word);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordMap;
    }

    private static int safeInt(String is) {
        try {
            if (is != null && is.length() > 0) {
                return Integer.parseInt(is);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public static Word find(String x) {
        return wordMap.get(x);
    }

}
