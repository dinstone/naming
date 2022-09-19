package com.dinstone.naming.service;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class KangXiDictionaryPull {

    public static void main(String[] args) throws Exception {
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("kxzd.txt", true), "utf-8"));
        try {
            for (int bihua = 1; bihua < 31; bihua++) {
                int page = 1;

                while (!extracted(bihua, page, writer)) {
                    page++;
                }
            }
        } finally {
            writer.close();
        }

    }

    private static boolean extracted(int bihua, int page, BufferedWriter writer) throws Exception {
        String referrer = "https://www.yw11.com/zidian/";
        String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36";
        String baseUrl = "https://www.yw11.com/zidian/bihua/";

        int tryCount = 1;
        while (true) {
            try {
                String url = baseUrl + bihua + "/" + page;
                Document doc = Jsoup.connect(url).referrer(referrer).userAgent(userAgent).timeout(5000).get();

                // extract parts
                Elements links = doc.select("ul.zi_list a[href]");
                if (links.isEmpty()) {
                    return true;
                }

                for (Element link : links) {
                    String href = link.attr("abs:href");
                    if (href.contains("zidian")) {
                        String wd = extractWord(href);
                        writer.write(wd);
                        writer.newLine();
                        writer.flush();

                        System.out.println(wd);
//                        Thread.sleep(100);
                    }
                }
                return false;
            } catch (Exception e) {
                tryCount++;
                if (tryCount > 3) {
                    break;
                }
            }
        }

        return true;
    }

    private static String extractWord(String href) throws Exception {
        String referrer = "https://www.yw11.com/zidian/";
        String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36";
        int tryCount = 1;
        while (true) {
            try {
                String url = href;
                Document doc = Jsoup.connect(url).referrer(referrer).userAgent(userAgent).timeout(5000).get();

                // extract parts
                Elements es = doc.select("div.info");
                for (Element e : es) {
                    Elements names = e.getElementsByClass("name");
                    if (names != null && !names.isEmpty()) {
                        String jt = names.get(0).text();
                        String ft = null;
                        String py = null;
                        String wx = null;
                        String jtbh = null;
                        String ftbh = null;
                        String kxbh = null;

                        Elements fls = e.select("div.f_l");
                        for (Element fl : fls) {
                            String type = fl.child(0).text();
                            String vale = fl.child(1).text();
                            if (type.endsWith("拼音")) {
                                // System.out.println("拼音: " + vale);
                                py = vale;
                            } else if (type.endsWith("五行")) {
                                // System.out.println("五行: " + vale);
                                wx = vale;
                            } else if (type.endsWith("繁体")) {
                                // System.out.println("繁体: " + vale);
                                ft = vale;
                            } else if (type.endsWith("简体笔画")) {
                                // System.out.println("简体笔画: " + vale);
                                jtbh = vale;
                            } else if (type.endsWith("繁体笔画")) {
                                // System.out.println("繁体笔画: " + vale);
                                ftbh = vale;
                            } else if (type.endsWith("康熙笔画")) {
                                // System.out.println("康熙笔画: " + vale);
                                kxbh = vale;
                            }
                        }

                        return jt + "," + ft + "," + py + "," + wx + "," + jtbh + "," + ftbh + "," + kxbh;
                    }
                }

                break;
            } catch (Exception e) {
                tryCount++;
                if (tryCount > 3) {
                    break;
                }
            }
        }

        return null;
    }

}
