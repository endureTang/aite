package com.nj.service.thread;

import com.nj.service.base.system.StockCollectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class CollectThread extends Thread {
    private StockCollectService stockCollectService;
    private static Logger logger = LoggerFactory.getLogger(CollectThread.class);
    private String savePath;

    public StockCollectService getStockCollectService() {
        return stockCollectService;
    }

    public void setStockCollectService(StockCollectService stockCollectService) {
        this.stockCollectService = stockCollectService;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    @Override
    public void run() {
        try {
            logger.info(Thread.currentThread().getName() + ":汇总线程开始执行");
            stockCollectService.execCollect(savePath);
        } catch (Exception e) {
            logger.error(e + "");
        }
    }
}