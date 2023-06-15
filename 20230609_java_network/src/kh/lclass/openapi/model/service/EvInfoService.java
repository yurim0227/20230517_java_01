package kh.lclass.openapi.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import kh.lclass.openapi.model.vo.EvInfoVo;

public class EvInfoService extends Thread/* implements Runnable */{
	List<EvInfoVo> evInfoList = new ArrayList<EvInfoVo>();
	@Override
	public void run() {
		int failCnt = 3;	// 3회 재시도에도 실패되면 더이상 data 읽어오지 않도록 함.
		for(int i=0; i<34; i++) {
			BufferedReader rd = null;
			HttpURLConnection conn = null;
			StringBuilder sb = null;
			try {
				String serviceKey = "iYzMl6Rz%2BoMjtt0f5WbxOv7y71FPDVXugg6ti%2BmqF6kGRCXgnMv5x%2FjkOcUFttleqqUZpnO1QYzlTO5H8WDAkg%3D%3D";
		        StringBuilder urlBuilder = new StringBuilder("http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList"); /*URL*/
		        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+serviceKey); /*Service Key*/
		        //urlBuilder.append("?" + URLEncoder.encode("service Key","UTF-8") + "="+serviceKey); /*Service Key*/
		        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(String.valueOf(i+1), "UTF-8")); /*페이지번호*/
		        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
		        //urlBuilder.append("&" + URLEncoder.encode("addr","UTF-8") + "=" + URLEncoder.encode("전라남도 나주시 빛가람동 120", "UTF-8")); /*검색대상 충전소주소*/
		        System.out.println(urlBuilder);
		        
		        URL url = new URL(urlBuilder.toString());
		        conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Content-type", "application/json");
		        System.out.println("Response code: " + conn.getResponseCode());
		        
		        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        } else {
		            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		        }
		        sb = new StringBuilder();
		        String line;
		        while ((line = rd.readLine()) != null) {
		            sb.append(line);
		        }
			} catch(IOException e) {
				// 오류발생
//				failCnt--;
//				i--;
//				if(failCnt<0) {
//					break;
//				}
				if(failCnt==0) {
					break;
				}
				failCnt--;
				i--;
				e.printStackTrace();
			} finally {
				try {
					if(rd!=null)rd.close();
					if(conn!=null)conn.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println(sb.toString());
		}
	}
}
