package io.github.johncipponeri.outpanapi;

import io.github.johncipponeri.outpanapi.android.AndroidBase64;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

public class OutpanAPI {
	
	private String api_key;
	
	public OutpanAPI(String api_key) {
		this.api_key = api_key;
	}
	
	private JSONObject executeGet(String barcode) {
		return executeGet(barcode, "");
	}
	
	private JSONObject executeGet(String barcode, String endpoint) {
		JSONObject jsonResult = new JSONObject();
		
		try {
			URL url = new URL("https://api.outpan.com/v1/products/" + barcode + endpoint);
			URLConnection uc = url.openConnection();
			
			String key = api_key + ":";
			String basicAuth = "Basic " + new String(AndroidBase64.encode(key.getBytes(), AndroidBase64.NO_WRAP));
			
			uc.setRequestProperty ("Authorization", basicAuth);
			
			InputStream in = uc.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			
			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			
			while ((numCharsRead = isr.read(charArray)) > 0)
				sb.append(charArray, 0, numCharsRead);

			jsonResult = new JSONObject(sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonResult;
	}
	
	public OutpanObject getProduct(String barcode) {
		return new OutpanObject(executeGet(barcode));
	}
	
	public OutpanObject getProductName(String barcode) {
		return new OutpanObject(executeGet(barcode, "/name"));
	}
	
	public OutpanObject getProductAttributes(String barcode) {
		return new OutpanObject(executeGet(barcode, "/attributes"));
	}
	
	public OutpanObject getProductImages(String barcode) {
		return new OutpanObject(executeGet(barcode, "/images"));
	}
	
	public OutpanObject getProductVideos(String barcode) {
		return new OutpanObject(executeGet(barcode, "/videos"));
	}
}