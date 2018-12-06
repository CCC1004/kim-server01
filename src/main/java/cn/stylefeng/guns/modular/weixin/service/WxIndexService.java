package cn.stylefeng.guns.modular.weixin.service;


import cn.stylefeng.guns.modular.system.model.KimIndexJptj;
import cn.stylefeng.guns.modular.system.model.KimIndexLb;
import cn.stylefeng.guns.modular.system.model.KimIndexRmtp;

import java.util.List;
import java.util.Map;

/**
 * @Author: superC
 * @Date: 2018/11/17 11:05
 */
public interface WxIndexService {

    /**
     * 获取轮播图列表
     * @return
     */
    List<Map<String,Object>> getLbList();

    List<Map<String, Object>> getCoinLbList();


    /**
     * 获取精品推荐列表
     */
    List<Map<String,Object>> getJptjList();

    List<Map<String, Object>> getCoinJptjList();


    /**
     * 获取热门图片列表
     */
    List<Map<String,Object>> getRmtpList();



}

