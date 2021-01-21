	/*
 * COPYRIGHT. ShenZhen GreatVision Network Technology Co., Ltd. 2015.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen GreatVision Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * Apr 17, 2015    YangShengJun         Create the class
 */

package com.nj.service.base.system;

    import com.nj.core.base.dao.BaseDao;
    import com.nj.core.base.util.PageData;
    import com.nj.core.base.util.UuidUtil;
    import com.nj.dao.ActivityStockMapper;
    import com.nj.dao.extend.ActivityStockMapperExtend;
    import com.nj.model.generate.*;
    import org.apache.commons.lang.StringUtils;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    import javax.annotation.Resource;
    import java.util.List;
    import java.util.stream.Collectors;

    /**
    * @description: 活动商品service
    * @author endure
    * @date: 2021-01-19 9:32
     */ 
    @Transactional
    @Service("activityStockService")
    public class ActivityStockService {
        private static Logger logger = LoggerFactory.getLogger(ActivityStockService.class);
        @Resource(name = "BaseDao")
        private BaseDao dao;
        @Resource
        private ActivityStockMapperExtend activityStockMapperExtend;
        /**
        * @description: 批量保存
        * @param: [sotckNoStr]
        * @return: void
        * @author endure
        * @date: 2021-01-19 9:33
         */ 
        public void insertBath(List<String> stockNoStr,String fileName) {
            List<ActivityStock> activityStocks = stockNoStr.stream().map(stockNo -> {
                ActivityStock activityStock = new ActivityStock();
                activityStock.setId(UuidUtil.get32UUID());
                activityStock.setStockNo(stockNo);
                activityStock.setActivityName(fileName);
                return activityStock;
            }).collect(Collectors.toList());
            activityStockMapperExtend.insertBath(activityStocks);

        }

        public List<ActivityStock> list(PageData pd) throws Exception {
            if(pd != null){
                pd.put("start", pd.getInteger("start"));
                pd.put("length", pd.getInteger("length"));
            }
            return activityStockMapperExtend.selectPage(pd);
        }

        public int listAllCount(PageData pd) throws Exception {
            ActivityStockMapper activityStockMapper = dao.getMapper(ActivityStockMapper.class);
            String keyword = pd.getString("keyword");
            if(StringUtils.isNotEmpty(keyword)){
                ActivityStockExample example = new ActivityStockExample();
                example.createCriteria().andStockNoLike("%"+keyword+"%");
                return activityStockMapper.countByExample(example);
            }else{
                return activityStockMapper.countByExample(null);
            }
        }

        public void clearData() throws Exception {
            ActivityStockMapper activityStockMapper = dao.getMapper(ActivityStockMapper.class);
            activityStockMapper.deleteByExample(null);
        }


    }
