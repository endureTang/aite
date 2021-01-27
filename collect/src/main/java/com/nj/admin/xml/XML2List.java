package com.nj.admin.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
 
public class XML2List {

	public static void main(String args[]) {
		XStream xs = new XStream(new DomDriver());
		File file = new File("C:\\Users\\endure\\IdeaProjects\\aite\\collect\\src\\main\\webapp\\static\\upload\\xml\\activity/活动列表.xml");
		try {
			FileInputStream fis = new FileInputStream(file);
			xs.alias("temp", ArrayList.class); // 类别名
			xs.alias("stockNo", String.class);

			List<String> list = (List<String>) xs.fromXML(fis);
			for (String s : list) {
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}