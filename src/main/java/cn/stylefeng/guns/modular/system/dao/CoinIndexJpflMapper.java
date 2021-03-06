package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.CoinIndexJpfl;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 精品分类表 Mapper 接口
 * </p>
 *
 * @author superc
 * @since 2018-12-06
 */
public interface CoinIndexJpflMapper extends BaseMapper<CoinIndexJpfl> {

    List<Map<String, Object>> getCoinJptjList();

    List<Map<String,Object>> getCoinJptjPage(@Param("page") Page page);
}
