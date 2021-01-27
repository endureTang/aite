package com.nj.admin.controller.stockCollect;

import com.nj.model.generate.StockCollect;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import org.junit.Test;
 
/**
 * 使用xstream工具包
 * 导入xpp3_min-1.1.4c和xstream-1.4.9
 *
 * @author 三只坚果
 * @date 2019/9/2 11:33
 *
 * 代码简洁,超级方便,可以自己定义xml格式(适合做文件传输)
 */
 
public class XStreamTest {

    public static void test(){
        XStream xStream = new XStream(new Xpp3Driver());
        StockCollect collect = new StockCollect();
        collect.setStorage("test");
 
        //如果不取别名
      //  xStream.alias("person",Person.class); //可以根据自己的需要设置需要的xml文件格式
        xStream.useAttributeFor(StockCollect.class,"storage");
        String s = xStream.toXML(collect);//得到xml文件
        System.out.println(s);
      //  解析xml字符串
        StockCollect ps = (StockCollect) xStream.fromXML(s);//解析s
        System.out.println(ps);
    }

    public static void main(String[] args) {
        test();
    }
}