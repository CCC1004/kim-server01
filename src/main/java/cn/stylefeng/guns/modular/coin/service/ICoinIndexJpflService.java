package cn.stylefeng.guns.modular.coin.service;

import cn.stylefeng.guns.modular.system.model.CoinIndexJpfl;
import com.baomidou.mybatisplus.service.IService;

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
}
