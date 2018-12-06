package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.CoinIndexLb;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 轮播图信息 Mapper 接口
 * </p>
 *
 * @author superc
 * @since 2018-12-06
 */
public interface CoinIndexLbMapper extends BaseMapper<CoinIndexLb> {

    List<Map<String, Object>> getCoinLbList();

}
