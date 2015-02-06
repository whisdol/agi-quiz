/**
 * @ author Cedric Lüke
 * Inspired by: http://www.tutorialspoint.com/android/android_xml_parsers.htm
 */
package de.fhdw.gruppe2.quizapp.android.dbconnection;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;


public class HandleXML {
	private String mUrlString = null;
	private volatile boolean mParsingStillRunning = true;
	private Document mParsedDocument;

	public HandleXML(String url){
		this.mUrlString = url;
	}

	public boolean isParsingStillRunning() {
		return mParsingStillRunning;
	}
	
	public Document getmParsedDocument() {
		return mParsedDocument;
	}
	
	public void fetchXML(){
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					URL url = new URL(mUrlString);
					HttpURLConnection conn = (HttpURLConnection) 
							url.openConnection();
					conn.setReadTimeout(10000 /* milliseconds */);
					conn.setConnectTimeout(15000 /* milliseconds */);
					conn.setRequestMethod("GET");
					conn.setDoInput(true);
					conn.connect();
					InputStream stream = conn.getInputStream();

					DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
					DocumentBuilder db = dbf.newDocumentBuilder();
					mParsedDocument = db.parse(stream);
					mParsingStillRunning = false;
					stream.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		thread.start(); 
	}

}
