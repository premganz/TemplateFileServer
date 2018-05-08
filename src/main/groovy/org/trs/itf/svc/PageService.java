package org.trs.itf.svc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class PageService {
	boolean testMode=false;
	public String readUpPage(String scenario, String pageName){
		File f = null;
		StringBuffer buf = new StringBuffer();
		URL resourceUrl = getClass().getResource("/"+scenario+"/"+pageName+".txt");
		String resourcePath ="";
		if(testMode){
			return "hello test"; 
		}

		try {
			System.out.println("PageREader looks for  "+"/"+scenario+"/"+pageName+".txt");
			if(resourceUrl!=null && resourceUrl.toURI()!=null){
				resourcePath = resourceUrl.toURI().getPath();
			}else{
				return "URL not found";
			}
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		f= new File(resourcePath);
		FileReader reader;
		try {
			reader = new FileReader(f);
			BufferedReader readerBuf = new BufferedReader(reader);
			try {
				String line = readerBuf.readLine();
				while(line!=null){
					buf.append(line);
					buf.append("</br>");
					line = readerBuf.readLine();
				}

			} catch (Exception  e) {
				e.printStackTrace();
				buf.append("ERROR");
			}finally{
				try {
					readerBuf.close();
				} catch (IOException e) {
					e.printStackTrace();
					buf.append("ERROR");
				}
			}
		} catch (FileNotFoundException e1) {
			buf.append("FILE not found");
			e1.printStackTrace();
		}


		if(buf.toString().isEmpty()){
			buf.append("BLANK");
			buf.append("***EOL***");
		}
		return buf.toString();

	}

	
	public String readUpPageCached(String scenario, String pageName){
		File f = null;
		StringBuffer buf = new StringBuffer();
		//URL resourceUrl = getClass().getResource("/"+scenario+"/"+pageName+".txt");
		String resourcePath ="C:/cached";
		if(testMode){
			return "hello test"; 
		}

			System.out.println("PageREader looks for  "+"/"+scenario+"/"+pageName+".txt");
			
		f= new File(resourcePath+"/"+scenario+"/"+pageName+".txt");
		FileReader reader;
		try {
			reader = new FileReader(f);
			BufferedReader readerBuf = new BufferedReader(reader);
			try {
				String line = readerBuf.readLine();
				while(line!=null){
					buf.append(line);
					buf.append("</br>");
					line = readerBuf.readLine();
				}

			} catch (Exception  e) {
				e.printStackTrace();
				buf.append("ERROR");
			}finally{
				try {
					readerBuf.close();
				} catch (IOException e) {
					e.printStackTrace();
					buf.append("ERROR");
				}
			}
		} catch (FileNotFoundException e1) {
			buf.append("FILE not found");
			e1.printStackTrace();
		}


		if(buf.toString().isEmpty()){
			buf.append("BLANK");
			buf.append("***EOL***");
		}
		return buf.toString();

	}
	public void writePage(String scenario, String pageName, String content){
//		try {
//			content = UrlUtil.decode(content);
//		} catch (MalformedURLException e2) {
//			e2.printStackTrace();
//		} //chances are content is url encoded.
		File f = null;
		StringBuffer buf = new StringBuffer();
		URL resourceUrl = getClass().getResource("/cached");
		String resourcePath ="C:/cached";
		f= new File(resourcePath);
		FileWriter writer;

		System.out.println("PageWriter looks for  "+"/cached/"+scenario+"/"+pageName+".txt");

		f= new File(resourcePath+"/"+scenario+"/"+pageName+".txt");

		if(!f.exists())	{
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	

		}
		try {
			writer = new FileWriter(f);
			writer.write(content);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
		


	public List<String> readUpPageList(String scenario, String pageName){
		File f = null;
		ArrayList<String> resultList = new ArrayList<String>();
		URL resourceUrl = getClass().getResource("/"+scenario+"/"+pageName+".txt");
		String resourcePath;
		try {
			resourcePath = resourceUrl.toURI().getPath();
			f= new File(resourcePath);
			FileReader reader = new FileReader(f);
			BufferedReader readerBuf = new BufferedReader(reader);
			String line = readerBuf.readLine();
			while(line!=null){
				resultList.add(line);
				line = readerBuf.readLine();
			}

		} catch (Exception  e) {
			e.printStackTrace();
		}
		return resultList;
	}
}