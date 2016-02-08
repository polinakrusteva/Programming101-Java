package monday;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class FileDownload {

	public static void downloadWithHttpClient(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet target = new HttpGet(url);
		HttpResponse response = client.execute(target);
		HttpEntity entity = response.getEntity();

		BufferedInputStream in = new BufferedInputStream(entity.getContent());
		OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("/home/polinakk/Desktop/picture2")));
		int i;

		while ((i = in.read()) != -1) {
			out.write(i);
			out.flush();
		}

		in.close();
		out.close();
	}

	public static void downloadPicture(String url) throws IOException {
		URL picture = new URL(url);
		BufferedInputStream in = new BufferedInputStream(picture.openStream());
		OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("/home/polinakk/Desktop/picture")));
		int i;

		while ((i = in.read()) != -1) {
			out.write(i);
			out.flush();
		}

		in.close();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		downloadPicture("http://i.telegraph.co.uk/multimedia/archive/03235/potd-husky_3235255k.jpg");
		downloadWithHttpClient("http://i.kinja-img.com/gawker-media/image/upload/y6k2hs8svqdlp9vvewxt.jpg");
	}

}
