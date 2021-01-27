package com.nj.admin.controller.stockCollect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.nj.admin.xml.Address;
import com.nj.admin.xml.Person;
import com.nj.core.base.util.UuidUtil;
import com.nj.model.generate.ActivityStock;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @Package com.nj.admin.controller
 * @ClassName StockCollectLocalServcie
 * @Description:
 * @Date 2021年01月10:59
 * @Author endure
 */
@Component
public class ActivityServcie {

    @Resource
    private StockCollectModelOne stockCollectModelOne;
    @Resource
    private StockCollectModelTwo stockCollectModelTwo;
    @Resource
    private StockCollectModelThree stockCollectModelThree;



    public void saveXml(List<String> stockNoStr, String savePath) {
        System.out.println("保存活动列表开始");
        XStream xs = new XStream(new DomDriver());
        xs.alias("temp", ArrayList.class); // 类别名
        xs.alias("activity", ActivityStock.class);
        File file = new File(savePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File outFile = new File(file, "活动列表.xml");
        try {
            FileOutputStream fos = new FileOutputStream(outFile);
            OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("utf-8"));
            BufferedWriter bw = new BufferedWriter(osw);
            xs.toXML(stockNoStr, bw);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("保存活动列表成功");

    }

    public void clearData() {
    }


}
