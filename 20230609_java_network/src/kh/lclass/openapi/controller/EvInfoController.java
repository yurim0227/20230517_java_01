package kh.lclass.openapi.controller;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class EvInfoController {
    public static void main(String[] args) throws IOException {
    	byte[] barr = new byte[1000];
    	String a =new String(barr);
    	//String b = new String("http://,,,,,,");
    	
    	String str = new String("http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList");
    	str += "?serviceKey=iYzMl6Rz%2BoMjtt0f5WbxOv7y71FPDVXugg6ti%2BmqF6kGRCXgnMv5x%2FjkOcUFttleqqUZpnO1QYzlTO5H8WDAkg%3D%3D";
    	str += "&pageNo=1";
    	str += "&numOfRows=10";
    	//str += "&addr=전라남도 나주시 빛가람동 120";
    	str += "&addr="+URLEncoder.encode("전라남도 나주시 빛가람동 120", "UTF-8");
    	System.out.println(str);
    	System.out.println("===============");
    	
        StringBuilder urlBuilder = new StringBuilder("http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=iYzMl6Rz%2BoMjtt0f5WbxOv7y71FPDVXugg6ti%2BmqF6kGRCXgnMv5x%2FjkOcUFttleqqUZpnO1QYzlTO5H8WDAkg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("addr","UTF-8") + "=" + URLEncoder.encode("전라남도 나주시 빛가람동 120", "UTF-8")); /*검색대상 충전소주소*/
        System.out.println(urlBuilder);
        System.out.println("===============");
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}
