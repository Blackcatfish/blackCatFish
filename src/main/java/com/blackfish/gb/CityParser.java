package com.blackfish.gb;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.log.StaticLog;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/**
 * *省市县解析器
 */
public class CityParser implements ICityParser {

    private static final String COMMON_URL = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/";

    private static final Charset CHARSET = CharsetUtil.CHARSET_GBK;

    public List<Node> parseProvinces(String url) {
        return parseProvince(COMMON_URL + "index.html");
    }

    private List<Node> parseProvince(String url) {

        String htmlStr = HttpUtil.get(url, CHARSET);
        Document document = Jsoup.parse(htmlStr);

        // 获取 class='provincetr' 的元素
        Elements elements = document.getElementsByClass("provincetr");
        List<Node> provinces = new LinkedList<Node>();
        for (Element element : elements) {
            // 获取 elements 下属性是 href 的元素
            Elements links = element.getElementsByAttribute("href");
            for (Element link : links) {
                String provinceName = link.text();
                String href = link.attr("href");
                String provinceCode = href.substring(0, 2);

                Node provinceNode = Node.builder().code(provinceCode).name(provinceName).dataFromUrl(url)
                        .nodes(parseCity(COMMON_URL + href)).build();

                StaticLog.info("省级数据:  {}  ", provinceNode);

                provinces.add(provinceNode);
            }
        }
        return provinces;
    }

    private List<Node> parseCity(String url) {
        String htmlStr = HttpUtil.get(url, CHARSET);
        Document document = Jsoup.parse(htmlStr);
        Elements trs = document.getElementsByClass("citytr");

        List<Node> cities = new LinkedList<Node>();
        for (Element tr : trs) {
            Elements links = tr.getElementsByTag("a");
            String href = links.get(0).attr("href");
            String cityCode = links.get(0).text().substring(0, 4);
            String cityName = links.get(1).text();

            Node cityNode = Node.builder().name(cityName).code(cityCode).dataFromUrl(url)
                    .nodes(parseCounty(COMMON_URL + href)).build();

            StaticLog.info("	市级数据:  {}  ", cityNode);

            cities.add(cityNode);
        }
        return cities;
    }

    private List<Node> parseCounty(String url) {
        String htmlStr = HttpUtil.get(url, CHARSET);
        Document document = Jsoup.parse(htmlStr);
        Elements trs = document.getElementsByClass("countytr");

        List<Node> counties = new LinkedList<Node>();
        for (Element tr : trs) {
            Elements links = tr.getElementsByTag("a");
            if (links == null || links.size() != 2) {
                continue;
            }
            String href = links.get(0).attr("href");
            String countyCode = links.get(0).text().substring(0, 6);
            String countyName = links.get(1).text();

            Node countyNode = Node.builder().code(countyCode).name(countyName).dataFromUrl(url)
                    .nodes(parseTowntr(COMMON_URL + href.subSequence(2, 5).toString() + "/" + href)).build();
            StaticLog.info("		县级数据:  {}  ", countyNode);

            counties.add(countyNode);
        }
        return counties;
    }

    public List<Node> parseTowntr(String url) {
        String htmlStr = HttpUtil.get(url, CHARSET);
        Document document = Jsoup.parse(htmlStr);
        Elements trs = document.getElementsByClass("towntr");

        List<Node> counties = new LinkedList<Node>();
        for (Element tr : trs) {
            Elements links = tr.getElementsByTag("a");
            if (links == null || links.size() != 2) {
                continue;
            }
            String href = links.get(0).attr("href");
            String towntrCode = links.get(0).text().substring(0, 6);
            String towntrName = links.get(1).text();

            Node towntrNode = Node.builder().name(towntrName).code(towntrCode).dataFromUrl(url)
                    .nodes(parseVillagetr(
                            COMMON_URL + href.subSequence(2, 5).toString() + "/" + href.substring(5, 7) + "/" + href))
                    .build();

            StaticLog.info("			乡镇级数据:  {}  ", towntrNode);

            counties.add(towntrNode);
        }
        return counties;
    }

    public List<Node> parseVillagetr(String url) {
        String htmlStr = HttpUtil.get(url, CHARSET);
        Document document = Jsoup.parse(htmlStr);
        Elements trs = document.getElementsByClass("villagetr");

        List<Node> counties = new LinkedList<Node>();
        for (Element tr : trs) {
            Elements tds = tr.getElementsByTag("td");
            if (tds == null || tds.size() != 3) {
                continue;
            }
            String villagetrCode = tds.get(0).text();
            String villagetrName = tds.get(2).text();

            Node villagetrNode = Node.builder().code(villagetrCode).name(villagetrName).dataFromUrl(url).build();
            StaticLog.info("				村级数据:  {}  ", villagetrNode);

            counties.add(villagetrNode);
        }
        return counties;
    }

}