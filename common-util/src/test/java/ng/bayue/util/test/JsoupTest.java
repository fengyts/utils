package ng.bayue.util.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {

	private static final int CONNECTION_TIME_OUT = 5000; // 网络超时时间，单位：毫秒
	private static final String basicUri = "https://www.yooread.com";
	private static final String basicDir = "E:/test/huamulan/";
	private static final File bookSerializeFile = new File("E:/test/huamulan/serialize.properties"); // 系列小说序列号文件

	public static void test() {
		try {
			// 获取所有小说链接
			String[] pages = new String[] { "/tags/3/index.html", "/tags/3/index_2.html", "/tags/3/index_3.html",
					"/tags/3/index_4.html" }; // 分页，共有4页
			URL url = null;
			Document document = null;
			Elements items = new Elements(); // 小说集合
			for (String page : pages) {
				url = new URL(basicUri + page);
				document = Jsoup.parse(url, CONNECTION_TIME_OUT);
				items.addAll(document.getElementsByClass("item"));
			}

			// System.out.println(items.size());

			getChapter(items); // 获取章节列表

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getChapter(Elements items) throws Exception {
		URL url = null;
		Document document = null;
		Element item = null;
		String bookTitle = "";
		String bookHref = "";
		Elements zjList = null; // 章节列表
		// SortedMap<String, Object> sortZJ = null;
		int i = 0;
		for (Element book : items) {
			// sortZJ = new TreeMap<String, Object>();

			item = book.getElementsByTag("h4").get(0);
			item = item.getElementsByTag("a").get(0);

			bookHref = item.attr("href");
			bookTitle = item.text();
			if (exists(bookTitle)) { // 已经抓取
				continue;
			}

			// 获取小说章节链接
			url = new URL(basicUri + bookHref);
			document = Jsoup.parse(url, CONNECTION_TIME_OUT);

			zjList = document.getElementById("chapterList").getElementsByTag("li");
			System.out.println(bookTitle + " ：" + bookHref + " 章节数：" + zjList.size());

			// writeSerializeFile(bookTitle, bookHref);
			getContent(bookTitle, bookHref, zjList, i); // 获取章节内容
		}
	}

	private static void getContent(String bookTitle, String bookHref, Elements zjList, int i) throws Exception {
		SortedMap<String, Object> sortZJ = new TreeMap<String, Object>();
		Elements zjA = null;
		Element zj = null;
		String zjHref = "";
		String zjTitle = "";
		for (Element zjItem : zjList) {
			zjA = zjItem.getElementsByTag("a");
			if (zjA != null && zjA.size() != 0) {
				zj = zjA.get(0);
				zjHref = zj.attr("href");
				zjTitle = zj.text();
				if (!sortZJ.containsKey(zjHref) || !sortZJ.containsValue(zjTitle)) {
					sortZJ.put(zjHref, zjTitle);
				}
			}
		}

//		writeContent(bookTitle, bookHref, sortZJ, false);
//		if (i++ % 2 == 0) { // 防止爬虫
//			Random r = new Random();
//			int nextInt = r.nextInt(6);
//			Thread.sleep(nextInt * 1000);
//		}
	}

	private static void writeSerializeFile(String bookTitle, String bookHref) throws Exception {
		BufferedWriter bw = null;
		if (!bookSerializeFile.exists()) {
			bookSerializeFile.createNewFile();
			bw = new BufferedWriter(new FileWriter(bookSerializeFile, true));
			bw.append("##女黑侠木兰花系列小说系列号");
			bw.newLine();
		}
		try {
			if (null == bw) {
				bw = new BufferedWriter(new FileWriter(bookSerializeFile, true));
			}
			// String[] bookHrefTemp = bookHref.split("/");
			// String serializeNo = bookHrefTemp[bookHrefTemp.length - 1];
			String serializeNo = getSerializeNo(bookHref);
			bw.append(bookTitle).append("=").append(serializeNo);
			bw.newLine();
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != bw) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String getSerializeNo(String bookHref) {
		String[] bookHrefTemp = bookHref.split("/");
		String serializeNo = bookHrefTemp[bookHrefTemp.length - 1];
		return serializeNo;
	}

	private static void writeContent(String bookTitle, String bookHref, SortedMap<String, Object> chapter,
			boolean isMerge) {
		BufferedWriter bw = null;
		try {
			String serializeNo = getSerializeNo(bookHref);
			int serializeNum = Integer.valueOf(serializeNo) - 59;
			File file = new File(basicDir + serializeNum + "-" + bookTitle + ".txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			bw = new BufferedWriter(new FileWriter(file));
			bw.append(bookTitle).append("\n\r\r\n\r\n");
			String zjHref = "", zjTitle = "";
			URL url = null;
			Document document = null;
			for (Map.Entry<String, Object> entry : chapter.entrySet()) {
				zjHref = entry.getKey();
				zjTitle = (String) entry.getValue();
				bw.append(zjTitle).append("\r\n\r\n");
				url = new URL(basicUri + zjHref);
				document = Jsoup.parse(url, CONNECTION_TIME_OUT);
				Element mainContent = document.getElementById("TextContent");
				// Elements contents = mainContent.getElementsByTag("p");

				Elements contents = mainContent.getElementsByIndexGreaterThan(3);
				contents.remove(contents.size() - 1);

				for (Element p : contents) {
					bw.append(p.text()).append("\r\n");
				}
				bw.newLine();
				bw.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != bw) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static boolean exists(String bookTitle) {
		File f = new File(basicDir + bookTitle + ".txt");
		if (f.exists()) {
			return true;
		}
		return false;
	}

	private static void renameFile(String filePath) throws Exception {
		File file = new File(filePath);
		BookFileFilter filter = new BookFileFilter();
		File[] listFiles = file.listFiles(filter);

		Properties properties = new Properties();
		properties.load(new BufferedReader(new FileReader(bookSerializeFile)));

		String fileNameAll = "";
		String fileName = "";
		String serializeNo = "";
		int serializeNum;
		for (File f : listFiles) {
			fileNameAll = f.getName();
			fileName = fileNameAll.endsWith(".txt") ? fileNameAll.substring(0, fileNameAll.lastIndexOf("."))
					: fileNameAll;
			serializeNo = properties.getProperty(fileName);
			if (StringUtils.isNumeric(serializeNo)) {
				serializeNum = Integer.valueOf(serializeNo) - 59;
				f.renameTo(new File(basicDir + serializeNum + "-" + fileNameAll));
			}
		}
	}

	static class BookFileFilter implements FileFilter {
		@Override
		public boolean accept(File f) {
			String fileName = f.getName();
			return fileName.endsWith(".txt");
		}
	}
	
	private static void mergeAll() throws Exception{
		File file = new File(basicDir);
		File fileAll = new File("E:/test/女黑侠木兰花系列合集.txt");
		
		BookFileFilter filter = new BookFileFilter();
		File[] listFiles = file.listFiles(filter);
		
		Arrays.sort(listFiles, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				String n1 = o1.getName().split("-")[0];
				String n2 = o2.getName().split("-")[0];
				Integer i1 = Integer.valueOf(n1);
				Integer i2 = Integer.valueOf(n2);
				return i1.compareTo(i2);
			}
		});
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileAll, true));
		BufferedReader br = null;
		String fileName = "";
		for(File f : listFiles){
			fileName = f.getName();
			fileName = fileName.substring(0, fileName.lastIndexOf(".") - 1);
			String[] temp = fileName.split("-");
			String juanNo = temp[0];
			int i = 0;
			
			String line = "";
			br = new BufferedReader(new FileReader(f));
			while(null != (line = br.readLine())){
				if(i++ == 0){
					line = "第" + juanNo + "卷  " + line;
				}
				bw.append(line);
				bw.newLine();
			}
			
		}
		bw.flush();
		
		if(bw != null){
			bw.close();
		}
		
	}


	public static void main(String[] args) {
		try {
			// test();
			// renameFile(basicDir);
			mergeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
