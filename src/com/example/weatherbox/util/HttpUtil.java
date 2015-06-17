package com.example.weatherbox.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpUtil {
	
	public static void sendHttpRequest (final String address, final HttpCallBackListener listener) {
		new Thread(new Runnable() {
			HttpURLConnection con = null;
			StringBuilder response = null;
			InputStream in;
			BufferedReader br;
			@Override
			public void run() {
				try {
					URL url = new URL(address);
					con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("GET");
					con.setConnectTimeout(8000); 
					con.setReadTimeout(8000);
					InputStream in = con.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					String line;
					while ((line = br.readLine()) != null) {
						response.append(line);
					}
					if (listener != null) {
						listener.success(response.toString());
					}
				} catch (IOException e) {
					if (listener != null) {
						listener.error(e);
					}
				} finally {
					try {
						if (in != null) {
							in.close();
						}
						if (br != null) {
							br.close();
						}
						if (con != null) {
							con.connect();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}		
			}
		}).start();
	}
}
