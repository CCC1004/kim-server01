package cn.stylefeng.guns.modular.weixin.service;


import cn.stylefeng.guns.core.common.constant.cache.Cache;
import cn.stylefeng.guns.core.common.constant.cache.CacheKey;
import cn.stylefeng.guns.modular.system.model.KimIndexJptj;
import cn.stylefeng.guns.modular.system.model.KimIndexLb;
import cn.stylefeng.guns.modular.system.model.KimIndexRmtp;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

/**
 * @Author: superC
 * @Date: 2018/11/17 11:05
 */
public interface WxIndexService {

    /**
     * 获取轮播图列表
     * @param dataType 数据类型：1：kim; 2:coin
     * @return
     */
    @Cacheable(value = Cache.INDEX, key = "'" + CacheKey.WX_INDEX_LB + "'+#dataType")
    List<Map<String,Object>> getLbList(String dataType);



    /**
     * 获取精品推荐列表
     */
    @Cacheable(value = Cache.INDEX, key = "'" + CacheKey.WX_INDEX_JP + "'+#dataType")
    List<Map<String,Object>> getJptjList(String dataType);



    /**
     * 获取热门图片列表
     */
    List<Map<String,Object>> getRmtpList();



}

