package cn.stylefeng.guns.modular.coin.service;

import cn.stylefeng.guns.modular.system.model.CoinIndexJpfl;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 精品分类表 服务类
 * </p>
 *
 * @author superc
 * @since 2018-12-06
 */
public interface ICoinIndexJpflService extends IService<CoinIndexJpfl> {

    boolean deleteByIdAndRes(String coinIndexJpflId);

    List<Map<String,Object>> getCoinJptjPage(Page page, Wrapper<CoinIndexJpfl> wrapper);
}
