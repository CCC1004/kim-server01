package cn.stylefeng.guns.modular.coin.service;

import cn.stylefeng.guns.modular.system.model.CoinIndexLb;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 轮播图信息 服务类
 * </p>
 *
 * @author superc
 * @since 2018-12-06
 */
public interface ICoinIndexLbService extends IService<CoinIndexLb> {

    void deleteLbAndRes(String coinIndexLbId);

    List<Map<String, Object>> getCoinLbPage(Page page);
}
