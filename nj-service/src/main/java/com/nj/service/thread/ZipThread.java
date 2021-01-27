package com.nj.service.thread;

import com.nj.service.base.system.StockCollectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ZipThread extends Thread{
    private StockCollectService stockCollectService;
    private static Logger logger = LoggerFactory.getLogger(ZipThread.class);
    private String savePath;

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public StockCollectService getStockCollectService() {
        return stockCollectService;
    }

    public void setStockCollectService(StockCollectService stockCollectService) {
        this.stockCollectService = stockCollectService;
    }

    @Override
    public void run() {
        try {
            logger.info(Thread.currentThread().getName()+":压缩线程开始执行");
            stockCollectService.selectDownLoadZipList(savePath);
        } catch (Exception e) {
            logger.error(e+"");
        }
    }

}