package cn.stylefeng.guns.modular.coin.service;

import cn.stylefeng.guns.modular.system.model.CoinKind;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 品种信息表 服务类
 * </p>
 *
 * @author superc
 * @since 2018-12-07
 */
public interface ICoinKindService extends IService<CoinKind> {


    boolean deleteKindAndRes(String coinKindId);
}
