package cn.stylefeng.guns.modular.coin.service;

import cn.stylefeng.guns.modular.system.model.CoinKind;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

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

    List<Map<String, Object>> selectKindPage(Page page, String kindName, String kindValue, String flId);
}
