package ng.bayue.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ng.bayue.constants.CharsetConstant;
import ng.bayue.util.StringUtils;

public class OnlineReader {

	// private static final String CHARSET = CharsetConstant.GBK;
	private static final String CHARSET = CharsetConstant.UTF8;

	public static enum WebSiteEnum {
		BIQUGE("biquge"), XXBIQUGE("xxbiquge");

		public String code;

		private WebSiteEnum(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}

	public static void read(String url) {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url);
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			HttpEntity entityParams = new UrlEncodedFormEntity(parameters, CHARSET);
			post.setEntity(entityParams);
			post.setHeader("Content-Type", "text/html;charset=UTF-8");
			HttpResponse response = client.execute(post);
			HttpEntity resEntity = response.getEntity();
			InputStream is = resEntity.getContent();

			// String content = EntityUtils.toString(resEntity);
			// System.out.println(content);

			StringBuilder resultData = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, CHARSET));
			String line = null;
			String nextPage = "";
			while (null != (line = br.readLine())) {
				resultData.append(line).append("//r//n");
				System.out.println(line);
				if (line.startsWith("var next_page = \"/1_1680/")) {
					nextPage = line.substring(25, line.lastIndexOf("."));
				}
				if (StringUtils.isNotBlank(nextPage)) {
					if (line.startsWith("var nextpage")) {
						nextPage = line.substring(24, line.lastIndexOf("."));
					}
				}
				if (line.startsWith("<h1>第")) {
					System.out.println(line);
				}
				if (line.startsWith("<div id=\"content\"")) {
					String t = line.replaceAll("<br /><br />", "\r\n");
					System.out.println(t);
					System.out.println("nextPage:" + nextPage);
					break;
				}
			}

			/*
			 * String regex =
			 * "<div id=\"content\" class=\"showtxt\">.*?<div class=\"page_chapter\">"
			 * ; Pattern pattern = Pattern.compile(regex); String str =
			 * resultData.toString(); Matcher matcher = pattern.matcher(str);
			 * while(matcher.find()){ String r = matcher.group();
			 * System.out.println(r); }
			 */

			// System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void read1(WebSiteEnum website, String url) {
		try {
			URL sourceLink = new URL(url);
			Document html = Jsoup.parse(sourceLink, 5000);
			Element h1 = html.getElementsByTag("h1").get(0);
			String title = h1.text();
			System.out.println(title);
			Element contentDiv = html.getElementById("content");
			String contentStr = contentDiv.html();
			// System.out.println(contentStr);
			// contentStr =
			// contentStr.replaceAll("<br>&nbsp;&nbsp;&nbsp;&nbsp;",
			// "").replaceAll("\n<br>", "");
			// contentStr = contentStr.replaceAll("<br> \n<br>
			// &nbsp;&nbsp;&nbsp;&nbsp;", "");
			contentStr = contentStr.replaceAll("<br>[ \t]?+\n<br>", "").replaceAll("&nbsp;", "");
			BufferedReader br = new BufferedReader(new StringReader(contentStr));
			String ctx = "";
			StringBuilder sb = new StringBuilder();
			while (null != (ctx = br.readLine())) {
				int len = ctx.length();
				// if (len > 100) {
				// String t = ctx.substring(100);
				// ctx = ctx.substring(0, 100) + "\n" + t;
				// }
				int l = len / 110;
				if (len > 110) {
					StringBuilder st = new StringBuilder(ctx);
					for (int j = 1; j <= l; j++) {
						st.insert(110 * j, "\n");
					}
					sb.append(st).append("\n");
				} else {
					sb.append(ctx).append("\n");
				}

			}
			System.out.println(sb.toString());

			String line = "";

			Elements js = html.getElementsByTag("script");// ("var nextpage=")
															// var next_page = ;
			// String[] nextPageStrs = new String[]{"var[ \\s]+?nextpage[
			// \\s]?+=", "var[ \\s]+?next_page[ \\s]?+="};
			Element eNextPage = null;
			if (WebSiteEnum.XXBIQUGE == website) {
				eNextPage = js.last();
				br = new BufferedReader(new StringReader(eNextPage.html()));
				while (null != (line = br.readLine())) {
					if (line.startsWith("var nextpage=")) {
						line = line.substring(line.lastIndexOf("/") + 1, line.lastIndexOf("."));
						// line = line.substring(14, line.lastIndexOf("."));
						break;
					}
				}
				System.out.println("nextPage:" + line);
				br.close();
			} else {
				String nextPageStrLine = "";
				for (Element e : js) {
					String eHtml = e.html();
					// String eOuterHtml = e.outerHtml();
					if (StringUtils.isBlank(eHtml)) {
						continue;
					}
					String[] eHtmlTexts = eHtml.split(";");
					for (String t : eHtmlTexts) {
						if (t.startsWith("var next_page")) {
							nextPageStrLine = t;
							break;
						}
					}
				}
				String nextPage = "";
				if (StringUtils.isNotBlank(nextPageStrLine)) {
					// var next_page = "/8_8568/9172461.html"
					nextPage = nextPageStrLine.substring(nextPageStrLine.lastIndexOf("/") + 1,
							nextPageStrLine.lastIndexOf("."));
				}
				System.out.println("nextPage:" + nextPage);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// final String url = "http://www.biqukan.com/1_1680/18577593.html";

		final String url = "http://www.biquge.com.tw/8_8568/9245011.html";
		read1(WebSiteEnum.BIQUGE, url);

		// final String url = "https://www.xxbiquge.com/76_76060/120394.html";
		// read1(WebSiteEnum.XXBIQUGE, url);

	}

}
