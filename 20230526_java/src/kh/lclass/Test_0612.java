package kh.lclass;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test_0612 {
	public void saveFile() {
		String filename = "a.txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(filename);
			fw.write("Hello, World");
			fw.flush();
			return;
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void loadFile() {
		String filename = "b.txt";
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(filename);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			String str = null;
			while( (str = br.readLine()) != null ) {
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(isr != null) isr.close();
				if(fis != null) fis.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}
