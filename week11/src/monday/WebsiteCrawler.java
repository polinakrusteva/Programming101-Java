package monday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.sound.sampled.Port;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class WebsiteCrawler {

	private static Pattern fmiSitePattern = Pattern.compile("^http://www.fmi.uni-sofia.bg/.*$");

	private static String getContent(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet target = new HttpGet(url);
		HttpResponse response = client.execute(target);
		HttpEntity entity = response.getEntity();
		BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}
		in.close();
		return sb.toString();
	}

	private static List<String> getAllLinks(String content) {
		ArrayList<String> resultList = new ArrayList<>();
		String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			resultList.add(matcher.group(1));
		}
		return resultList;
	}

	public static void crawl(String url, String needle) throws ClientProtocolException, IOException {
		String content = getContent(url);
		List<String> links = getAllLinks(content);
		HashSet<String> visited = new HashSet<>();
		if (content.contains(needle)) {
			System.out.println(url);
			return;
		}
		for (String link : links) {
			if (!fmiSitePattern.matcher(link).matches()) {
				continue;
			}
			if (visited.contains(link)) {
				continue;
			}
			visited.add(link);
			content = getContent(link);
			if (content.contains(needle)) {
				System.out.println(link);
				return;
			}
		}
	}

	public static void main(String[] args) throws ClientProtocolException, IOException {
		crawl("http://www.fmi.uni-sofia.bg/", "показани");
	}
}
