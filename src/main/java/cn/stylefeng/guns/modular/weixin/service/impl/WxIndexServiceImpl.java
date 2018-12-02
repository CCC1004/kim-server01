package cn.stylefeng.guns.modular.weixin.service.impl;

import cn.stylefeng.guns.modular.system.dao.KimIndexJptjMapper;
import cn.stylefeng.guns.modular.system.dao.KimIndexLbMapper;
import cn.stylefeng.guns.modular.system.dao.KimIndexRmtpMapper;
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
    KimIndexJptjMapper kimIndexJptjMapper;

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

    /**
     * 获取精品推荐列表
     */
    @Override
    public List<Map<String,Object>> getJptjList() {
        List<Map<String,Object>> list = kimIndexJptjMapper.getJptjList();
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
