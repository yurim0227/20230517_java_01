//package kh.lclass.openapi.controller;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//import kh.lclass.openapi.model.vo.EvInfoVo;
//
//public class MetalMeasuringController {
//	public static void main(String[] args) throws IOException {
//		int failCnt = 0;
//		for(int i = 0; i < 1; i++) {
//			HttpURLConnection conn = null;
//			try {
//				StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1480523/MetalMeasuringResultService/MetalService"); /*URL*/
//				urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=t0AUyWBLB4/6G8QnmNB9b9EFoBQkHSVO/L0Rdx6f4FbNjsi/D8jmfiKA6vxXbTS8N4zDjeYUpww2/g3LMoI0yQ=="); /*Service Key*/
//				urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//				urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//				urlBuilder.append("&" + URLEncoder.encode("resultType", "UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); /*결과형식(XML/JSON)*/
//				urlBuilder.append("&" + URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode("20230107", "UTF-8")); /*검색조건 날짜 (예시 : 20171208)*/
//				urlBuilder.append("&" + URLEncoder.encode("stationcode", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*검색조건 측정소코드*/
//				urlBuilder.append("&" + URLEncoder.encode("itemcode", "UTF-8") + "=" + URLEncoder.encode("90303", "UTF-8")); /*검색조건 항목코드*/
//				urlBuilder.append("&" + URLEncoder.encode("timecode", "UTF-8") + "=" + URLEncoder.encode("RH02", "UTF-8")); /*검색조건 시간구분*/
//				URL url = new URL(urlBuilder.toString());
//				conn = (HttpURLConnection) url.openConnection();
//				conn.setRequestMethod("GET");
//				conn.setRequestProperty("Content-type", "application/json");
//				System.out.println("Response code: " + conn.getResponseCode());
//
//				// XML parse 통해서 VO 형태에 담기
//
////				BufferedReader rd;
////				if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
////					rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
////				} else {
////					rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
////				}
////				StringBuilder sb = new StringBuilder();
////				String line;
////				while ((line = rd.readLine()) != null) {
////					sb.append(line);
////				}
////				rd.close();
//				conn.disconnect();
////				System.out.println(sb.toString());
//				
//				// TODO sb 안에 100개의 데이터가 xml형태로 들어있음. ---> EvInfoVo 형태로 바꿔서 evInfoList.add..
//		        Document doc = parseXML(conn.getInputStream());
//		        //a. item 태그객체 목록으로 가져온다.
//		        NodeList descNodes = doc.getElementsByTagName("item");
//		        //c. 각 item태그의 자식태그에서 정보 가져오기
//		        for(int j = 0; j < descNodes.getLength(); j++) {
//		        	EvInfoVo vo = new EvInfoVo();
//		        	
//		        	//item
//		        	Node item = descNodes.item(j);
//		        	//item 자식태그에 순차적으로 접근
//		        	for( Node node=item.getFirstChild();	// 초기식
//		        			node!=null;	// 조건식 T/F
//		        			node=node.getNextSibling()	// 증감식
//		        			// 첫번째 자식을 시작으로 마지막까지 다음 형제를 실행
//		        		) {
//		        		//System.out.println(node.getNodeName() + " : " + node.getTextContent());
//		        		switch(node.getNodeName()) {
//		        		case "chargeTp":
//		        			try {
//		        				vo.setChargeTp(Integer.parseInt(node.getTextContent()));
//		        			}catch (NumberFormatException e) {
//		        			}
//		        			break;
//		        		case "cpId":
//		        			vo.setCpId(node.getTextContent());
//		        			break;
//		        		case "cpNm":
//		        			vo.setCpNm(node.getTextContent());
//		        			break;
//		        		case "csNm":
//		        			vo.setCsNm(node.getTextContent());
//		        			break;
//		        		// TODO
//		        		}
//		        		// item 자식 node들 for
//		        	}
//		        	//evInfoList.add(vo);
//		        	// item 개수만큼 for
//		        }
//		        // TODO: File에 저장
//		        System.out.println(/*evInfoList*/);
//			} catch(IOException e) {
//				// 오류발생
////				failCnt--;
////				i--;
////				if(failCnt<0) {
////					break;
////				}
//				if(failCnt==0) {
//					break;
//				}
//				failCnt--;
//				i--;
//				e.printStackTrace();
//			} finally {
//				try {
//					if(conn!=null)conn.disconnect();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
//	private Document parseXML(InputStream stream) {
//		// Factory Pattern
//		DocumentBuilderFactory objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder objDocumentBuilder = null;
//		Document doc = null;
//		try {
//			objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
//			doc = objDocumentBuilder.parse(stream);
//		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//		} catch (SAXException e) { // Simple API for XML
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return doc;
//	}
//}

package kh.lclass.openapi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MetalMeasuringController {
	
	 public static void main(String[] args) throws IOException {
	        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1480523/MetalMeasuringResultService/MetalService"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=t0AUyWBLB4/6G8QnmNB9b9EFoBQkHSVO/L0Rdx6f4FbNjsi/D8jmfiKA6vxXbTS8N4zDjeYUpww2/g3LMoI0yQ=="); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); /*결과형식(XML/JSON)*/
	        urlBuilder.append("&" + URLEncoder.encode("date","UTF-8") + "=" + URLEncoder.encode("20230107", "UTF-8")); /*검색조건 날짜 (예시 : 20171208)*/
	        urlBuilder.append("&" + URLEncoder.encode("stationcode","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*검색조건 측정소코드*/
	        urlBuilder.append("&" + URLEncoder.encode("itemcode","UTF-8") + "=" + URLEncoder.encode("90303", "UTF-8")); /*검색조건 항목코드*/
	        urlBuilder.append("&" + URLEncoder.encode("timecode","UTF-8") + "=" + URLEncoder.encode("RH02", "UTF-8")); /*검색조건 시간구분*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        
	        // XML parse 통해서 VO 형태에 담기
	        
	        
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
