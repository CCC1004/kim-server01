package cn.stylefeng.guns.modular.weixin.service.impl;

import cn.stylefeng.guns.modular.system.dao.*;
import cn.stylefeng.guns.modular.weixin.service.WxIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: superC
 * @Date: 2018/11/17 11:06
 */
@Service
public class WxIndexServiceImpl implements WxIndexService {


    @Autowired
    KimIndexLbMapper kimIndexLbMapper;

    @Autowired
    CoinIndexLbMapper coinIndexLbMapper;

    @Autowired
    KimIndexJptjMapper kimIndexJptjMapper;

    @Autowired
    CoinIndexJpflMapper coinIndexJpflMapper;

    @Autowired
    KimIndexRmtpMapper kimIndexRmtpMapper;


    /**
     * 获取轮播图列表
     * @return
     */
    @Override
    public List<Map<String,Object>> getLbList() {

        List<Map<String,Object>> list = kimIndexLbMapper.getLbList();
        return list;
    }

    @Override
    public List<Map<String, Object>> getCoinLbList() {
        List<Map<String,Object>> list = coinIndexLbMapper.getCoinLbList();
        return list;
    }

    /**
     * 获取精品推荐列表
     */
    @Override
    public List<Map<String,Object>> getJptjList() {
        List<Map<String,Object>> list = kimIndexJptjMapper.getJptjList();
        return list;
    }

    @Override
    public List<Map<String,Object>> getCoinJptjList() {
        List<Map<String,Object>> list = coinIndexJpflMapper.getCoinJptjList();
        return list;
    }

    /**
     * 获取热门图片列表
     */
    @Override
    public List<Map<String,Object>> getRmtpList() {
        List<Map<String,Object>> list = kimIndexRmtpMapper.getRmtpList();
        return list;
    }
}
