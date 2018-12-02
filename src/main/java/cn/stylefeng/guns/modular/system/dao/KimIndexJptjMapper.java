package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.KimIndexJptj;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 精品推荐表 Mapper 接口
 * </p>
 *
 * @author superc
 * @since 2018-11-24
 */
public interface KimIndexJptjMapper extends BaseMapper<KimIndexJptj> {


    List<Map<String, Object>> getJptjList();
}
