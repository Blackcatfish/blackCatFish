package com.blackfish.gb;
 
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
 
/**
 * * 省市区区划地址解析
 * 
 * @author zhang.xiaoming
 */
public class CityStats {
 
	private static final String COMMON_URL = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/";
 
	private static final Charset CHARSET = CharsetUtil.CHARSET_GBK;
 
	private CityStats() {
	}
 
	public static void parseProvince(String url) {
 
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
 
				StaticLog.info("provinceName: {} , provinceCode: {} .", provinceName, provinceCode);
 
				Node provinceNode = Node.builder().code(provinceCode).name(provinceName).dataFromUrl(url).build();
 
				StaticLog.info("省级数据:  {}  ", provinceNode);
 
				parseCity(COMMON_URL + href, provinceNode);
				provinces.add(provinceNode);
			}
		}
		StaticLog.info(JSONUtil.toJsonPrettyStr(provinces));
	}
 
	public static void parseCity(String url, Node provinceNode) {
		String htmlStr = HttpUtil.get(url, CHARSET);
		Document document = Jsoup.parse(htmlStr);
		Elements trs = document.getElementsByClass("citytr");
		List<Node> cities = new LinkedList<Node>();
		for (Element tr : trs) {
			Elements links = tr.getElementsByTag("a");
			String href = links.get(0).attr("href");
			String cityCode = links.get(0).text().substring(0, 4);
			String cityName = links.get(1).text();
 
			Node cityNode = Node.builder().name(cityName).code(cityCode).dataFromUrl(url).build();
 
			StaticLog.info("	市级数据:  {}  ", cityNode);
 
			parseCounty(COMMON_URL + href, cityNode);
			cities.add(cityNode);
		}
		provinceNode.setNodes(cities);
	}
 
	public static void parseCounty(String url, Node cityNode) {
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
 
			Node countyNode = Node.builder().name(countyName).code(countyCode).dataFromUrl(url).build();
 
			StaticLog.info("		县级数据:  {}  ", countyNode);
 
			parseTowntr(COMMON_URL + href.subSequence(2, 5).toString() + "/" + href, countyNode);
			counties.add(cityNode);
		}
		cityNode.setNodes(counties);
	}
 
	public static void parseTowntr(String url, Node countyNode) {
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
			String towntrCode = links.get(0).text().substring(0, 9);
			String towntrName = links.get(1).text();
 
			Node towntrNode = Node.builder().name(towntrName).code(towntrCode).dataFromUrl(url).build();
 
			StaticLog.info("		乡镇级数据:  {}  ", towntrNode);
 
			parseVillagetr(COMMON_URL + href.subSequence(2, 5).toString() + "/" + href.substring(5, 7) + "/" + href,
					countyNode);
 
			counties.add(towntrNode);
		}
		countyNode.setNodes(counties);
	}
 
	public static void parseVillagetr(String url, Node countyNode) {
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
			StaticLog.info("		村级数据:  {}  ", villagetrNode);
 
			counties.add(villagetrNode);
 
		}
		countyNode.setNodes(counties);
	}
 
	public static void main(String[] args) {
		/**
		 * # 查看省份数据 http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/index.html
		 * 
		 * # 查看 内蒙古 市级数据 http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/15.html
		 * 
		 * # 查看 内蒙古 区级数据
		 * http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/15/1509.html
		 * 
		 * # 查看 内蒙古 街道级数据
		 * http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/15/09/150902.html
		 * 
		 * # 查看 内蒙古 社区居委会级数据
		 * http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/15/09/02/150902003.html
		 *
		 * *我们发现这个是有规律的，15是内蒙古的区划代码，而1509是乌兰察布市的区划代码，
		 * *前面的http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/这一大串都是一样的，我们就叫commonUrl。
		 * *规律就是：
		 *
		 * # 获取省的数据 commonUrl + index.html
		 * 
		 * # 获取市级数据 commonUrl + 对应省级区划代码.html
		 * 
		 * # 获取县区级数据 commonUrl + 对应省级区划代码 + / + 对应市级区划代码.html
		 */
 
		String provinceUrl = COMMON_URL + "index.html";
		CityStats.parseProvince(provinceUrl);
 
		String cityUrl = COMMON_URL + "15.html";
		CityStats.parseCity(cityUrl, new Node());
 
		String countyUrl = COMMON_URL + "15/1509.html";
		CityStats.parseCounty(countyUrl, new Node());
 
		String towntrUrl = COMMON_URL + "15/09/150981.html";
		CityStats.parseTowntr(towntrUrl, new Node());
	}
}