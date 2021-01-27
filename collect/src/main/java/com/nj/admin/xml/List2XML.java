package com.nj.admin.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
 
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
 
public class List2XML {

	public static void main(String args[]) {
		XStream xs = new XStream(new DomDriver());
		Address address1 = new Address(001, "经三路", "450000");
		Address address2 = new Address(002, "朝阳区", "10000");
		List<Address> list = new ArrayList<Address>();
		list.add(address1);
		list.add(address2);
		Person person = new Person(001, 1, 26, "spark", list);
		xs.alias("person", Person.class); // 类别名
		xs.alias("address", Address.class);
		xs.aliasField("addressList", Person.class, "addList"); // 类成员别名
		xs.aliasField("addressId", Address.class, "id");
		xs.useAttributeFor(Address.class, "zipcode"); // 设置某个节点为父节点上的一个属性
		// xs.aliasField("ZipCode", Address.class, "zipcode");  与下面效果一样
		xs.aliasAttribute(Address.class, "zipcode", "ZipCode");
		File file = new File("D:/log/List2XML.xml");
		if (!file.exists() || !file.isDirectory()) {
			String location = file.getAbsolutePath();
			String[] arry = location.split("\\\\");
			File file1 = new File(arry[0] + "/" + arry[1]);
			file1.mkdir();
		}
		try {
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("utf-8"));
			BufferedWriter bw = new BufferedWriter(osw);
			xs.toXML(person, bw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}