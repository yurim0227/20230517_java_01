package kh.lclass.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TestInetAddress {
	public void testInetAddressEx() {
		// The constructor InetAddress() is not visible
		// 원인 생성자 없음.
		// 조치내용 : 1. singletone 확인. (주로 getInstance(), create() 메소드 지원 확인)
		// 2. static method 즉 클래스메소드 지원 확인.
		String host1 = "www.naver.com";
		String host2 = "www.google.com";
		String host3 = "www.oracle.com";
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		try {
			InetAddress loopbackAddr = InetAddress.getLoopbackAddress();
			System.out.println(loopbackAddr);
			
			InetAddress localIp = InetAddress.getLocalHost();
			System.out.println(localIp);	// DESKTOP-6CMMD13/192.168.10.14
			boolean isLoopback = localIp.isLoopbackAddress();
			System.out.println(isLoopback);
			System.out.println("=== localhost===");
			InetAddress lb = InetAddress.getByName("localhost");
			//System.out.println(lb.getAddress().toString());
			System.out.println(Arrays.toString(lb.getAddress()));
			boolean lbIsLoopback = lb.isLoopbackAddress();
			System.out.println(lbIsLoopback);
			
			byte[] localIpArr = localIp.getAddress();
			System.out.print("ip: ");
			for(int i = 0;i< localIpArr.length;i++) {
				if(localIpArr[i]<0) {
					System.out.print(localIpArr[i]+256);
				}
				else {
					System.out.print(localIpArr[i]);
				}
				if(i != localIpArr.length-1) {
					System.out.print(".");
				}
			}
			System.out.println();
			System.out.println(Arrays.toString(localIpArr));
			//byte[] byteArr = new byte[] {(223-256),(130-256),(195-256),11};
			byte[] byteArr = new byte[] {(byte)223,(byte)130,(byte)200,(byte)104};
			//byte[] byteArr = new byte[] {(byte)127,(byte)0,(byte)0,(byte)1};
			System.out.println(Arrays.toString(byteArr));
			InetAddress byte2Arr = InetAddress.getByAddress(byteArr);
			System.out.println(byte2Arr);	// /223.130.195.11
			String byte2Arr2HostName = byte2Arr.getHostName();
			System.out.println(byte2Arr2HostName);
			System.out.println(byte2Arr.getHostAddress());
			System.out.println("=====");
//			InetAddress ip = InetAddress.getByName(host1);
//			System.out.println(ip);
//			System.out.println(ip.toString());
			InetAddress[] ipAll = InetAddress.getAllByName(host1);
			System.out.println(Arrays.toString(ipAll));	// www.naver.com/223.130.200.104
			for(InetAddress ip : ipAll) {
				System.out.println(ip);	// www.naver.com/223.130.200.104
				System.out.println("====");
				System.out.println(ip.getHostName());
				//System.out.println(ip.getAddress());
				byte[] ipAddr = ip.getAddress();
				System.out.print("ip: ");
				for(int i = 0;i< ipAddr.length;i++) {
					if(ipAddr[i]<0) {
						System.out.print(ipAddr[i]+256);
					}
					else {
						System.out.print(ipAddr[i]);
					}
					if(i != ipAddr.length-1) {
						System.out.print(".");
					}
				}
				System.out.println();
				System.out.print("ip: ");
				int cnt = 0;
				for(byte item : ipAddr) {
					if(item<0) {
						System.out.print(item+256);
					}
					else {
						System.out.print(item);
					}
					if(cnt != ipAddr.length-1) {
						System.out.print(".");
					}
					cnt++;
					//System.out.println(i);
					//System.out.println(i+256);
					//System.out.println((int)i);
				}
				System.out.println();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
